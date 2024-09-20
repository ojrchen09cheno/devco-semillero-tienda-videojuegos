package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RegisterTest {

    UserRepository userRepository = mock(UserRepository.class);
    Register register = new Register(userRepository);

    @Test
    void shouldCallUserRepositoryRegister() {
        User user = new User(0, "register", "test");
        register.register(user);
        verify(userRepository).register(user);

    }
}