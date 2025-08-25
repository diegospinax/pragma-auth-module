package co.pragma.webflux_auth.infrastructure.config.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleInvalidBodyProvided(ServerWebExchange exchange) {
        ExceptionResponse response = new ExceptionResponse(
                "Bad request",
                LocalDateTime.now() ,
                exchange.getRequest().getPath().value()
        );
        return Mono.just(ResponseEntity.badRequest().body(response));
    }

    @ExceptionHandler(RuntimeException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleRuntimeException(RuntimeException e, ServerWebExchange exchange) {
        ExceptionResponse response = new ExceptionResponse(
                e.getMessage(),
                LocalDateTime.now() ,
                exchange.getRequest().getPath().value()
        );
        return Mono.just(ResponseEntity.badRequest().body(response));
    }
}
