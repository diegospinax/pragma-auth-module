package co.pragma.webflux_auth.domain.auth;

import co.pragma.webflux_auth.domain.auth.valueObjects.AuthEmail;
import co.pragma.webflux_auth.domain.auth.valueObjects.AuthPassword;

public record Auth (
        Long id,
        AuthEmail email,
        AuthPassword password
) {
}
