package co.pragma.webflux_auth.infrastructure.adapters.in;

import co.pragma.webflux_auth.application.dto.role.ResponseRoleDto;
import co.pragma.webflux_auth.application.dto.role.SaveRoleDto;
import co.pragma.webflux_auth.application.ports.in.role.CreateRoleUseCase;
import co.pragma.webflux_auth.application.ports.in.role.FindRoleUseCase;
import co.pragma.webflux_auth.domain.role.Role;
import co.pragma.webflux_auth.infrastructure.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final CreateRoleUseCase createRoleUseCase;
    private final FindRoleUseCase findRoleUseCase;
    private final RoleMapper roleMapper;


    @PostMapping("/create")
    public ResponseEntity<Mono<ResponseRoleDto>> createRole(@RequestBody SaveRoleDto saveRoleDto) {
        Role role = roleMapper.createDtoToDomain(saveRoleDto);
        return new ResponseEntity<>(
                createRoleUseCase.createRole(role)
                        .map(roleMapper::domainToResponse),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Flux<ResponseRoleDto>> findAll() {
        return new ResponseEntity<>(
                findRoleUseCase.findAll()
                        .map(roleMapper::domainToResponse),
                HttpStatus.OK
        );
    }
}
