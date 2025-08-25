package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserLastname extends UserField<String>{

    public UserLastname(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[A-Za-zÁÉÍÓÚÑáéíóúñ]+(?:_[A-Za-zÁÉÍÓÚÑáéíóúñ]+)?$";
        if(value == null)
            throw new UserValidationException("Lastname is required.");
        if(!value.matches(regex))
            throw new UserValidationException("Lastnames must contain only letters and underscore between them.");

        this.value = this.value.toUpperCase();
    }
}
