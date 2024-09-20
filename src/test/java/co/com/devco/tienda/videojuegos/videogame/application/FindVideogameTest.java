package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindVideogameTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    FindVideogame findVideogame = new FindVideogame(videogameRepository);

    @Test
    void shouldCallVideogameRepositoryFindVideogame() {
        Videogame videogame = new Videogame(0, "dummy", 0, 0);
        when(videogameRepository.findById(0)).thenReturn(Optional.of(videogame));
        findVideogame.find(0);
        verify(videogameRepository).findById(0);
    }

    @Test
    void shouldReturnExceptionIfNonExistentVideogame() {
        when(videogameRepository.findById(0)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            findVideogame.find(0);
        }).isInstanceOf(ResponseStatusException.class);
        verify(videogameRepository).findById(0);
    }

}