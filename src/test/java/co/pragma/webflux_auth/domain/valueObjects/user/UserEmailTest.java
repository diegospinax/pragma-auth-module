package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserEmailTest {

    String exceptionMessage = "Invalid email provided.";

    @Test
    public void invalidEmail() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserEmail("aeiou@.com");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void validEmail() {
        UserEmail userEmail = new UserEmail("d@mail.com");
        Assertions.assertEquals("d@mail.com", userEmail.value);
    }
}
