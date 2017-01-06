package main.java.customers;

import java.io.IOException;

/**
 * Created by Julia on 06.01.2017.
 */
public interface ICustomersList {
    ICustomer getCustomerByName(String name);
    void writeToFile(String FileName) throws IOException;
}
