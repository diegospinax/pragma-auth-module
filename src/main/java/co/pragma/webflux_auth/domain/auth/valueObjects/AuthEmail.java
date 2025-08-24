package co.pragma.webflux_auth.domain.auth.valueObjects;

import co.pragma.webflux_auth.domain.auth.exception.AuthValidationException;

public class AuthEmail extends AuthField {
    public AuthEmail(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!value.matches(regex)) {
            throw new AuthValidationException("Invalid email provided.");
        }
    }
}
