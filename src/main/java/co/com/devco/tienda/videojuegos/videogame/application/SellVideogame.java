package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

@Service
public class SellVideogame {

    private final VideogameRepository videogameRepository;
    private final FindVideogame findVideogame;

    public SellVideogame(VideogameRepository videogameRepository,
                         FindVideogame findVideogame){
        this.videogameRepository = videogameRepository;
        this.findVideogame = findVideogame;
    }

    public Videogame sell(int id, int amount) throws Exception {
        Videogame videogame = findVideogame.find(id);
        if(videogame.getStock() < amount){
            throw new Exception("Not enough stock. There is only " + videogame.getStock());
        }
        amount = videogame.getStock() - amount;
        return videogameRepository.updateStock(id, amount);
    }

}
