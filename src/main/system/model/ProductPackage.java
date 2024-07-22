package main.system.model;
import java.util.LinkedList;
import java.util.List;

public class ProductPackage implements Product{
    private String description;
    private List<Product> products = new LinkedList<>();

    public ProductPackage (String description) {
        this.description = description;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return "Package";
    }

    public List<Product> getProducts() {
        return products;
    }
}
