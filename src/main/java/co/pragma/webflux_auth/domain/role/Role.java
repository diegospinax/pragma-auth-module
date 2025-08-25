package co.pragma.webflux_auth.domain.role;

import co.pragma.webflux_auth.domain.role.valueObjects.RoleDescription;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;

public record Role(
        Long id,
        RoleName name,
        RoleDescription description
) {
}
