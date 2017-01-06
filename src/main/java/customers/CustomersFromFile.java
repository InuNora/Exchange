package main.java.customers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Julia on 06.01.2017.
 */
public class CustomersFromFile extends AbstractCustomersList {

    public CustomersFromFile(String fileNameClients) throws IOException {
        super();
        try (Stream<String> stream = Files.lines(Paths.get(fileNameClients))) {
            stream.forEach(item -> this.addClient(new Customer(item)));
        }
    }

}
