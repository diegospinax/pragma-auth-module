package co.pragma.webflux_auth.domain.auth.exception;

public class AuthValidationException extends RuntimeException{
    public AuthValidationException(String message) {
        super(message);
    }
}
