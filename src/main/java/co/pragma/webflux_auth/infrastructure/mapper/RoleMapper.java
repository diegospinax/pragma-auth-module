package co.pragma.webflux_auth.infrastructure.mapper;

import co.pragma.webflux_auth.application.dto.role.ResponseRoleDto;
import co.pragma.webflux_auth.application.dto.role.SaveRoleDto;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.infrastructure.mapper.support.RoleMapFromDomain;
import co.pragma.webflux_auth.infrastructure.mapper.support.RoleValueObjectMappers;
import co.pragma.webflux_auth.infrastructure.persistence.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleValueObjectMappers.class})
public interface RoleMapper {

    @RoleMapFromDomain
    RoleEntity domainToEntity(Role role);

    @Mapping(target = "name", qualifiedByName = "toRoleName")
    @Mapping(target = "description", qualifiedByName = "toRoleDescription")
    Role entityToDomain(RoleEntity entity);


    @Mapping(target = "name", qualifiedByName = "toRoleName")
    @Mapping(target = "description", qualifiedByName = "toRoleDescription")
    Role createDtoToDomain(SaveRoleDto saveRoleDto);

    @RoleMapFromDomain
    ResponseRoleDto domainToResponse(Role role);
}
