package co.pragma.webflux_auth.application.service;

import co.pragma.webflux_auth.application.dto.user.SaveUserDto;
import co.pragma.webflux_auth.application.ports.in.user.CreateUserUseCase;
import co.pragma.webflux_auth.application.ports.in.user.DeleteUserUseCase;
import co.pragma.webflux_auth.application.ports.in.user.FindUserUseCase;
import co.pragma.webflux_auth.application.ports.in.user.UpdateUserUseCase;
import co.pragma.webflux_auth.application.ports.out.RoleRepository;
import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.application.service.support.UserUpdateHelper;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserService implements CreateUserUseCase, FindUserUseCase, UpdateUserUseCase, DeleteUserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.findByEmail(user.email())
                .hasElement()
                .flatMap(exists -> {
                    if (exists)
                        return Mono.error(new RuntimeException("Email already registered."));

                    return userRepository.createUser(user);
                });
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> findById(Long userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exists.")));
    }

    @Override
    public Mono<User> findByEmail(UserEmail email) {
        return userRepository.findByEmail(email)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exists.")));
    }

    @Override
    public Mono<User> updateUser(Long userId, SaveUserDto userDto) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exists.")))
                .flatMap(existingUser -> {
                    Mono<User> updatedUserMono = updateUserFieldsFromSaveDto(existingUser, userDto);
                    return updatedUserMono
                            .flatMap(updatedUser -> validateEmailAvailable(updatedUser, existingUser))
                            .flatMap(user -> userRepository.updateUser(user));
                });
    }

    private Mono<User> updateUserFieldsFromSaveDto(User user, SaveUserDto userDto) {
        UserUpdateHelper updateHelper = new UserUpdateHelper();
        if (userDto.roleId() == null) {
            return Mono.just(updateHelper.updateFields(user, userDto, user.role()));
        }
        return roleRepository.findById(userDto.roleId())
                .switchIfEmpty(Mono.error(new RuntimeException("Role does not exists.")))
                .map(role -> updateHelper.updateFields(user, userDto, role));

    }

    private Mono<User> validateEmailAvailable(User updatedUser, User existingUser) {
        if (existingUser.email().value.equals(updatedUser.email().value)) {
            return Mono.just(updatedUser);
        }
        return userRepository.findByEmail(updatedUser.email())
                .hasElement()
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new RuntimeException("Email already registered."));
                    }
                    return Mono.just(updatedUser);
                });
    }

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exists.")))
                .flatMap(user -> userRepository.deleteUser(user.id()));
    }
}
