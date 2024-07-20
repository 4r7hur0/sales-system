package main.system.model;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Product, Integer> items;
    private OrderState status;
    private PaymentMethod paymentMethod;

    public Order(Map<Product, Integer> items, PaymentMethod paymentMethod) {
        this.items = items;
        this.status = new CreatingOrderState();
        this.paymentMethod = paymentMethod;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    public void nextStatus() {
        status.next(this);
    }

    public String getStateOrder(){
        return status.status(); //irá retornar o método status que está no estado do pedido
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
