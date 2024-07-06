package main.system.model;
import java.util.List;

public class Order {
    private List<Product> items;
    private OrderStatus status;

    public Order(List<Product> items) {
        this.items = items;
        this.status = OrderStatus.NEW;
    }

    public List<Product> getItems() {
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
