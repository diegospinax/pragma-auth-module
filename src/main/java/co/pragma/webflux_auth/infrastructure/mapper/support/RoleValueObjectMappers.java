package co.pragma.webflux_auth.infrastructure.mapper.support;

import co.pragma.webflux_auth.domain.role.valueObjects.RoleDescription;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RoleValueObjectMappers {
    @Named("toRoleName")
    default RoleName toRoleName(String name){
        return new RoleName(name);
    }

    @Named("toRoleDescription")
    default RoleDescription toRoleDescription(String description) {
        return new RoleDescription(description);
    }
}
