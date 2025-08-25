package co.pragma.webflux_auth.domain.valueObjects.role;

import co.pragma.webflux_auth.domain.role.exception.RoleValidationException;
import co.pragma.webflux_auth.domain.role.valueObjects.RoleName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleNameTest {

    @Test
    public void nullTest() {
        Exception exception = Assertions.assertThrows(RoleValidationException.class, () -> {
            new RoleName(null);
        });

        Assertions.assertEquals("Role name is required.", exception.getMessage());
    }

    @Test
    public void invalidRoleDescriptionProvidedTest() {
        Exception exception = Assertions.assertThrows(RoleValidationException.class, () -> {
            new RoleName("");
        });

        Assertions.assertEquals("Role must contain only letters and underscore.", exception.getMessage());
    }

    @Test
    public void validRoleDescriptionTest() {
        RoleName name = new RoleName("EMPLOYEE_ROLE");
        Assertions.assertEquals("EMPLOYEE_ROLE", name.value);
    }
}
