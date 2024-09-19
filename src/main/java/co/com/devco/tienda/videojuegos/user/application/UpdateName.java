package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UpdateName {

    private final UserRepository userRepository;

    public UpdateName(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User update(int id, User user){
        return userRepository.updateUser(id, user);
    }

}
