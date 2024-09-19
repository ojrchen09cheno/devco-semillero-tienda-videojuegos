package co.com.devco.tienda.videojuegos.user.infrastructure;

import co.com.devco.tienda.videojuegos.user.application.*;
import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final FindAllUsers findAllUsers;
    private final FindUser findUser;
    private final Register register;
    private final DeleteUser deleteUser;
    private final UpdateName updateName;

    public UserController(FindUser findUser,
                          FindAllUsers findAllUsers,
                          Register register,
                          DeleteUser deleteUser,
                          UpdateName updateName){

        this.findUser = findUser;
        this.findAllUsers = findAllUsers;
        this.register = register;
        this.deleteUser = deleteUser;
        this.updateName = updateName;
    }

    @GetMapping("")
    List<User> findAll(){
        return findAllUsers.findAll();
    }

    @GetMapping("/{id}")
    User findById(@PathVariable("id") int id){

        return findUser.find(id);
    }

    @PostMapping("/register")
    User register(@RequestBody User user){

        return register.register(user);
    }

    @PutMapping("/{id}")
    User update(@PathVariable("id") int id,
                     @RequestBody User user){

        return updateName.update(id, user);
    }

    @DeleteMapping("/{id}")
    User delete(@PathVariable("id") int id){
        return deleteUser.delete(id);
    }

}
