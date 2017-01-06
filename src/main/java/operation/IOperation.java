package main.java.operation;

import main.java.exchange.IExchange;
import main.java.orders.Order;
import main.java.customers.ICustomersList;

/**
 * Created by Julia on 06.01.2017.
 */
public interface IOperation {
    void apply (ICustomersList customers);
    void addToQueue(IExchange exchange);
    Order getOrder();
}
