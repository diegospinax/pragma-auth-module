package co.pragma.webflux_auth.domain.valueObjects.user;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.UserAddress;
import co.pragma.webflux_auth.domain.user.valueObjects.support.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAddressTest {

    @Test
    public void nullTest () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress(null);
        });
        Assertions.assertEquals("Address is required.", exception.getMessage());
    }

    @Test
    public void validAddress() {
        UserAddress userAddress = new UserAddress("Calle_161_#54-10._Bogotá,_Colombia");
        Assertions.assertEquals("CALLE_161_#54-10._BOGOTÁ,_COLOMBIA", userAddress.value);
    }

    @Test
    public void invalidAddress () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress("Calle_161_#54-10._Bogotá123123,_Colombia");
        });
        Assertions.assertEquals("Invalid address provided.", exception.getMessage());
    }


}
