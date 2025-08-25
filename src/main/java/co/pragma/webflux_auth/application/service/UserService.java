package co.pragma.webflux_auth.application.service;

import co.pragma.webflux_auth.application.dto.SaveUserDto;
import co.pragma.webflux_auth.application.ports.in.*;
import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserService implements CreateUserUseCase, FindUserUseCase, UpdateUserUseCase, DeleteUserUseCase {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
                .flatMap(user -> {
                    User updatedUser = handleUpdateUserFromSaveDto(user, userDto);
                    if (user.email() != updatedUser.email()) {
                        return userRepository.findByEmail(updatedUser.email())
                                .hasElement()
                                .flatMap(exists -> {
                                    if (exists) {
                                        return Mono.error(new RuntimeException("Email already registered."));
                                    }
                                    return userRepository.updateUser(updatedUser);
                                });
                    }
                    return userRepository.updateUser(updatedUser);
                });
    }

    private User handleUpdateUserFromSaveDto(User user, SaveUserDto userDto) {
        return new User(
                user.id(),
                userDto.name() != null ? new UserName(userDto.name()) : user.name(),
                userDto.lastname() != null ? new UserLastname(userDto.lastname()) : user.lastname(),
                userDto.dateBirth() != null ? new UserDateBirth(userDto.dateBirth()) : user.dateBirth(),
                userDto.address() != null ? new UserAddress(userDto.address()) : user.address(),
                userDto.phoneNumber() != null ? new UserPhoneNumber(userDto.phoneNumber()) : user.phoneNumber(),
                userDto.email() != null ? new UserEmail(userDto.email()) : user.email(),
                userDto.salary() != null ? new UserSalary(userDto.salary()) : user.salary()
        );
    }

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User does not exists.")))
                .flatMap(user -> userRepository.deleteUser(user.id()));
    }
}
