package co.pragma.webflux_auth.application.ports.in.role;

import co.pragma.webflux_auth.domain.role.Role;
import reactor.core.publisher.Mono;

public interface CreateRoleUseCase {
    Mono<Role> createRole(Role role);
}
