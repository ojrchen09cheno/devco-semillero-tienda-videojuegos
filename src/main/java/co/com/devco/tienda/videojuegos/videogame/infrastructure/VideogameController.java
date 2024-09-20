package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.dto.AmountDTO;
import co.com.devco.tienda.videojuegos.videogame.application.*;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Videogame add(@Valid @RequestBody Videogame videogame){
        return addVideogame.add(videogame);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    Videogame update(@Valid @PathVariable("id") int id,
                     @RequestBody Videogame videogame){

        return updateVideogame.update(id, videogame);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/stock/{id}")
    Videogame stock(@PathVariable("id") int id,
                    @RequestBody AmountDTO amountDTO){

        return stockVideogame.stock(id, amountDTO.getAmount());

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/sell/{id}")
    Videogame sell(@PathVariable("id") int id,
                   @RequestBody AmountDTO amountDTO) throws Exception {

        return sellVideogame.sell(id, amountDTO.getAmount());

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    Videogame delete(@PathVariable("id") int id){
                return deleteVideogame.delete(id);
    }

}
