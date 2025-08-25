package co.pragma.webflux_auth.infrastructure.adapters.out;

import co.pragma.webflux_auth.application.ports.in.role.FindRoleUseCase;
import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import co.pragma.webflux_auth.infrastructure.mapper.UserMapper;
import co.pragma.webflux_auth.infrastructure.persistence.UserR2DBCRepository;
import co.pragma.webflux_auth.infrastructure.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserR2DBCRepository repository;
    private final FindRoleUseCase findRoleUseCase;
    private final UserMapper mapper;

    public UserRepositoryAdapter(UserR2DBCRepository repository, FindRoleUseCase findRoleUseCase, UserMapper mapper) {
        this.repository = repository;
        this.findRoleUseCase = findRoleUseCase;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Mono<User> createUser(User user) {
        UserEntity userEntity = mapper.domainToEntity(user);
        return repository.save(userEntity)
                .flatMap(entity -> {
                    Mono<Role> roleMono = findRoleUseCase.findById(entity.getRoleId());

                    return roleMono
                            .map(role -> mapper.entityToDomain(entity, role));
                });
    }

    @Override
    public Flux<User> findAll() {
        return repository.findAll()
                .flatMap(entity -> {
                    Mono<Role> roleMono = findRoleUseCase.findById(entity.getRoleId());

                    return roleMono
                            .map(role -> mapper.entityToDomain(entity, role));
                });
    }

    @Override
    public Mono<User> findById(Long userId) {
        return repository.findById(userId)
                .flatMap(entity -> {
                    Mono<Role> roleMono = findRoleUseCase.findById(entity.getRoleId());

                    return roleMono
                            .map(role -> mapper.entityToDomain(entity, role));
                });
    }

    @Override
    public Mono<User> findByEmail(UserEmail email) {
        return repository.findByEmail(email.value)
                .flatMap(entity -> {
                    Mono<Role> roleMono = findRoleUseCase.findById(entity.getRoleId());

                    return roleMono
                            .map(role -> mapper.entityToDomain(entity, role));
                });
    }

    @Override
    @Transactional
    public Mono<User> updateUser(User user) {
        UserEntity userEntity = mapper.domainToEntity(user);
        return repository.save(userEntity)
                .flatMap(entity -> {
                    Mono<Role> roleMono = findRoleUseCase.findById(entity.getRoleId());

                    return roleMono
                            .map(role -> mapper.entityToDomain(entity, role));
                });
    }

    @Override
    public Mono<Void> deleteUser(Long userId) {
        return repository.deleteById(userId);
    }

}
