package test.java;

import junit.framework.TestCase;
import main.java.customers.Customer;
import main.java.customers.ICustomer;
import main.java.customers.ICustomersList;
import main.java.operation.Buy;
import main.java.operation.IOperation;
import main.java.operation.Sell;
import main.java.stocks.StockName;
import org.junit.Test;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestOperations extends TestCase {

    @Test
    public void testBuyOperation() {
        final ICustomer client = new Customer("C1", 1000, 130, 240, 760,320);
        IOperation buy = new Buy("C1", StockName.A, 10, 5);
        buy.apply(new ICustomersList() {
            @Override
            public ICustomer getCustomerByName(String name) {
                return client;
            }

            @Override
            public void writeToFile(String FileName) {

            }
        });
        assertEquals(1000 - 10 * 5, client.getBalanceUSD());
        assertEquals(130 + 5, client.getStockQuality(StockName.A));
    }

    @Test
    public void testSellOperation() {
        final ICustomer client = new Customer("C1", 1000, 130, 240, 760,320);
        IOperation sell = new Sell("C1", StockName.A, 10, 5);
        sell.apply(new ICustomersList() {
            @Override
            public ICustomer getCustomerByName(String name) {
                return client;
            }

            @Override
            public void writeToFile(String FileName) {

            }
        });
        assertEquals(1000 + 10 * 5, client.getBalanceUSD());
        assertEquals(130 - 5, client.getStockQuality(StockName.A));
    }
}
