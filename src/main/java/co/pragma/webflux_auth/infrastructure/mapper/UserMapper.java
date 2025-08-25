package co.pragma.webflux_auth.infrastructure.mapper;

import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.application.dto.user.SaveUserDto;
import co.pragma.webflux_auth.application.dto.user.ResponseUserDto;
import co.pragma.webflux_auth.infrastructure.mapper.support.UserMapFromDomain;
import co.pragma.webflux_auth.infrastructure.mapper.support.UserMapToResponse;
import co.pragma.webflux_auth.infrastructure.mapper.support.UserValueObjectMappers;
import co.pragma.webflux_auth.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserValueObjectMappers.class })
public interface UserMapper {

    @UserMapFromDomain
    UserEntity domainToEntity(User user);

    @UserMapToResponse
    ResponseUserDto toResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", qualifiedByName = "toUserName", source = "dto.name")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    @Mapping(target = "role", source = "role")
    User createDtoToDomain(SaveUserDto dto, Role role);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", qualifiedByName = "toUserName", source = "entity.name")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    @Mapping(target = "role", source = "role")
    User entityToDomain(UserEntity entity, Role role);

}
