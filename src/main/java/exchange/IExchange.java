package main.java.exchange;

import main.java.operation.Buy;
import main.java.operation.Sell;

/**
 * Created by Julia on 06.01.2017.
 */
public interface IExchange {
    void buyOperation(Buy operation);
    void sellOperation(Sell operation);
}
