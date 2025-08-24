package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserLastName extends UserField<String>{

    public UserLastName(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[A-Za-zÁÉÍÓÚÑáéíóúñ]+(?:_[A-Za-zÁÉÍÓÚÑáéíóúñ]+)?$";
        if(!value.matches(regex)) {
            throw new UserValidationException("Lastnames must contain only letters and underscore between them.");
        }
        this.value = this.value.toUpperCase();
    }
}
