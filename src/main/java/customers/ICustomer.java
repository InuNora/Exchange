package main.java.customers;

import main.java.stocks.StockName;

/**
 * Created by Julia on 29.12.2016.
 */
public interface ICustomer {
    void sell(StockName stock, int price, int quantity);
    void buy(StockName stock, int price, int quantity);

    String getName();
    int getBalanceUSD();
    int getStockQuality (StockName name);
}
