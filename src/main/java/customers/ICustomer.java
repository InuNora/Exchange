package main.java.customers;

import main.java.orders.Order;
import main.java.stocks.StockName;

/**
 * Created by Julia on 29.12.2016.
 */
public interface ICustomer {
    void sell(Order order);
    void buy(Order order);

    String getName();
    int getBalanceUSD();
    int getStockQuality (StockName name);
}
