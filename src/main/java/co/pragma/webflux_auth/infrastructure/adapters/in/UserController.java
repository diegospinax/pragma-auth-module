package co.pragma.webflux_auth.infrastructure.adapters.in;

import co.pragma.webflux_auth.application.ports.in.CreateUserUseCase;
import co.pragma.webflux_auth.application.ports.in.DeleteUserUseCase;
import co.pragma.webflux_auth.application.ports.in.FindUserUseCase;
import co.pragma.webflux_auth.application.ports.in.UpdateUserUseCase;
import co.pragma.webflux_auth.domain.user.User;
import co.pragma.webflux_auth.domain.user.valueObjects.UserEmail;
import co.pragma.webflux_auth.application.dto.SaveUserDto;
import co.pragma.webflux_auth.application.dto.ResponseUserDto;
import co.pragma.webflux_auth.infrastructure.mapper.UserMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper mapper;
    private final CreateUserUseCase createUseCase;
    private final FindUserUseCase findUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Mono<ResponseUserDto>> createUser(@RequestBody @Valid SaveUserDto saveUserDto) {
        User user = mapper.createDtoToDomain(saveUserDto);
        return new ResponseEntity<>(
                createUseCase.createUser(user)
                        .map(mapper::toResponseDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ResponseUserDto>> findById(@PathVariable("id") @NotNull Long userId) {
        return new ResponseEntity<>(
                findUserUseCase.findById(userId)
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @GetMapping("/email")
    public ResponseEntity<Mono<ResponseUserDto>> findByEmail(@RequestParam("value") String email) {
        return new ResponseEntity<>(
                findUserUseCase.findByEmail(new UserEmail(email))
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Flux<ResponseUserDto>> findAll() {
        return new ResponseEntity<>(
                findUserUseCase.findAll()
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<ResponseUserDto>> updateUser(@PathVariable("id") Long userId, @RequestBody SaveUserDto saveUserDto) {
        return new ResponseEntity<>(
                updateUserUseCase.updateUser(userId, saveUserDto)
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteUser(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(
                deleteUserUseCase.deleteUser(userId),
                HttpStatus.NO_CONTENT
        );
    }
}
