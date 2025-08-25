package co.pragma.webflux_auth.infrastructure.mapper;

import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.application.dto.SaveUserDto;
import co.pragma.webflux_auth.application.dto.ResponseUserDto;
import co.pragma.webflux_auth.infrastructure.mapper.support.MapFromDomain;
import co.pragma.webflux_auth.infrastructure.mapper.support.ValueObjectMappers;
import co.pragma.webflux_auth.infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ValueObjectMappers.class })
public interface UserMapper {

    @MapFromDomain
    UserEntity domainToEntity(User user);

    @MapFromDomain
    ResponseUserDto toResponseDto(User user);

    @Mapping(target = "name", qualifiedByName = "toUserName")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    User createDtoToDomain(SaveUserDto dto);

    @Mapping(target = "name", qualifiedByName = "toUserName")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    User entityToDomain(UserEntity entity);

}
