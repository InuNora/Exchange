package main.java.exchange;

import main.java.customers.ICustomersList;
import main.java.operation.*;
import main.java.orders.OrdersQueue;

/**
 * Created by Julia on 05.01.2017.
 */
public class Exchange implements IExchange {


    private final ICustomersList clients;
    private OrdersQueue sellQueue = new OrdersQueue();
    private OrdersQueue buyQueue = new OrdersQueue();

    public Exchange(ICustomersList customersList) {
        this.clients = customersList;
    }

    @Override
    public void buyOperation(Buy operation) {
        if(sellQueue.checkOrder(operation.getOrder())) {
            operation.apply(clients);
            sellQueue.pullOrder(operation.getOrder()).apply(clients);
        }
        else {
            buyQueue.addOrder(operation);
        }
    }

    @Override
    public void sellOperation(Sell operation) {
        if(buyQueue.checkOrder(operation.getOrder())) {
            operation.apply(clients);
            buyQueue.pullOrder(operation.getOrder()).apply(clients);
        }
        else {
            sellQueue.addOrder(operation);
        }
    }
}
