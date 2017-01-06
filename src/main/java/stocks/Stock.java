package main.java.stocks;

/**
 * Created by Julia on 29.12.2016.
 */
public class Stock {
    private StockName name;
    private int quantity;

    public Stock(StockName name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void increase(int number) {
        this.quantity += number;
    }

    public void decrease(int number) {
        this.quantity -= number;
    }

    public int getQuantity() {
        return this.quantity;
    }


}
