package co.pragma.webflux_auth.infrastructure.config.doc;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Users Webflux API")
                        .version("1.0")
                        .description("API REST Documentation for CRUD endpoints of a user, made with Spring Webflux"));
    }
}
