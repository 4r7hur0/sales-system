package main.system.model;

public interface StockInterface {
    void addProduct(Product product, int quantity);
    void removeProduct(Product product, int quantity);
    boolean checkAcess();
}
