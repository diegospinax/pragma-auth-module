package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

import java.time.LocalDate;

public class UserDateBirth extends UserField<LocalDate> {

    public UserDateBirth(LocalDate value) {
        super(value);
    }

    @Override
    public void validate() {
        LocalDate now = LocalDate.now();
        if(value == null)
            throw new UserValidationException("Date of birth is required.");
        if (value.isEqual(now) || value.isAfter(now)) {
            throw new UserValidationException("Invalid date of birth.");
        }
    }
}
