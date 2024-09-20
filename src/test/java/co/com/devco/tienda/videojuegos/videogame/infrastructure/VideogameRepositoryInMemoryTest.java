package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class VideogameRepositoryInMemoryTest {

    VideogameRepositoryInMemory repository;

    @BeforeEach
    void setup(){
        repository = new VideogameRepositoryInMemory();
        repository.addVideogame(new Videogame(
                0,
                "test",
                0,
                0
        ));
        repository.addVideogame(new Videogame(
                1,
                "stocked",
                0,
                5
        ));
    }

    @Test
    void shouldFindAllVideogames() {
        List<Videogame> videogames = repository.findAll();
        assertThat(videogames.size()).isEqualTo(2);
        assertThat(videogames.getFirst()).usingRecursiveComparison().isEqualTo(new Videogame(0,"test",0,0));
    }

    @Test
    void shouldFindVideogameById() {
        Videogame videogame = repository.findById(1).get();
        assertThat(videogame.getId()).isEqualTo(1);
        assertThat(videogame.getName()).isEqualTo("stocked");
    }

    @Test
    void shouldNotFindVideogameInvalidId() {
        Optional<Videogame> videogame = repository.findById(2);
        assertThat(videogame.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldAddVideogame() {
        repository.addVideogame(new Videogame(2,
                "new videogame",
                0,
                0));
        List<Videogame> videogames = repository.findAll();
        assertThat(videogames.size()).isEqualTo(3);
        Videogame videogame = repository.findById(2).get();
        assertThat(videogame.getName()).isEqualTo("new videogame");

    }

    @Test
    void shouldUpdateVideogame() {
        repository.updateVideogame(0,new Videogame(0,
                "updated",
                5,
                8));
        Videogame videogame = repository.findById(0).get();
        assertThat(videogame.getName()).isEqualTo("updated");
        assertThat(videogame.getConsole()).isEqualTo(5);
        assertThat(videogame.getStock()).isEqualTo(8);
    }

    @Test
    void shouldDeleteVideogame() {
        repository.deleteVideogame(0);
        List<Videogame> videogames = repository.findAll();
        assertThat(videogames.size()).isEqualTo(1);
        Optional<Videogame> videogame = repository.findById(0);
        assertThat(videogame.isEmpty()).isEqualTo(true);
    }

    @Test
    void shouldUpdateVideogameStock() {
        Videogame videogame = repository.updateStock(0, 3);
        assertThat(videogame.getStock()).isEqualTo(3);
    }
}