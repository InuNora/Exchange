package main.java.operation;

import main.java.orders.Order;
import main.java.stocks.StockName;

/**
 * Created by Julia on 06.01.2017.
 */
public abstract class AbstractOperation {

    protected final String clientName;
    protected final StockName stockName;
    protected final int price;
    protected final int quantity;

    AbstractOperation(String clientName, StockName stockName, int price, int quantity) {
        this.clientName = clientName;
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return new Order(stockName, price, quantity);
    }


}
