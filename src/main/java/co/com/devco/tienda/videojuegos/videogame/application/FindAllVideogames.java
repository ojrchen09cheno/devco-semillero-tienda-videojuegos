package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllVideogames {

    private final VideogameRepository videogameRepository;

    public FindAllVideogames(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }

    public List<Videogame> findAll(){
        return videogameRepository.findAll();
    }

}


