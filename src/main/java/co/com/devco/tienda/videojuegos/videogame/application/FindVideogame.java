package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class FindVideogame {

    private final VideogameRepository videogameRepository;

    public FindVideogame(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }

    public Videogame find(int id){
        Optional<Videogame> videogame = videogameRepository.findById(id);
        if(videogame.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return videogame.get();
    }

}
