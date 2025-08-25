package co.pragma.webflux_auth.application.ports.in.role;

import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindRoleUseCase {
    Flux<Role> findAll();
    Mono<Role> findById(Long roleId);
    Mono<Role> findByName(RoleName name);
}
