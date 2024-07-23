package main.system.model;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class Stock implements StockInterface, Serializable {
    private Map<Product, Integer> products = new HashMap<>();

    public Stock () {}

    @Override
    public void addProduct (Product product, int quantity) {
        products.put(product, quantity);
    }

    @Override
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

    @Override
    public boolean checkAcess() {
        return false;
    }

    public int getQuantity (Product product) {
        return products.getOrDefault(product, 0);
    }

    public Map<Product, Integer> getAllProducts () {
        return products;
    }
}
