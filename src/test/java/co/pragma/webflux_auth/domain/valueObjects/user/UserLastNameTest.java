package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.valueObjects.UserLastName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserLastNameTest {

    private final String exceptionMessage = "Lastnames must contain only letters and underscore between them.";

    @Test
    public void correctLastnameTest () {
        UserLastName userLastName = new UserLastName("Giraldo_Gonzáles");
        Assertions.assertEquals("GIRALDO_GONZÁLES", userLastName.value);
    }

    @Test
    public void emptyLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastName("");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void multipleSpacesLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastName(" Giraldo");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void numbersInLastnameTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
           new UserLastName("Giraldo123");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void maxTwoLastnamesTest () {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserLastName("Giraldo_Gonzáles_Suárez");
        });
        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }
}
