package co.pragma.webflux_auth.domain.user;

import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.domain.user.valueObjects.*;

public record User(
        Long id,
        UserName name,
        UserLastname lastname,
        UserDateBirth dateBirth,
        UserAddress address,
        UserPhoneNumber phoneNumber,
        UserEmail email,
        UserSalary salary,
        Role role
) {
}
