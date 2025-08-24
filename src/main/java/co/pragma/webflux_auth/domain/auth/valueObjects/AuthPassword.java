package co.pragma.webflux_auth.domain.auth.valueObjects;

import co.pragma.webflux_auth.domain.auth.exception.AuthValidationException;

public class AuthPassword extends AuthField {
    public AuthPassword(String value) {
        super(value);
    }

    @Override
    public void validate() {
        if(value.length() < 8 || value.isBlank()) {
            throw new AuthValidationException("Invalid password provided.");
        }
    }
}
