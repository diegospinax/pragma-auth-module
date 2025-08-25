package co.pragma.webflux_auth.infrastructure.config.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse(
        String message,
        LocalDateTime timestamp,
        String path
) {
}
