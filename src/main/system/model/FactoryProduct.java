package main.system.model;

public interface FactoryProduct {
    public Product makeProduct(String type, double price, String description);
}
