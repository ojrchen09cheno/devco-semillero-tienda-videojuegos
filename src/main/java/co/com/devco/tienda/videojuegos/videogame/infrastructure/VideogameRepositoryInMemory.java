package co.com.devco.tienda.videojuegos.videogame.infrastructure;

import co.com.devco.tienda.videojuegos.videogame.domain.Videogame;
import co.com.devco.tienda.videojuegos.videogame.domain.VideogameRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VideogameRepositoryInMemory implements VideogameRepository {

    private List<Videogame> videogames = new ArrayList<>();

    @Override
    public List<Videogame> findAll() {
        return videogames;
    }

    @Override
    public Optional<Videogame> findById(int id) {
        return videogames.stream()
                .filter(videogame -> videogame.getId() == id)
                .findFirst();
    }

    @Override
    public Videogame addVideogame(Videogame videogame) {
        videogames.add(videogame);
        return videogame;
    }

    @Override
    public Videogame updateVideogame(int id, Videogame videogame) {
        Videogame old = findById(id).get();
        old.setName(videogame.getName());
        old.setConsole(videogame.getConsole());
        old.setStock(videogame.getStock());
        return findById(id).get();
    }

    @Override
    public boolean deleteVideogame(int id) {
        videogames.remove(findById(id).get());
        return true;
    }

    @Override
    public Videogame updateStock(int id, int amount) {
        Videogame videogame = findById(id).get();
        videogame.setStock(amount);
        return videogame;
    }

    @PostConstruct
    private void init() {
        videogames.add(new Videogame(1,"first",0,0));
        videogames.add(new Videogame(2,"second", 1,1));
    }
}
