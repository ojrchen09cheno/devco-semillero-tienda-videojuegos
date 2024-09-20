package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FindAllUsersTest {

    UserRepository userRepository = mock(UserRepository.class);
    FindAllUsers findAllUsers = new FindAllUsers(userRepository);

    @Test
    void shouldCallUserRepositoryFindAll() {
        findAllUsers.findAll();
        verify(userRepository).findAll();

    }

}