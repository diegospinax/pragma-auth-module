package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPhoneNumberTest {

    @Test
    public void nullTest () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserPhoneNumber(null);
        });
        Assertions.assertEquals("Phone number is required.", exception.getMessage());
    }

    @Test
    public void invalidPhoneNumberTest () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserPhoneNumber("12345");
        });
        Assertions.assertEquals("Invalid phone provided.", exception.getMessage());
    }

    @Test
    public void validPhoneNumberTest() {
        UserPhoneNumber userPhoneNumber = new UserPhoneNumber("3103920000");
        Assertions.assertEquals("3103920000", userPhoneNumber.value);
    }
}
