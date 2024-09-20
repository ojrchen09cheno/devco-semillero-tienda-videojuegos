package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteUserTest {

    UserRepository userRepository = mock(UserRepository.class);
    FindUser findUser = mock(FindUser.class);
    DeleteUser deleteUser = new DeleteUser(userRepository, findUser);

    @Test
    void shouldCallFindUserAndUserRepositoryDelete() {
        deleteUser.delete(0);
        verify(findUser).find(0);
        verify(userRepository).deleteUser(0);

    }
}