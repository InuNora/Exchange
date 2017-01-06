package test.java;

import junit.framework.TestCase;
import main.java.operation.Buy;
import main.java.operation.IOperation;
import main.java.operation.Sell;
import main.java.orders.Order;
import main.java.orders.OrdersQueue;
import main.java.stocks.StockName;
import org.junit.Test;

/**
 * Created by Julia on 06.01.2017.
 */
public class TestQueue extends TestCase {

    @Test
    public void testEmptyQueue() {
        //проверка отсктствия элемента
        OrdersQueue queue = new OrdersQueue();
        assertFalse(queue.checkOrder(new Order(StockName.A, 10, 5)));
    }

    @Test
    public void testElementQueue() {
        //добавление элемента и проверка наличия
        OrdersQueue queue = new OrdersQueue();
        IOperation operation = new Sell("C1", StockName.A, 10, 5);
        queue.addOrder(operation);
        assertTrue(queue.checkOrder(new Order(StockName.A, 10, 5)));
    }

    @Test
    public void testDeleteDubleElementsQueue() {

        //добавление 2-х одинаковых элементов
        OrdersQueue queue = new OrdersQueue();
        IOperation operation = new Buy("C1", StockName.A, 10, 5);
        Order order = new Order(StockName.A, 10, 5);
        queue.addOrder(operation);
        queue.addOrder(operation);

        //удалить 1 и проверить наличие
        queue.pullOrder(order);
        assertTrue(queue.checkOrder(order));

        //удалить второй и проверить отсутствие
        queue.pullOrder(order);
        assertFalse(queue.checkOrder(order));
    }

    @Test
    public void testDeleteElementsQueue() {

        //добавление разных 2 элементов
        OrdersQueue queue = new OrdersQueue();
        IOperation operation1 = new Buy("C1", StockName.A, 10, 5);
        IOperation operation2 = new Sell("C2", StockName.B, 50, 2);
        Order order1 = new Order(StockName.A, 10, 5);
        Order order2 = new Order(StockName.B, 50, 2);
        queue.addOrder(operation1);
        queue.addOrder(operation2);

        //удалить 1 и проверить наличие
        queue.pullOrder(order2);
        assertFalse(queue.checkOrder(order2));
        assertTrue(queue.checkOrder(order1));

        //удалить второй и проверить отсутствие
        queue.pullOrder(order1);
        assertFalse(queue.checkOrder(order1));
    }
}
