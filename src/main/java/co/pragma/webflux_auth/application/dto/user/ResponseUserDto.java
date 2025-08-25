package co.pragma.webflux_auth.application.dto.user;

import co.pragma.webflux_auth.application.dto.role.ResponseRoleDto;

import java.time.LocalDate;

public record ResponseUserDto(
        Long id,
        String name,
        String lastname,
        LocalDate dateBirth,
        String address,
        String phoneNumber,
        String email,
        Double salary,
        ResponseRoleDto role
) {
}
