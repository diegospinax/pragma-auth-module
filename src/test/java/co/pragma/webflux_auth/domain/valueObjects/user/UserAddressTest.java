package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserAddress;
import co.pragma.webflux_auth.domain.user.valueObjects.support.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAddressTest {

    @Test
    public void validAddress() {
        UserAddress userAddress = new UserAddress(new Address("Colombia", "Medellin", "123", "#54-10"));
        Assertions.assertEquals("Colombia", userAddress.value.getCountry());
        Assertions.assertEquals("Medellin", userAddress.value.getCity());
        Assertions.assertEquals("123", userAddress.value.getStreetName());
        Assertions.assertEquals("#54-10", userAddress.value.getStreetNumber());
    }

    @Test
    public void invalidAddress () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress(new Address("Colombia123", "Manizales", "Alcalá", "#74-65"));
        });
        Assertions.assertEquals("Invalid address provided.", exception.getMessage());
    }


}
