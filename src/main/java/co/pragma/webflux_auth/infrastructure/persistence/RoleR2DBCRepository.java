package co.pragma.webflux_auth.infrastructure.persistence;

import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import co.pragma.webflux_auth.infrastructure.persistence.entities.RoleEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface RoleR2DBCRepository extends R2dbcRepository<RoleEntity, Long> {

    Mono<RoleEntity> findByName(String name);
}
