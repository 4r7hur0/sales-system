package main.system.model;
import java.util.Map;
import java.util.HashMap;

public class Stock {
    private Map<Product, Integer> products = new HashMap<>();

    public Stock () {

    }

    public void addProduct (Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct (Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity >= quantity) {
                products.put(product, currentQuantity - quantity);
                if (products.get(product) == 0) {
                    products.remove(product);
                }
            }
        }
    }

    public int getQuantity (Product product) {
        return products.getOrDefault(product, 0);
    }

    public Map getAllProducts () {
        return products;
    }
}
