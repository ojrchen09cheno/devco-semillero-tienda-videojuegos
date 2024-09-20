package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindUserTest {

    UserRepository userRepository = mock(UserRepository.class);
    FindUser findUser = new FindUser(userRepository);

    @Test
    void shouldCallUserRepositoryFindUser() {
        User user = new User(0, "mock", "mock");
        when(userRepository.findById(0)).thenReturn(Optional.of(user));
        findUser.find(0);
        verify(userRepository).findById(0);
    }

    @Test
    void shouldReturnExceptionIfNonExistentUser() {
        when(userRepository.findById(0)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            findUser.find(0);
        }).isInstanceOf(ResponseStatusException.class);
        verify(userRepository).findById(0);
    }

}