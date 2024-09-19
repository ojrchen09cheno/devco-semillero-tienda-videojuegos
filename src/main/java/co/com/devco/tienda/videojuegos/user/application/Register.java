package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class Register {

    private final UserRepository userRepository;

    public Register(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user){
        return userRepository.register(user);
    }

}
