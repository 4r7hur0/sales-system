package main.system.model;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Product, Integer> items;
    private OrderStatus status;

    public Order(Map<Product, Integer> items) {
        this.items = items;
        this.status = OrderStatus.NEW;
    }

    public Map<Product, Integer> getItems() {
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
