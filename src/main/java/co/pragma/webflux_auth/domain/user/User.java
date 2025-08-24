package co.pragma.webflux_auth.domain.user;

import co.pragma.webflux_auth.domain.auth.Auth;
import co.pragma.webflux_auth.domain.user.valueObjects.*;

public record User(
        Long id,
        Auth auth,
        UserName name,
        UserLastName lastName,
        UserDateBirth dateBirth,
        UserAddress address,
        UserPhoneNumber phoneNumber,
        UserEmail email,
        UserSalary salary
) {
}
