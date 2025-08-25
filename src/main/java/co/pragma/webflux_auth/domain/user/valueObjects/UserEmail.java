package co.pragma.webflux_auth.domain.user.valueObjects;

import co.pragma.webflux_auth.domain.user.exception.UserValidationException;

public class UserEmail extends UserField<String> {

    public UserEmail(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(value == null){
            throw new UserValidationException("Email is required.");
        }
        if(!value.matches(regex)){
            throw new UserValidationException("Invalid email provided.");
        }
    }
}
