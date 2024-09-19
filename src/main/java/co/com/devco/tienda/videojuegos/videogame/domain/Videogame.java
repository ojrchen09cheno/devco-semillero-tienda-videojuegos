package co.com.devco.tienda.videojuegos.videogame.domain;

public class Videogame {
    private int id;
    private String name;
    private int console;
    private int stock;

    public Videogame() {
    }

    public Videogame(int id, String name, int console, int stock) {
        this.id = id;
        this.name = name;
        this.console = console;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConsole() {
        return console;
    }

    public void setConsole(int console) {
        this.console = console;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
