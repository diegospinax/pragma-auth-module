package co.pragma.webflux_auth.infrastructure.adapters.out;

import co.pragma.webflux_auth.application.ports.out.RoleRepository;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import co.pragma.webflux_auth.infrastructure.mapper.RoleMapper;
import co.pragma.webflux_auth.infrastructure.persistence.RoleR2DBCRepository;
import co.pragma.webflux_auth.infrastructure.persistence.entities.RoleEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleR2DBCRepository repository;
    private final RoleMapper roleMapper;

    public RoleRepositoryAdapter(RoleR2DBCRepository repository, RoleMapper roleMapper) {
        this.repository = repository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public Mono<Role> createRole(Role role) {
        RoleEntity roleEntity = roleMapper.domainToEntity(role);
        return repository.save(roleEntity)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Flux<Role> findAll() {
        return repository.findAll()
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Role> findById(Long roleId) {
        return repository.findById(roleId)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Role> findByName(RoleName name) {
        return repository.findByName(name.value)
                .map(roleMapper::entityToDomain);
    }

    @Override
    @Transactional
    public Mono<Role> updateRole(Role role) {
        RoleEntity roleEntity = roleMapper.domainToEntity(role);
        return repository.save(roleEntity)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Void> deleteRole(Long roleId) {
        return repository.deleteById(roleId);
    }
}
