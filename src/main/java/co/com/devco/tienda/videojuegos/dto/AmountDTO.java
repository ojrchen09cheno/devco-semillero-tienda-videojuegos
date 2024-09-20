package co.com.devco.tienda.videojuegos.dto;

public class AmountDTO {

    private int amount;

    private AmountDTO(){};

    public AmountDTO(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
