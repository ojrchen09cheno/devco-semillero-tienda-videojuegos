package co.com.devco.tienda.videojuegos.user.infrastructure;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryInMemory implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User register(User user) {
        users.add(user);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        users.remove(findById(id).get());
        return true;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public User updateUser(int id, User user) {
        User old = findById(id).get();
        old.setfName(user.getfName());
        old.setlName(user.getlName());
        return findById(id).get();
    }

    @PostConstruct
    private void init(){
        users.add(new User(0, "fname", "lname"));
        users.add(new User(1, "Jia", "Chen"));
    }
}
