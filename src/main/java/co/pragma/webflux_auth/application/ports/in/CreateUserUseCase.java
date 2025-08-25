package co.pragma.webflux_auth.application.ports.in;

import co.pragma.webflux_auth.domain.user.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {
    Mono<User> createUser(User user);
}
