package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserDateBirth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserDateBirthTest {

    @Test
    public void nullTest() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserDateBirth(null);
        });
        Assertions.assertEquals("Date of birth is required.", exception.getMessage());
    }

    @Test
    public void dateEqualsOrAfterNowTest() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserDateBirth(LocalDate.of(2026, 8, 23));
        });
        Assertions.assertEquals("Invalid date of birth.", exception.getMessage());
    }

    @Test
    public void validDateBirth() {
        UserDateBirth userDateBirth = new UserDateBirth(LocalDate.of(2025, 8, 22));
        Assertions.assertEquals(userDateBirth.value, LocalDate.of(2025, 8, 22));
    }
}
