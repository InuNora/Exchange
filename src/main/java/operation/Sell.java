package main.java.operation;

import main.java.exchange.IExchange;
import main.java.stocks.StockName;
import main.java.customers.ICustomersList;

/**
 * Created by Julia on 06.01.2017.
 */
public class Sell extends AbstractOperation implements IOperation {

    public Sell(String clientName, StockName stockName, int price, int quantity) {
        super(clientName, stockName, price, quantity);
    }

    @Override
    public void apply(ICustomersList customers) {
        customers.getCustomerByName(this.clientName).sell(order);
    }

    @Override
    public void addToQueue(IExchange exchange) {
        exchange.sellOperation(this);
    }

}
