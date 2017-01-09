package main.java.operation;

import main.java.orders.Order;
import main.java.stocks.StockName;

/**
 * Created by Julia on 06.01.2017.
 */
public abstract class AbstractOperation {

    protected final String clientName;
    protected final Order order;

    AbstractOperation(String clientName, StockName stockName, int price, int quantity) {
        this.clientName = clientName;
        order = new Order(stockName, price, quantity);
    }

    public Order getOrder() {
        return order;
    }




}
