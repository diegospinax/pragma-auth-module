package co.pragma.webflux_auth.application.ports.in.role;

import reactor.core.publisher.Mono;

public interface DeleteRoleUseCase {
    Mono<Void> deleteRole(Long roleId);
}
