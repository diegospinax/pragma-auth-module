package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserSalary extends UserField<Double>{

    public UserSalary(Double value) {
        super(value);
    }

    @Override
    public void validate() {
        if(value < 0d || value > 15_000_000d) {
            throw new UserValidationException("Invalid salary provided.");
        }
    }
}
