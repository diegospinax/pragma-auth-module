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
        UserAddress userAddress = new UserAddress("Calle_16_#75-10._Manizales,_Colombia");
        Assertions.assertEquals("CALLE_16_#75-10._MANIZALES,_COLOMBIA", userAddress.value);
    }

    @Test
    public void invalidAddress () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress("Calle_27_#30-02._Bogotá121,_Colombia");
        });
        Assertions.assertEquals("Invalid address provided.", exception.getMessage());
    }


}
