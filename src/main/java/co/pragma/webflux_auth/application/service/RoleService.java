package co.pragma.webflux_auth.application.service;

import co.pragma.webflux_auth.application.dto.role.SaveRoleDto;
import co.pragma.webflux_auth.application.ports.in.role.CreateRoleUseCase;
import co.pragma.webflux_auth.application.ports.in.role.DeleteRoleUseCase;
import co.pragma.webflux_auth.application.ports.in.role.FindRoleUseCase;
import co.pragma.webflux_auth.application.ports.in.role.UpdateRoleUseCase;
import co.pragma.webflux_auth.application.ports.out.RoleRepository;
import co.pragma.webflux_auth.application.service.exception.DataIntegrationValidationException;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RoleService implements CreateRoleUseCase, FindRoleUseCase, UpdateRoleUseCase, DeleteRoleUseCase {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Mono<Role> createRole(Role role) {
        return roleRepository.findByName(role.name())
                .hasElement()
                .flatMap(exists -> {
                    if(exists) {
                        return Mono.error(new DataIntegrationValidationException("Role already exists."));
                    }
                    return roleRepository.createRole(role);
                });
    }

    @Override
    public Mono<Void> deleteRole(Long roleId) {
        return roleRepository.findById(roleId)
                .switchIfEmpty(Mono.error(new DataIntegrationValidationException("Role not found.")))
                .flatMap(role -> roleRepository.deleteRole(role.id()));
    }

    @Override
    public Flux<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Mono<Role> findById(Long roleId) {
        return roleRepository.findById(roleId)
                .switchIfEmpty(Mono.error(new DataIntegrationValidationException("Role not found.")));
    }

    @Override
    public Mono<Role> findByName(RoleName name) {
        return roleRepository.findByName(name)
                .switchIfEmpty(Mono.error(new DataIntegrationValidationException("Role not found.")));
    }

    @Override
    public Mono<Role> updateRole(Long roleId, SaveRoleDto roleDto) {
        return null;
    }
}
