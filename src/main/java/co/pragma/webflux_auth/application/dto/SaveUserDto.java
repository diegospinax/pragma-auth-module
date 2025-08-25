package co.pragma.webflux_auth.application.dto;

import java.time.LocalDate;

public record SaveUserDto(
        String name,
        String lastname,
        LocalDate dateBirth,
        String address,
        String phoneNumber,
        String email,
        Double salary
) {
}
