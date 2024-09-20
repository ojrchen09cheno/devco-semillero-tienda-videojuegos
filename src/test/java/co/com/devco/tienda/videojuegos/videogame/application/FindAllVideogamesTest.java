package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.user.application.Register;
import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.user.domain.UserRepository;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FindAllVideogamesTest {

    VideogameRepository videogameRepository = mock(VideogameRepository.class);
    FindAllVideogames findAllVideogames = new FindAllVideogames(videogameRepository);

    @Test
    public void shouldCallVideogameRepositoryFindAll(){
        findAllVideogames.findAll();
        verify(videogameRepository).findAll();
    }
}