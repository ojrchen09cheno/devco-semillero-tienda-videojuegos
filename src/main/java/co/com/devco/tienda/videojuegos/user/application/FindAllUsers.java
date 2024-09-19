package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUsers {

    private final UserRepository userRepository;

    public FindAllUsers(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
