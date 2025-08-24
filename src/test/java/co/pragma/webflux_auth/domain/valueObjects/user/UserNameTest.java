package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.valueObjects.UserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserNameTest {

    private final String exceptionMessage = "Names must contain only letters and underscore between them.";

    @Test
    public void correctNameTest() {
        UserName userName = new UserName("diego_andrés");

        Assertions.assertEquals("DIEGO_ANDRÉS", userName.value);
    }

    @Test
    public void emptyNameTest() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserName("");
        });

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void multipleSpacesNameTest() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserName(" Diego");
        });

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void numbersInNameTest() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserName("Diego123");
        });

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void maxTwoNamesTest() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new UserName("Juan_Esteban_Camilo");
        });

        Assertions.assertEquals(exceptionMessage, exception.getMessage());
    }
}
