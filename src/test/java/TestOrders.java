package test.java;

import junit.framework.TestCase;
import main.java.customers.Customer;
import main.java.customers.ICustomersList;
import main.java.exchange.Exchange;
import main.java.operation.Buy;
import main.java.operation.Sell;
import main.java.stocks.StockName;
import org.junit.Test;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestOrders extends TestCase {

    @Test
    public void testSucsessOrder() {
        ICustomersList customersList = new TestCustomersList(
                new Customer("C1", 1000, 100, 100, 100, 100),
                new Customer("C2", 1000, 100, 100, 100, 100)
        );
        Exchange exchange = new Exchange(customersList);
        exchange.buyOperation(new Buy("C1", StockName.A, 100, 5));
        exchange.sellOperation(new Sell("C2", StockName.A, 100, 5));
        assertEquals(1000 - 100 * 5, customersList.getCustomerByName("C1").getBalanceUSD());
        assertEquals(1000 + 100 * 5, customersList.getCustomerByName("C2").getBalanceUSD());
        assertEquals(100 + 5, customersList.getCustomerByName("C1").getStockQuality(StockName.A));
        assertEquals(100 - 5, customersList.getCustomerByName("C2").getStockQuality(StockName.A));
    }

    @Test
    public void testUnsucsessOrder() {
        ICustomersList customersList = new TestCustomersList(
                new Customer("C1", 1000, 100, 100, 100, 100),
                new Customer("C2", 1000, 100, 100, 100, 100)
        );
        Exchange exchange = new Exchange(customersList);
        exchange.buyOperation(new Buy("C1", StockName.A, 100, 5));
        exchange.sellOperation(new Sell("C2", StockName.B, 100, 5));
        assertEquals(1000, customersList.getCustomerByName("C1").getBalanceUSD());
        assertEquals(1000, customersList.getCustomerByName("C2").getBalanceUSD());
        assertEquals(100, customersList.getCustomerByName("C1").getStockQuality(StockName.A));
        assertEquals(100, customersList.getCustomerByName("C2").getStockQuality(StockName.A));

    }
}
