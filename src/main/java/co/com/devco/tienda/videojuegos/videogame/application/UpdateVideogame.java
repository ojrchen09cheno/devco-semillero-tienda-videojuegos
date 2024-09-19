package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateVideogame {

    private final VideogameRepository videogameRepository;

    public UpdateVideogame(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }

    public Videogame update(int id, Videogame videogame){
        return videogameRepository.updateVideogame(id, videogame);
    }

}
