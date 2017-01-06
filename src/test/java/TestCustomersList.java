package test.java;

import main.java.customers.AbstractCustomersList;
import main.java.customers.ICustomer;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestCustomersList extends AbstractCustomersList  {

    public TestCustomersList(ICustomer... customers) {
        super();
        for (int i = 0; i < customers.length; i++) {
            this.addClient(customers[i]);
        }
    }
}
