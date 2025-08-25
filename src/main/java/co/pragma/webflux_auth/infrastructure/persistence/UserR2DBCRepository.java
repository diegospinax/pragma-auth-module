package co.pragma.webflux_auth.infrastructure.persistence;

import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface UserR2DBCRepository extends R2dbcRepository<UserEntity, Long> {

    Mono<UserEntity> findByEmail(String email);

    @Query("SELECT * from users ORDER BY id")
    Flux<UserEntity> findAll();
}
