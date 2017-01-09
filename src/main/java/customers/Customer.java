package main.java.customers;

import main.java.orders.Order;
import main.java.stocks.StockName;
import main.java.stocks.Stock;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Julia on 29.12.2016.
 */
public class Customer implements ICustomer {

    private final String name;
    private int balanceUSD;
    private Map<StockName, Stock> stocksMap = new LinkedHashMap<StockName, Stock>();


    public Customer(String name, int usd, int a, int b, int c, int d) {

        this.name = name;
        this.balanceUSD = usd;
        this.stocksMap.put(StockName.A, new Stock(StockName.A, a));
        this.stocksMap.put(StockName.B, new Stock(StockName.B, b));
        this.stocksMap.put(StockName.C, new Stock(StockName.C, c));
        this.stocksMap.put(StockName.D, new Stock(StockName.D, d));

    }

    public Customer(String[] s) {
        this(s[0], Integer.valueOf(s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3]), Integer.valueOf(s[4]), Integer.valueOf(s[5]));
    }

    public Customer(String data) {
        this(data.split("\t"));
    }

    public int getStockQuality (StockName name) {
        return stocksMap.get(name).getQuantity();
    }

    public String getName () {
        return this.name;
    }

    public int getBalanceUSD () {
        return this.balanceUSD;
    }

    @Override
    public void sell(Order order) {
        stocksMap.get(order.getStockName()).decrease(order.getQuantity());
        this.balanceUSD += order.getQuantity() * order.getPrice();
    }

    @Override
    public void buy(Order order) {
        stocksMap.get(order.getStockName()).increase(order.getQuantity());
        this.balanceUSD -= order.getQuantity() * order.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\t" + balanceUSD + "\t");
        for (Map.Entry<StockName, Stock> stock : stocksMap.entrySet()) {
            sb.append(stock.getValue().getQuantity());
            sb.append("\t");
        }

        return sb.toString();
    }

}
