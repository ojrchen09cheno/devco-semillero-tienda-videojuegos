package co.com.devco.tienda.videojuegos.videogame.application;

import co.com.devco.tienda.videojuegos.dto.AmountDTO;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
public class StockVideogame {

    private final VideogameRepository videogameRepository;
    private final FindVideogame findVideogame;

    public StockVideogame(VideogameRepository videogameRepository,
                         FindVideogame findVideogame){
        this.videogameRepository = videogameRepository;
        this.findVideogame = findVideogame;
    }

    public Videogame stock(int id, int amount){
        Videogame videogame = findVideogame.find(id);
        amount += videogame.getStock();
        return videogameRepository.updateStock(id, amount);
    }

}
