package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UpdateNameTest {

    UserRepository userRepository = mock(UserRepository.class);
    UpdateName updateName = new UpdateName(userRepository);

    @Test
    void shouldCallUserRepositoryUpdateName() {
        User user = new User(0, "register", "test");
        updateName.update(0, user);
        verify(userRepository).updateUser(0, user);

    }

}