package co.pragma.webflux_auth.infrastructure.config;

import co.pragma.webflux_auth.application.ports.out.RoleRepository;
import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceConfig(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    public UserService userServiceBean() {
        return new UserService(userRepository, roleRepository);
    }
}
