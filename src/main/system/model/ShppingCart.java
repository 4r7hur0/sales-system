package main.system.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShppingCart implements Serializable {
    private Map<Product, Integer> items = new HashMap<>();
    private PaymentMethod payment;

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
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> p : items.entrySet()) {
            Product product = p.getKey();
            int quantity = p.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public Order checkout() {
        Order order = new Order(new HashMap<>(items), payment); //passar método de pagamento na finalização do pedido
        items.clear();
        return order;
    }

    public void setPaymentMethod(PaymentMethod payment){
        this.payment = payment;
    }
}

