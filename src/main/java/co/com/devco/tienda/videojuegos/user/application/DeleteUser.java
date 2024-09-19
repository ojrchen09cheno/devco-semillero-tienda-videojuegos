package co.com.devco.tienda.videojuegos.user.application;

import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {

    private final UserRepository userRepository;
    private final FindUser findUser;

    public DeleteUser(UserRepository userRepository,
                           FindUser findUser){
        this.userRepository = userRepository;
        this.findUser = findUser;
    }

    public User delete(int id){
        // call findUser to ensure user exists
        // store user to return if successful
        User user = findUser.find(id);
        userRepository.deleteUser(id);
        return user;
    }

}
