package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

@Service
public class AddVideogame {

    private final VideogameRepository videogameRepository;

    public AddVideogame(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }

    public Videogame add(Videogame videogame){
        return videogameRepository.addVideogame(videogame);
    }

}
