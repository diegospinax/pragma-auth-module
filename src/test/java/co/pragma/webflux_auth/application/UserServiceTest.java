package co.pragma.webflux_auth.application;

import co.pragma.webflux_auth.application.ports.out.UserRepository;
import co.pragma.webflux_auth.application.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
}
