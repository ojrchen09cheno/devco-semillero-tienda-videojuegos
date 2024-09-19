package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteVideogame {

    private final VideogameRepository videogameRepository;
    private final FindVideogame findVideogame;

    public DeleteVideogame(VideogameRepository videogameRepository,
                         FindVideogame findVideogame){
        this.videogameRepository = videogameRepository;
        this.findVideogame = findVideogame;
    }

    public Videogame delete(int id){
        // call findVideogame to ensure videogame exists
        // store videogame to return if successful
        Videogame videogame = findVideogame.find(id);
        videogameRepository.deleteVideogame(id);
        return videogame;
    }

}
