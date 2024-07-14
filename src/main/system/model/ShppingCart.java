package main.system.model;

import java.util.HashMap;
import java.util.Map;

public class ShppingCart {
    private Map<Product, Integer> items = new HashMap<>();
    Order order = new Order();

    public void addItem(Product item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    public void removeItem(Product item) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            if (currentQuantity > 1) {
                items.put(item, currentQuantity - 1);
            } else {
                items.remove(item);
            }
        }
    }

    public double getTotalPrice() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public Order checkout() {
        order.setOrder(items);
        items.clear();
        return order;
    }

    public Order getOrder(){
        return this.order;
    }
}

