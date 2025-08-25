package co.pragma.webflux_auth.application.ports.in;

import reactor.core.publisher.Mono;

public interface DeleteUserUseCase {
    Mono<Void> deleteUser(Long userId);
}
