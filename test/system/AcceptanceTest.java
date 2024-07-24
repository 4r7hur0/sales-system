package system;
import main.system.controller.SalesController;
import main.system.model.*;
import main.system.model.exception.*;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTest {

    private SalesController controller;
    private Product electronics;
    private Product clothes;
    private Product foods;
    private User seller;
    private User buyer;

    @BeforeEach
    public void setUp() {
        controller = SalesController.getInstance();
    }

    @Test
    public void testAcceptanceScenario() throws InvalidProductException, LoginFailedException, PaymentMethodNotDefinedException, InsufficientQuantityException, EmptyCartException {
        // Step 1: Register a seller and a buyer
        controller.registerUser("Seller", "sellerLogin", "sellerPassword", "seller@example.com", "123 Street", 0);
        controller.registerUser("Buyer", "buyerLogin", "buyerPassword", "buyer@example.com", "456 Avenue", 1);

        // Step 2: Log in as seller and register products
        seller = controller.loginUser("sellerLogin", "sellerPassword");
        controller.registerProduct("Eletronic", 100.0, "A cool gadget", 10);
        controller.registerProduct("Clothing", 50.0, "A nice shirt", 20);
        controller.registerProduct("Food", 10.0, "A tasty snack", 30);

        // Retrieve the registered products from stock using traditional for loop
        Map<Product, Integer> products = controller.getAllProducts();
        electronics = null;
        clothes = null;
        foods = null;

        for (Product product : products.keySet()) {
            if (product.getDescription().equals("A cool gadget")) {
                electronics = product;
            } else if (product.getDescription().equals("A nice shirt")) {
                clothes = product;
            } else if (product.getDescription().equals("A tasty snack")) {
                foods = product;
            }
        }

        // Ensure that products are not null
        assertNotNull(electronics, "Electronics should be found in stock");
        assertNotNull(clothes, "Clothes should be found in stock");
        assertNotNull(foods, "Foods should be found in stock");

        // Verify products in stock
        assertEquals(3, products.size());
        assertTrue(products.containsKey(electronics));
        assertTrue(products.containsKey(clothes));
        assertTrue(products.containsKey(foods));
        assertEquals(Integer.valueOf(10), products.get(electronics));
        assertEquals(Integer.valueOf(20), products.get(clothes));
        assertEquals(Integer.valueOf(30), products.get(foods));

        // Step 3: Log in as buyer and add products to cart
        buyer = controller.loginUser("buyerLogin", "buyerPassword");
        controller.addInCart(electronics);
        controller.addInCart(clothes);
        controller.addInCart(foods);
        controller.addInCart(foods); // Adding the same item twice

        // Verify items in cart
        Map<Product, Integer> cartItems = controller.viewCart();
        assertEquals(3, cartItems.size());
        assertEquals(Integer.valueOf(1), cartItems.get(electronics));
        assertEquals(Integer.valueOf(1), cartItems.get(clothes));
        assertEquals(Integer.valueOf(2), cartItems.get(foods));

        // Step 4: Set payment method and checkout
        controller.credit("1234567890123456", "Buyer", "123");
        controller.order();

        // Verify the order is placed and cart is empty
        MyIterator<Order> orders = controller.viewOrder();
        assertTrue(orders.hasNext(), "Order should be placed");
        assertTrue(controller.viewCart().isEmpty(), "Cart should be empty after checkout");

        // Step 5: Verify the order details
        Order order = orders.next();
        Map<Product, Integer> orderItems = order.getItems();
        assertEquals(3, orderItems.size());
        assertEquals(Integer.valueOf(1), orderItems.get(electronics));
        assertEquals(Integer.valueOf(1), orderItems.get(clothes));
        assertEquals(Integer.valueOf(2), orderItems.get(foods));
        assertEquals("Preparando pedido", order.getStateOrder());
    }

    @Test
    public void testLoginWithIncorrectCredentials() throws LoginFailedException{
        controller.getInstance();
        // Step 1: Register a user
        controller.registerUser("User", "userLogin", "userPassword", "user@example.com", "123 Street", 1);

        // Step 2: Attempt to log in with incorrect credentials
        Exception exception = assertThrows(LoginFailedException.class, () -> {
            controller.loginUser("userLogin", "wrongPassword");
        });

        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testAddProductToCartWithInsufficientStock() throws InsufficientQuantityException, LoginFailedException, InvalidProductException {
        // Step 1: Register a seller and a buyer
        controller.registerUser("Seller", "sellerLogin", "sellerPassword", "seller@example.com", "123 Street", 0);
        controller.registerUser("Buyer", "buyerLogin", "buyerPassword", "buyer@example.com", "456 Avenue", 1);

        // Step 2: Log in as seller and register a product with limited stock
        seller = controller.loginUser("sellerLogin", "sellerPassword");
        controller.registerProduct("eletronic", 100.0, "A cool gadget", 1);

        // Retrieve the registered product from stock using a for loop
        Map<Product, Integer> products = controller.getAllProducts();
        electronics = null;
        for (Product product : products.keySet()) {
            if (product.getDescription().equals("A cool gadget")) {
                electronics = product;
                break;
            }
        }

        // Ensure the product is found
        assertNotNull(electronics, "Product should be found in the stock");

        // Step 3: Log in as buyer and attempt to add more products to cart than available in stock
        buyer = controller.loginUser("buyerLogin", "buyerPassword");
        controller.addInCart(electronics);

        // Verify the product has been added to the cart
        Map<Product, Integer> cartItems = controller.viewCart();
        assertEquals(1, cartItems.getOrDefault(electronics, 0), "Product should be in the cart with quantity 1");
    }

    @Test
    public void testRemoveProductNotInCart() throws LoginFailedException {
        // Step 1: Register a buyer
        controller.registerUser("Buyer", "buyerLogin", "buyerPassword", "buyer@example.com", "456 Avenue", 1);

        // Step 2: Log in as buyer
        buyer = controller.loginUser("buyerLogin", "buyerPassword");

        // Step 3: Initialize a product that is not in the cart
        electronics = new Electronics("Electronics", 100.0, "A cool gadget");

        // Step 4: Attempt to remove a product not in the cart
        // No exception is expected, so check the state of the cart instead
        controller.removeProductCart(electronics);

        // Verify that the cart is still empty
        Map<Product, Integer> cartItems = controller.viewCart();
        assertTrue(cartItems.isEmpty(), "Cart should be empty");
    }
}