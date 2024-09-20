package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.dto.AmountDTO;
import co.com.devco.tienda.videojuegos.videogame.application.*;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VideogameController.class)
class VideogameControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    FindAllVideogames findAllVideogames;
    @MockBean
    FindVideogame findVideogame;
    @MockBean
    AddVideogame addVideogame;
    @MockBean
    SellVideogame sellVideogame;
    @MockBean
    DeleteVideogame deleteVideogame;
    @MockBean
    StockVideogame stockVideogame;
    @MockBean
    UpdateVideogame updateVideogame;

    private final List<Videogame> videogames = new ArrayList<>();

    @BeforeEach
    void setup(){
        videogames.add(new Videogame(0,
                "test",
                0,
                5));
        videogames.add(new Videogame(1,
                "second",
                1,
                10));
    }

    @Test
    void shouldFindAllVideogames() throws Exception {
        when(findAllVideogames.findAll()).thenReturn(videogames);
        mvc.perform(MockMvcRequestBuilders.get("/api/videogame"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(videogames.size())));
    }

    @Test
    void shouldFindVideogameById() throws Exception {
        Videogame videogame = videogames.getFirst();
        when(findVideogame.find(0)).thenReturn(videogame);
        mvc.perform(MockMvcRequestBuilders.get("/api/videogame/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.name", is("test")));
    }

    @Test
    void shouldAddVideogame() throws Exception {
        Videogame videogame = new Videogame(2, "new", 2, 2);
        mvc.perform(MockMvcRequestBuilders.post("/api/videogame/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame)))
                .andExpect(status().isCreated());

    }

    @Test
    void shouldUpdateVideogame() throws Exception{
        Videogame videogame = new Videogame(0, "update", 1, 1);
        mvc.perform(MockMvcRequestBuilders.put("/api/videogame/0")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(videogame)))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldStockVideogame() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/api/videogame/stock/0")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new AmountDTO(5))))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldSellVideogame() throws Exception{
        mvc.perform(MockMvcRequestBuilders.put("/api/videogame/sell/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new AmountDTO(5))))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldDeleteVideogame() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/videogame/0"))
                .andExpect(status().isNoContent());
    }
}