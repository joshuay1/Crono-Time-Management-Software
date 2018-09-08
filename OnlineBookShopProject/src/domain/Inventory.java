package domain;


import java.util.Map;

public class Inventory {

    private Map<Book, Integer> stock;

    public Inventory(Map<Book, Integer> stock) {
        this.stock = stock;
    }

    public Map<Book, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Book, Integer> stock) {
        this.stock = stock;
    }

}
