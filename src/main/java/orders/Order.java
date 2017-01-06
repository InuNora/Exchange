package main.java.orders;

import main.java.stocks.StockName;

/**
 * Created by Julia on 06.01.2017.
 */
public class Order {
    private StockName stockName;
    private int price;
    private int quantity;

    public Order(StockName stockName, int price, int quantity) {
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (price != order.price) return false;
        if (quantity != order.quantity) return false;
        return stockName == order.stockName;

    }

    @Override
    public int hashCode() {
        int result = stockName.hashCode();
        result = 31 * result + price;
        result = 31 * result + quantity;
        return result;
    }
}
