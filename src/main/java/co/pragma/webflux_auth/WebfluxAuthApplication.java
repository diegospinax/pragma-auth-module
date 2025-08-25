package co.pragma.webflux_auth;

import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.application.service.UserService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
@SpringBootApplication
public class WebfluxAuthApplication {

    public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(WebfluxAuthApplication.class, args);
	}

}
