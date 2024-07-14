package main.system.model;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Product, OrderStatus> items;
    private OrderStatus status;

    public Order() {
        this.items = new HashMap<>();
    }

    public void setOrder(Map<Product, Integer> items) {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            this.items.put(entry.getKey(), OrderStatus.NEW);
        }
    }

    public Map<Product, OrderStatus> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setShipped() {
        this.status = OrderStatus.SHIPPED;
    }

    public enum OrderStatus {
        NEW, SHIPPED;
    }
}