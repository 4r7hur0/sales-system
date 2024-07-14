package main.system.model;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Product, Integer> items;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

    public Order(Map<Product, Integer> items, PaymentMethod paymentMethod) {
        this.items = items;
        this.status = OrderStatus.NEW;
        this.paymentMethod = paymentMethod;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
