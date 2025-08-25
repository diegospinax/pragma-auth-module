package co.pragma.webflux_auth.application.ports.in;

import co.pragma.webflux_auth.application.dto.SaveUserDto;
import co.pragma.webflux_auth.domain.user.User;
import reactor.core.publisher.Mono;

public interface UpdateUserUseCase {
    Mono<User> updateUser(Long userId, SaveUserDto userDto);
}
