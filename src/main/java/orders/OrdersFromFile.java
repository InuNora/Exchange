package main.java.orders;

import main.java.exchange.IExchange;
import main.java.operation.OperatoinFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Julia on 06.01.2017.
 */
public class OrdersFromFile {

    private OperatoinFactory operatoinFactory = new OperatoinFactory();
    private final String fileNameOrders;

    public OrdersFromFile(String fileName) {
        fileNameOrders = fileName;
    }

    public void apply(IExchange exchange) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileNameOrders))) {
            stream.forEach(data -> operatoinFactory.get(data).addToQueue(exchange));
        }
    }
}
