package system;
import main.system.model.ConcreteProductFactory;
import main.system.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcreteProductFactoryTest {

    @Test
    public void testMakeProduct() {
        ConcreteProductFactory factory = new ConcreteProductFactory();

        // Test case 1: Creating an Electronics product
        Product electronics = factory.makeProduct("eletronic", 100.0, "Smartphone");
        assertNotNull(electronics);
        assertEquals("eletronic", electronics.getType());
        assertEquals(100.0, electronics.getPrice());
        assertEquals("Smartphone", electronics.getDescription());

        // Test case 2: Creating a Clothing product
        Product clothing = factory.makeProduct("clothing", 50.0, "T-shirt");
        assertNotNull(clothing);
        assertEquals("clothing", clothing.getType());
        assertEquals(50.0, clothing.getPrice());
        assertEquals("T-shirt", clothing.getDescription());

        // Test case 3: Creating a Food product
        Product food = factory.makeProduct("food", 5.0, "Apple");
        assertNotNull(food);
        assertEquals("food", food.getType());
        assertEquals(5.0, food.getPrice());
        assertEquals("Apple", food.getDescription());

        // Test case 4: Invalid product type
        Product invalidProduct = factory.makeProduct("invalid", 0.0, "Invalid Product");
        assertNull(invalidProduct);
    }
}