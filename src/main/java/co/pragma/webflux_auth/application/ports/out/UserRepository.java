package co.pragma.webflux_auth.application.ports.out;

import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> createUser(User user);
    Flux<User> findAll();
    Mono<User> findById(Long userId);
    Mono<User> findByEmail(UserEmail email);
    Mono<User> updateUser(User user);
    Mono<Void> deleteUser(Long userId);
}
