package main.system.model;

public class StockProxy implements StockInterface {
    private StockInterface stock;
    private User user;

    public StockProxy(StockInterface stock, User user) {
        this.stock = stock;
        this.user = user;
    }

    @Override
    public void addProduct(Product product, int quantity) {
        if (checkAcess()) {
            stock.addProduct(product, quantity);
        }
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        if (checkAcess()) {
            stock.removeProduct(product, quantity);
        }
    }

    @Override
    public boolean checkAcess() {
        return this.user instanceof Seller;
    }
}