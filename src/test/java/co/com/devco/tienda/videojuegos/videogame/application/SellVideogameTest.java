package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SellVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    FindVideogame findVideogame = mock(FindVideogame.class);
    SellVideogame sellVideogame = new SellVideogame(videogameRepository, findVideogame);

    @Test
    void shouldCallFindVideogameAndVideogameRepositoryUpdatStock() throws Exception {
        Videogame videogame = new Videogame(0, "dummy", 0, 5);
        when(findVideogame.find(any(int.class))).thenReturn(videogame);
        when(videogameRepository.updateStock(any(int.class),any(int.class))).thenReturn(mock(Videogame.class));
        sellVideogame.sell(0,3);
        verify(findVideogame).find(0);
        verify(videogameRepository).updateStock(0,2);
    }

    @Test
    void shouldReturnExceptionIfNonExistentVideogame() throws Exception {
        Videogame videogame = new Videogame(0, "dummy", 0, 2);
        when(findVideogame.find(any(int.class))).thenReturn(videogame);
        when(videogameRepository.updateStock(any(int.class),any(int.class))).thenReturn(mock(Videogame.class));

        assertThatThrownBy(() -> {
            sellVideogame.sell(0,3);
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("Not enough stock");

        verify(findVideogame).find(0);
        verify(videogameRepository, never()).updateStock(0,3);
    }

}