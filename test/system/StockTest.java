package system;
import main.system.model.Stock;
import main.system.model.Product;
import main.system.model.ConcreteProductFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockTest {

    private Stock stock;
    private ConcreteProductFactory factory;

    @BeforeEach
    public void setUp() {
        stock = new Stock();
        factory = new ConcreteProductFactory();
    }

    @Test
    public void testAddProduct() {
        Product electronics = factory.makeProduct("eletronic", 100.0, "Smartphone");
        stock.addProduct(electronics, 5);
        assertEquals(5, stock.getQuantity(electronics));
    }

    @Test
    public void testRemoveProduct() {
        Product clothing = factory.makeProduct("clothing", 50.0, "T-shirt");
        stock.addProduct(clothing, 10);

        // Remove 5 items
        stock.removeProduct(clothing, 5);
        assertEquals(5, stock.getQuantity(clothing));

        // Try to remove more items than available
        stock.removeProduct(clothing, 5);
        assertEquals(0, stock.getQuantity(clothing)); // Quantity should be 0 after removal
    }

    @Test
    public void testGetQuantity() {
        Product food = factory.makeProduct("food", 5.0, "Apple");
        stock.addProduct(food, 20);

        assertEquals(20, stock.getQuantity(food));
    }

    @Test
    public void testGetAllProducts() {
        Product electronics = factory.makeProduct("eletronic", 100.0, "Smartphone");
        Product clothing = factory.makeProduct("clothing", 50.0, "T-shirt");
        stock.addProduct(electronics, 3);
        stock.addProduct(clothing, 7);

        assertEquals(2, stock.getAllProducts().size()); // Ensure both products are in the stock map
        assertEquals(3, stock.getQuantity(electronics)); // Check quantity of electronics
        assertEquals(7, stock.getQuantity(clothing)); // Check quantity of clothing
    }
}
