package co.com.devco.tienda.videojuegos.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User register(User user);
    boolean deleteUser(int id);
    List<User> findAll();
    Optional<User> findById(int id);
    User updateUser(int id, User user);
}
