package co.pragma.webflux_auth.domain.role.valueObjects;

import co.pragma.webflux_auth.domain.role.exception.RoleValidationException;

public class RoleName extends RoleField<String>{

    public RoleName(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[A-Za-zÁÉÍÓÚÑáéíóúñ]+(?:_[A-Za-zÁÉÍÓÚÑáéíóúñ]+)?$";
        if(value == null)
            throw new RoleValidationException("Role name is required.");
        if(!value.matches(regex))
            throw new RoleValidationException("Role must contain only letters and underscore.");

        this.value = this.value.toUpperCase();
    }
}
