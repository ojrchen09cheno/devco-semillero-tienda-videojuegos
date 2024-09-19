package co.com.devco.tienda.videojuegos.videogame.domain;

import java.util.List;
import java.util.Optional;

public interface VideogameRepository {
    Videogame updateStock(int id, int amount);
    List<Videogame> findAll();
    Optional<Videogame> findById(int id);
    Videogame addVideogame(Videogame videogame);
    Videogame updateVideogame(int id, Videogame videogame);
    boolean deleteVideogame(int id);
}
