package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.videogame.application.*;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videogame")
public class VideogameController {

    private final FindAllVideogames findAllVideogames;
    private final FindVideogame findVideogame;
    private final AddVideogame addVideogame;
    private final SellVideogame sellVideogame;
    private final DeleteVideogame deleteVideogame;
    private final StockVideogame stockVideogame;
    private final UpdateVideogame updateVideogame;

    public VideogameController(FindVideogame findVideogame,
                               FindAllVideogames findAllVideogames,
                               AddVideogame addVideogame,
                               SellVideogame sellVideogame,
                               DeleteVideogame deleteVideogame,
                               StockVideogame stockVideogame,
                               UpdateVideogame updateVideogame){

        this.findAllVideogames = findAllVideogames;
        this.findVideogame = findVideogame;
        this.addVideogame = addVideogame;
        this.sellVideogame = sellVideogame;
        this.deleteVideogame = deleteVideogame;
        this.stockVideogame = stockVideogame;
        this.updateVideogame = updateVideogame;

    }

    @GetMapping("")
    List<Videogame> findAll(){
        return findAllVideogames.findAll();
    }

    @GetMapping("/{id}")
    Videogame findById(@PathVariable("id") int id){

        return findVideogame.find(id);
    }

    //@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Videogame add(@RequestBody Videogame videogame){

        return addVideogame.add(videogame);
    }

    @PutMapping("/{id}")
    Videogame update(@PathVariable("id") int id,
                     @RequestBody Videogame videogame){

        return updateVideogame.update(id, videogame);
    }

    @PutMapping("/stock/{id}")
    Videogame stock(@PathVariable("id") int id,
                 @RequestBody int amount) throws Exception {

        return stockVideogame.stock(id, amount);

    }

    @PutMapping("/sell/{id}")
    Videogame sell(@PathVariable("id") int id,
                @RequestBody int amount) throws Exception {

        return sellVideogame.sell(id, amount);

    }

    @DeleteMapping("/{id}")
    Videogame delete(@PathVariable("id") int id){
                return deleteVideogame.delete(id);
    }

}
