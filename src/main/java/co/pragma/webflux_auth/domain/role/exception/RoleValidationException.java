package co.pragma.webflux_auth.domain.role.exception;

public class RoleValidationException extends RuntimeException {
    public RoleValidationException(String message) {
        super(message);
    }
}
