package co.pragma.webflux_auth.application.ports.in;

import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindUserUseCase {
    Flux<User> findAll();
    Mono<User> findById(Long userId);
    Mono<User> findByEmail(UserEmail email);
}
