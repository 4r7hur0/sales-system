package system;

import main.system.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;
    private Map<Product, Integer> items;
    private PaymentMethod paymentMethod;
    private Product electronics;
    private Product clothes;
    private Product foods;

    @BeforeEach
    public void setUp() {
        items = new HashMap<>();
        electronics = new Electronics("Electronics", 100.0, "A cool gadget");
        clothes = new Clothes("Clothes", 50.0, "A nice shirt");
        foods = new Foods("Foods", 10.0, "A tasty snack");

        items.put(electronics, 2);
        items.put(clothes, 3);
        items.put(foods, 5);
        paymentMethod = new CreditCardPayment("1","2", "123");
        order = new Order(items, paymentMethod);
    }

    @Test
    public void testOrderCreation() {
        assertEquals(items, order.getItems());
        assertTrue(order.getStatus() instanceof CreatingOrderState);
        assertEquals(paymentMethod, order.getPaymentMethod());
    }

    @Test
    public void testNextStatus() {
        OrderState initialState = order.getStatus();
        order.nextStatus();
        OrderState nextState = order.getStatus();
        assertNotEquals(initialState, nextState);
    }

    @Test
    public void testGetStateOrder() {
        assertEquals("Preparando pedido", order.getStateOrder());
    }


    @Test
    public void testGetItems() {
        Map<Product, Integer> retrievedItems = order.getItems();
        assertEquals(3, retrievedItems.size());

        assertTrue(retrievedItems.containsKey(electronics));
        assertEquals(Integer.valueOf(2), retrievedItems.get(electronics));

        assertTrue(retrievedItems.containsKey(clothes));
        assertEquals(Integer.valueOf(3), retrievedItems.get(clothes));

        assertTrue(retrievedItems.containsKey(foods));
        assertEquals(Integer.valueOf(5), retrievedItems.get(foods));
    }
}
