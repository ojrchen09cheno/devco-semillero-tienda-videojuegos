package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class FindUser {

    private final UserRepository userRepository;

    public FindUser(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    public User find(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

}
