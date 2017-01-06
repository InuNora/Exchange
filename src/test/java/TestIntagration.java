package test.java;

import junit.framework.TestCase;
import main.java.customers.CustomersFromFile;
import main.java.customers.ICustomersList;
import main.java.exchange.Exchange;
import main.java.orders.OrdersFromFile;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestIntagration extends TestCase {

    @Test
    public void testExchange() throws IOException {

        ICustomersList customersList = new CustomersFromFile("src/test/resources/clients.txt");
        OrdersFromFile ordersFromFile = new OrdersFromFile("src/test/resources/orders.txt");
        Exchange exchange = new Exchange(customersList);
        ordersFromFile.apply(exchange);
        customersList.writeToFile("src/test/resources/result.txt");

        try(FileInputStream fis = new FileInputStream(new File("src/test/resources/result.txt"))) {
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            assertEquals("884df53853e3b2af6b83b60203e5f18c", md5);
        }

    }
}
