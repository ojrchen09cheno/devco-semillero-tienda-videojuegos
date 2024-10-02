package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.dto.AmountDTO;
import co.com.devco.tienda.videojuegos.user.domain.User;
import co.com.devco.tienda.videojuegos.videogame.application.*;
import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all videogames")
    @ApiResponse(responseCode = "200", description = "All videogames found",
            content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Videogame.class)))})
    @GetMapping("")
    List<Videogame> findAll(){
        return findAllVideogames.findAll();
    }

    @Operation(summary = "Get videogame by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found videogame", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Videogame.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id", content =  { @Content()}),
            @ApiResponse(responseCode = "404", description = "Videogame not found", content =  { @Content()})
    })
    @GetMapping("/{id}")
    Videogame findById(@PathVariable("id") int id){
        return findVideogame.find(id);
    }

    @Operation(summary = "Add videogame")
    @ApiResponse(responseCode = "201", description = "Videogame added",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Videogame.class))})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    Videogame add(@Valid @RequestBody Videogame videogame){
        return addVideogame.add(videogame);
    }

    @Operation(summary = "Update videogame")
    @ApiResponse(responseCode = "204", description = "Videogame updated", content = @Content)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    Videogame update(@Valid @PathVariable("id") int id,
                     @RequestBody Videogame videogame){
        return updateVideogame.update(id, videogame);
    }

    @Operation(summary = "Stock videogame")
    @ApiResponse(responseCode = "204", description = "Videogame stocked", content =  @Content)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/stock/{id}")
    Videogame stock(@PathVariable("id") int id,
                    @RequestBody AmountDTO amountDTO){

        return stockVideogame.stock(id, amountDTO.getAmount());

    }

    @Operation(summary = "Sell videogame")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204", description = "Videogame updated", content =  { @Content()}),
            @ApiResponse(responseCode =  "400", description =  "Not enough stock", content =  { @Content()})
    })
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/sell/{id}")
    Videogame sell(@PathVariable("id") int id,
                   @RequestBody AmountDTO amountDTO) throws Exception {

        return sellVideogame.sell(id, amountDTO.getAmount());

    }

    @Operation(summary = "Delete videogame")
    @ApiResponse(responseCode = "204", description = "Videogame deleted", content =  { @Content()})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    Videogame delete(@PathVariable("id") int id){
                return deleteVideogame.delete(id);
    }

}
