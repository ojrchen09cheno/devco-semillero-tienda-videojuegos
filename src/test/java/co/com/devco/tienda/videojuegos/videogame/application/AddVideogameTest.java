package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    AddVideogame addVideogame = new AddVideogame(videogameRepository);

    @Test
    public void shouldCallVideogameRepositoryAdd(){
        Videogame videogame = new Videogame(0, "dummy", 0, 0);
        addVideogame.add(videogame);
        verify(videogameRepository).addVideogame(videogame);
    }

}