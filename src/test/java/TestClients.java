package test.java;

import junit.framework.TestCase;
import main.java.customers.Customer;
import main.java.stocks.StockName;
import org.junit.Test;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestClients extends TestCase {

    @Test
    public void testClientFromString() {
        Customer client = new Customer("C1\t1000\t130\t240\t760\t320");
        assertEquals("C1", client.getName());
        assertEquals(1000, client.getBalanceUSD());
        assertEquals(130, client.getStockQuality(StockName.A));
        assertEquals(240, client.getStockQuality(StockName.B));
        assertEquals(760, client.getStockQuality(StockName.C));
        assertEquals(320, client.getStockQuality(StockName.D));
    }

    @Test
    public void testBuy() {
        Customer client = new Customer("C1", 1000, 130, 240, 760,320);
        client.buy(StockName.A, 100, 5);
        assertEquals(1000 - 100 * 5, client.getBalanceUSD());
        assertEquals(130 + 5, client.getStockQuality(StockName.A));
    }

    @Test
    public void testSell() {
        Customer client = new Customer("C1", 1000, 130, 240, 760,320);
        client.sell(StockName.B, 50, 10);
        assertEquals(1000 + 50 * 10, client.getBalanceUSD());
        assertEquals(240 - 10, client.getStockQuality(StockName.B));
    }
}
