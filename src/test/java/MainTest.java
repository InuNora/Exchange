package test.java;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import main.java.customers.Customer;
import main.java.customers.CustomersFromFile;
import main.java.customers.ICustomer;
import main.java.exchange.Exchange;
import main.java.operation.Buy;
import main.java.customers.ICustomersList;
import main.java.operation.IOperation;
import main.java.operation.Sell;
import main.java.orders.Order;
import main.java.orders.OrdersFromFile;
import main.java.orders.OrdersQueue;
import main.java.stocks.StockName;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Julia on 05.01.2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestClients.class,
        TestOperations.class,
        TestQueue.class,
        TestOrders.class,
        TestIntagration.class
})

public class MainTest extends TestCase {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(MainTest.class);

        System.out.println(result.getRunCount());
        System.out.println(result.wasSuccessful());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }














}
