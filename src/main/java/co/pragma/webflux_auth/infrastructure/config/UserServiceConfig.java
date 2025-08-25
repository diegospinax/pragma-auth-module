package co.pragma.webflux_auth.infrastructure.config;

import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {

    private final UserRepository userRepository;

    public UserServiceConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userServiceBean() {
        return new UserService(userRepository);
    }
}
