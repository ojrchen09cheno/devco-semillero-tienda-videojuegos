package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DeleteVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    FindVideogame findVideogame = mock(FindVideogame.class);
    DeleteVideogame deleteVideogame = new DeleteVideogame(videogameRepository, findVideogame);

    @Test
    public void shouldCallFindVideogameAndVideogameRepositoryDelete(){
        deleteVideogame.delete(0);
        verify(findVideogame).find(0);
        verify(videogameRepository).deleteVideogame(0);
    }

}