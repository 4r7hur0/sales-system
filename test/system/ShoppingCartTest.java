package system;
import main.system.model.ShoppingCart;
import main.system.model.Product;
import main.system.model.Electronics;
import main.system.model.Clothes;
import main.system.model.Foods;
import main.system.model.PaymentMethod;
import main.system.model.CreditCardPayment;
import main.system.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product electronics;
    private Product clothes;
    private Product foods;
    private PaymentMethod paymentMethod;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        electronics = new Electronics("Electronics", 100.0, "A cool gadget");
        clothes = new Clothes("Clothes", 50.0, "A nice shirt");
        foods = new Foods("Foods", 10.0, "A tasty snack");
        paymentMethod = new CreditCardPayment("1", "2", "123");
        cart.setPaymentMethod(paymentMethod);
    }

    @Test
    public void testAddItem() {
        cart.addItem(electronics);
        cart.addItem(clothes);
        cart.addItem(foods);
        cart.addItem(foods); // Adding same item twice

        Map<Product, Integer> items = cart.getItems();
        assertEquals(3, items.size());
        assertEquals(Integer.valueOf(1), items.get(electronics));
        assertEquals(Integer.valueOf(1), items.get(clothes));
        assertEquals(Integer.valueOf(2), items.get(foods));
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(electronics);
        cart.addItem(clothes);
        cart.addItem(foods);
        cart.addItem(foods); // Adding same item twice

        cart.removeItem(foods);
        Map<Product, Integer> items = cart.getItems();
        assertEquals(3, items.size());
        assertEquals(Integer.valueOf(1), items.get(electronics));
        assertEquals(Integer.valueOf(1), items.get(clothes));
        assertEquals(Integer.valueOf(1), items.get(foods));

        cart.removeItem(foods);
        items = cart.getItems();
        assertEquals(2, items.size());
        assertFalse(items.containsKey(foods));
    }

    @Test
    public void testGetTotalPrice() {
        cart.addItem(electronics);
        cart.addItem(clothes);
        cart.addItem(foods);
        cart.addItem(foods); // Adding same item twice

        double totalPrice = cart.getTotalPrice();
        assertEquals(170.0, totalPrice, 0.001);
    }

    @Test
    public void testCheckout() {
        cart.addItem(electronics);
        cart.addItem(clothes);
        cart.addItem(foods);
        cart.addItem(foods); // Adding same item twice

        Order order = cart.checkout();
        Map<Product, Integer> items = order.getItems();

        assertEquals(3, items.size());
        assertEquals(Integer.valueOf(1), items.get(electronics));
        assertEquals(Integer.valueOf(1), items.get(clothes));
        assertEquals(Integer.valueOf(2), items.get(foods));
        assertEquals(paymentMethod, order.getPaymentMethod());
        assertTrue(cart.getItems().isEmpty());
    }
}
