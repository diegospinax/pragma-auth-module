package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;
import co.pragma.webflux_auth.domain.user.valueObjects.support.Address;

public class UserAddress extends UserField<Address> {

    public UserAddress(Address value) {
        super(value);
    }

    @Override
    public void validate() {
        try {
            value.validateAddress();
        } catch (RuntimeException e) {
            throw new UserValidationException("Invalid address provided.");
        }
    }
}
