package co.pragma.webflux_auth.application.dto.user;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SaveUserDto(
        String name,
        String lastname,
        LocalDate dateBirth,
        String address,
        String phoneNumber,
        String email,
        Double salary,
        @NotNull(message = "Role id is required.")
        Long roleId
) {
}
