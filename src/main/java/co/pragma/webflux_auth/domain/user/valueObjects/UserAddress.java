package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserAddress extends UserField<String> {

    public UserAddress(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String cityAndCountryNameRegex = "\\p{L}+(?:_\\p{L}+)*";
        String streetNumberRegex = "#\\d{2}-\\d{2}";
        String streetNameRegex = "[\\p{L}\\d]+(?:_[\\p{L}\\d]+)?";

        String regex = "^" + streetNameRegex + "_" + streetNumberRegex + "\\._" + cityAndCountryNameRegex +  ",_" + cityAndCountryNameRegex + "$";

        if(value == null)
            throw new UserValidationException("Address is required.");
        if (!value.matches(regex)) {
            throw new UserValidationException("Invalid address provided.");
        }

        this.value = value.toUpperCase();
    }
}
