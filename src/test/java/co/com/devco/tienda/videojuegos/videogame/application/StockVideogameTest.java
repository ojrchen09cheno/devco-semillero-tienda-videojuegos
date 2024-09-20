package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class StockVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    FindVideogame findVideogame = mock(FindVideogame.class);
    StockVideogame stockVideogame = new StockVideogame(videogameRepository, findVideogame);

    @Test
    void shouldCallFindVideogameAndVideogameRepositoryUpdatStock(){
        Videogame videogame = new Videogame(0, "dummy", 0, 0);
        when(findVideogame.find(any(int.class))).thenReturn(videogame);
        when(videogameRepository.updateStock(any(int.class),any(int.class))).thenReturn(mock(Videogame.class));

        stockVideogame.stock(0,3);

        verify(findVideogame).find(0);
        verify(videogameRepository).updateStock(0,3);
    }
}