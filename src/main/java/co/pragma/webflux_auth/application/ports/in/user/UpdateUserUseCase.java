package co.pragma.webflux_auth.application.ports.in.user;

import co.pragma.webflux_auth.application.dto.user.SaveUserDto;
import co.pragma.webflux_auth.domain.user.User;
import reactor.core.publisher.Mono;

public interface UpdateUserUseCase {
    Mono<User> updateUser(Long userId, SaveUserDto userDto);
}
