package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.valueObjects.UserLastname;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserLastnameTest {

    private final String exceptionMessage = "Lastnames must contain only letters and underscore between them.";

    @Test
    public void nullTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastname(null);
        });
        Assertions.assertEquals("Lastname is required.", exception.getMessage());
    }

    @Test
    public void correctLastnameTest () {
        UserLastname userLastName = new UserLastname("Giraldo_Gonzáles");
        Assertions.assertEquals("GIRALDO_GONZÁLES", userLastName.value);
    }

    @Test
    public void emptyLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastname("");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void multipleSpacesLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastname(" Giraldo");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void numbersInLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
           new UserLastname("Giraldo123");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void maxTwoLastnamesTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastname("Giraldo_Gonzáles_Suárez");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }
}
