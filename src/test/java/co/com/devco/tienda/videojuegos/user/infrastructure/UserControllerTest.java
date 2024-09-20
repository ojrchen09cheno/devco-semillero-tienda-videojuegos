package co.com.devco.tienda.videojuegos.user.infrastructure;
import co.com.devco.tienda.videojuegos.user.application.*;
import co.com.devco.tienda.videojuegos.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    Register register;
    @MockBean
    FindAllUsers findAllUsers;
    @MockBean
    FindUser findUser;
    @MockBean
    DeleteUser deleteUser;
    @MockBean
    UpdateName updateName;

    private final List<User> users = new ArrayList<>();

    @BeforeEach
    void setup(){
        users.add(new User(0,
                "first",
                "test"));
        users.add(new User(1,
                "second",
                "mock"));
    }

    @Test
    void shouldFindAllUsers() throws Exception{
        when(findAllUsers.findAll()).thenReturn(users);
        mvc.perform(MockMvcRequestBuilders.get("/api/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(users.size())));
    }

    @Test
    void shouldFindUserById() throws Exception{
        User user = users.getFirst();
        when(findUser.find(0)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/api/user/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.fName", is("first")));
    }

    @Test
    void shouldRegister() throws Exception{
        User user = new User(2, "new", "new lastname");
        mvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateName() throws Exception{
        User user = new User(0, "updated", "name");
        mvc.perform(MockMvcRequestBuilders.put("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldDeleteUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/user/0"))
                .andExpect(status().isNoContent());
    }
}