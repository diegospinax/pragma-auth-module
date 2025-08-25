package co.pragma.webflux_auth.application.ports.in.role;

import co.pragma.webflux_auth.application.dto.role.SaveRoleDto;
import co.pragma.webflux_auth.domain.role.Role;
import reactor.core.publisher.Mono;

public interface UpdateRoleUseCase {
    Mono<Role> updateRole(Long roleId, SaveRoleDto roleDto);
}
