package co.pragma.webflux_auth.infrastructure.mapper.support;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "name", source = "name.value")
@Mapping(target = "lastname", source = "lastname.value")
@Mapping(target = "dateBirth", source = "dateBirth.value")
@Mapping(target = "address", source = "address.value")
@Mapping(target = "phoneNumber", source = "phoneNumber.value")
@Mapping(target = "email", source = "email.value")
@Mapping(target = "salary", source = "salary.value")
@Mapping(target = "role.id", source = "role.id")
@Mapping(target = "role.name", source = "role.name.value")
@Mapping(target = "role.description", source = "role.description.value")
public @interface UserMapToResponse {

}
