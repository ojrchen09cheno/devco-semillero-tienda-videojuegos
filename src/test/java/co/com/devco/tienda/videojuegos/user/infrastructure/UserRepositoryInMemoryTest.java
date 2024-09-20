package co.com.devco.tienda.videojuegos.user.infrastructure;

import co.com.devco.tienda.videojuegos.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class UserRepositoryInMemoryTest {

    UserRepositoryInMemory repository;

    @BeforeEach
    void setup() {
        repository = new UserRepositoryInMemory();
        repository.register(new User(
                0,
                "first",
                "test"
        ));
        repository.register(new User(
                1,
                "second",
                "user"
        ));
    }

    @Test
    void shouldRegister() {
        repository.register(new User(2,
                "third",
                "register"));
        List<User> users = repository.findAll();
        assertThat(users.size()).isEqualTo(3);
        User user = users.getLast();
        assertThat(user.getfName()).isEqualTo("third");
    }

    @Test
    void shouldDeleteUser() {
        repository.deleteUser(0);
        List<User> users = repository.findAll();
        assertThat(users.size()).isEqualTo(1);
        Optional<User> user = repository.findById(0);
        assertThat(user.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldFindAllUsers() {
        List<User> users = repository.findAll();
        assertThat(users.size()).isEqualTo(2);
        User user = users.getFirst();
        assertThat(user).usingRecursiveComparison().isEqualTo(new User(0,"first","test"));
    }

    @Test
    void shouldFindUserById() {
        User user = repository.findById(0).get();
        assertThat(user.getfName()).isEqualTo("first");
    }

    @Test
    void shouldUpdateName() {
        repository.updateUser(0, new User(0, "test", "updated"));
       User user = repository.findById(0).get();
       assertThat(user.getfName()).isEqualTo("test");
       assertThat(user.getlName()).isEqualTo("updated");

    }
}