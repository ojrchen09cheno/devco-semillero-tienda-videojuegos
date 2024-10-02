package co.com.devco.tienda.videojuegos.user.infrastructure;

import co.com.devco.tienda.videojuegos.user.application.*;
import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Get all users")
    @ApiResponse(responseCode = "200", description = "Found all users",
            content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))})
    @GetMapping("")
    List<User> findAll(){
        return findAllUsers.findAll();
    }

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found user", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    User findById(@PathVariable("id") int id){
        return findUser.find(id);
    }

    @Operation(summary = "Register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Succesful registration", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    User register(@Valid @RequestBody User user){
        return register.register(user);
    }

    @Operation(summary = "Update user info")
    @ApiResponse(responseCode = "204", description = "User updated", content =  @Content)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    User update(@Valid @PathVariable("id") int id,
                     @RequestBody User user){

        return updateName.update(id, user);
    }

    @Operation(summary = "Delete user")
    @ApiResponse(responseCode = "204", description = "User deleted", content =  @Content)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    User delete(@PathVariable("id") int id){
        return deleteUser.delete(id);
    }
}
