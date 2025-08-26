package co.pragma.webflux_auth.application.service.exception;

public class DataIntegrationValidationException extends RuntimeException {
    public DataIntegrationValidationException(String message) {
        super(message);
    }
}
