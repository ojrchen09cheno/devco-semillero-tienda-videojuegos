package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UpdateVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    UpdateVideogame updateVideogame = new UpdateVideogame(videogameRepository);

    @Test
    public void shouldCallVideogameRepositoryFindAll(){
        Videogame videogame = new Videogame(0, "dummy",0 ,0);
        updateVideogame.update(0, videogame);
        verify(videogameRepository).updateVideogame(0, videogame);
    }

}