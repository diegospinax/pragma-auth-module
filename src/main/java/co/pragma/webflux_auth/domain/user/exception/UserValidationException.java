package co.pragma.webflux_auth.domain.user.exception;

public class UserValidationException extends RuntimeException{
    public UserValidationException(String message) {
        super(message);
    }
}
