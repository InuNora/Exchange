package main.java.customers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Julia on 06.01.2017.
 */
public class AbstractCustomersList implements ICustomersList {

    private Map<String, ICustomer> clients = new LinkedHashMap<>();

    public AbstractCustomersList() {}

    protected void addClient(ICustomer newClient) {
        clients.put(newClient.getName(), newClient);
    }

    @Override
    public ICustomer getCustomerByName(String name) {
        return clients.get(name);
    }


    public void writeToFile(String FileName) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, ICustomer> client : clients.entrySet()) {
            stringBuffer.append(client.getValue().toString());
            stringBuffer.append("\r\n");
        }
        try(FileOutputStream fos=new FileOutputStream(FileName))
        {
            byte[] buffer = stringBuffer.toString().getBytes();
            fos.write(buffer, 0, buffer.length);
        }
    }

}
