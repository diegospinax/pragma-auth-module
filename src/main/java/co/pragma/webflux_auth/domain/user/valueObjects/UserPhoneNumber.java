package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserPhoneNumber extends UserField<String> {

    public UserPhoneNumber(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^\\d{10}$";
        if (!value.matches(regex)) {
            throw new UserValidationException("Invalid phone provided.");
        }
    }
}
