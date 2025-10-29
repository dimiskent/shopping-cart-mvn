package be.skenteridis.service;

import be.skenteridis.model.Product;
import be.skenteridis.util.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ProductService {
    private final List<Product> products;
    public ProductService() {
        this.products = JsonUtil.load(new TypeToken<List<Product>>() {}.getType());
        // Avoid duplicate IDs!
        if(!products.isEmpty()) Product.setProductAmount(this.products.getLast().getId());
    }
    public void addProduct(Product product) {
        products.add(product);
        JsonUtil.save(products);
    }
    public List<Product> getProducts() {
        return products;
    }
    public void deleteProduct(int id) {
        boolean deleted = products.removeIf((Product p) -> p.getId() == id);
        if(deleted) {
            System.out.println("Product deleted successfully! Saving file...");
            JsonUtil.save(products);
        } else System.out.println("Product not found");
    }
}
