package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserSalary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserSalaryTest {

    @Test
    public void nullTest() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserSalary(null);
        });
        Assertions.assertEquals("Salary is required.", exception.getMessage());
    }

    @Test
    public void invalidSalary() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserSalary(15_000_000.1);
        });
        Assertions.assertEquals("Invalid salary provided.", exception.getMessage());
    }

    @Test
    public void validSalary () {
        UserSalary userSalary = new UserSalary(4_500_000d);
        Assertions.assertEquals(4500000.0, userSalary.value);
    }
}
