package main.java;

import main.java.customers.CustomersFromFile;
import main.java.customers.ICustomersList;
import main.java.exchange.Exchange;
import main.java.orders.OrdersFromFile;

import java.io.IOException;

/**
 * Created by Julia on 29.12.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        ICustomersList customersList = new CustomersFromFile("src/main/resources/clients.txt");
        OrdersFromFile ordersFromFile = new OrdersFromFile("src/main/resources/orders.txt");
        Exchange exchange = new Exchange(customersList);
        ordersFromFile.apply(exchange);
        customersList.writeToFile("src/main/resources/result.txt");

    }
}
