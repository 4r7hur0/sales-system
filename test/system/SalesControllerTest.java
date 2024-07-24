package system;
import main.system.controller.SalesController;
import main.system.model.*;
import main.system.model.exception.InsufficientQuantityException;
import main.system.model.exception.InvalidProductException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SalesControllerTest {

    private SalesController controller;
    private Product electronics;
    private Product clothes;
    private Product foods;
    private User buyer;
    private User seller;

    @BeforeEach
    public void setUp() throws Exception {
        controller = SalesController.getInstance();
        electronics = new Electronics("Electronic", 100.0, "A cool gadget");
        clothes = new Clothes("Clothing", 50.0, "A nice shirt");
        foods = new Foods("Food", 10.0, "A tasty snack");


        // Register a seller
        controller.registerUser("Seller", "sellerLogin", "sellerPassword", "seller@example.com", "123 Street", 0);
        seller = controller.loginUser("sellerLogin", "sellerPassword");

        // Register a buyer
        controller.registerUser("Buyer", "buyerLogin", "buyerPassword", "buyer@example.com", "456 Avenue", 1);
        buyer = controller.loginUser("buyerLogin", "buyerPassword");
    }

    @Test
    public void testRegisterAndLoginUser() throws Exception {
        // Testing if users are registered and can log in
        assertNotNull(seller);
        assertNotNull(buyer);
        assertEquals("sellerLogin", seller.getName());
        assertEquals("buyerLogin", buyer.getName());
    }

    @Test
    public void testRegisterProduct() throws Exception {
        // Log in as seller
        controller.loginUser("sellerLogin", "sellerPassword");

        // Register products
        controller.registerProduct("Electronic", 100.0, "A cool gadget", 10);
        controller.registerProduct("Clothing", 50.0, "A nice shirt", 20);

        // Retrieve all products from stock
        Map<Product, Integer> products = controller.getAllProducts();
        assertEquals(2, products.size());
    }

    @Test
    public void testAddAndRemoveProductFromCart() throws Exception {
        // Log in as buyer
        controller.loginUser("buyerLogin", "buyerPassword");

        // Add products to cart
        controller.addInCart(electronics);
        controller.addInCart(foods);
        controller.addInCart(foods); // Adding the same item twice

        // Check items in cart
        Map<Product, Integer> cartItems = controller.viewCart();
        assertEquals(2, cartItems.size());
        assertEquals(Integer.valueOf(1), cartItems.get(electronics));
        assertEquals(Integer.valueOf(2), cartItems.get(foods));

        // Remove product from cart
        controller.removeProductCart(foods);
        cartItems = controller.viewCart();
        assertEquals(2, cartItems.size());
        assertEquals(Integer.valueOf(1), cartItems.get(foods));

        controller.removeProductCart(foods);
        cartItems = controller.viewCart();
        assertFalse(cartItems.containsKey(foods));
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        // Log in as buyer
        controller.loginUser("buyerLogin", "buyerPassword");

        // Add products to cart
        controller.addInCart(electronics);
        controller.addInCart(clothes);

        // Check total price
        double totalPrice = controller.getTotalPrice();
        assertEquals(150.0, totalPrice, 0.001);
    }

    @Test
    public void testCheckoutAndOrder() throws Exception {
        // Log in as buyer
        controller.loginUser("buyerLogin", "buyerPassword");

        // Add products to cart
        controller.addInCart(electronics);
        controller.addInCart(clothes);

        // Set payment method
        controller.credit("1234567890123456", "Buyer", "123");

        // Checkout
        controller.order();

        // Check orders
        assertTrue(controller.viewOrder().hasNext());
    }

    @Test
    public void testPaymentMethods() throws Exception {
        // Log in as buyer
        controller.loginUser("buyerLogin", "buyerPassword");

        // Set and check payment methods
        PaymentMethod credit = controller.credit("1234567890123456", "Buyer", "123");
        assertTrue(credit instanceof CreditCardPayment);

        PaymentMethod paypal = controller.payPal("buyer@example.com");
        assertTrue(paypal instanceof PayPalMethod);

        PaymentMethod bankTransfer = controller.bankTransfer("12345678", "Buyer", "0001");
        assertTrue(bankTransfer instanceof BankTransferPayment);
    }
}

