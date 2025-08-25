package co.pragma.webflux_auth.infrastructure.config;

import co.pragma.webflux_auth.application.ports.out.RoleRepository;
import co.pragma.webflux_auth.application.service.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleServiceConfig {

    private final RoleRepository roleRepository;

    public RoleServiceConfig(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    public RoleService roleServiceBean() {
        return new RoleService(roleRepository);
    }
}
