package be.skenteridis.app;

import be.skenteridis.model.Product;
import be.skenteridis.service.ProductService;
import be.skenteridis.util.InputUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
        InputUtil input = new InputUtil();
        ProductService service = new ProductService();
        boolean run = true;
        do {
            System.out.println("--- Shopping Cart Manager ---");
            System.out.println("""
                        1) Add Product
                        2) Delete Product
                        3) View Products
                        4) Exit""");
            switch (input.getInt("Choice")) {
                case 4 -> run = false;
                case 1 -> service.addProduct(new Product(
                        input.getValidString("Name"),
                        input.getDouble("Price"),
                        input.getInt("Quantity")
                ));
                case 2 -> service.deleteProduct(input.getInt("Product ID"));
                case 3 -> {
                    List<Product> products = service.getProducts();
                    double total = 0;
                    if(products.isEmpty()) System.out.println("No products found!");
                    else {
                        for(Product product : products) {
                            System.out.println("ID: " + product.getId());
                            System.out.println("Name: " + product.getName());
                            System.out.println("Price: " + product.getPrice());
                            System.out.println("Quantity: " + product.getQuantity());
                            double finalPrice = product.getPrice() * product.getQuantity();
                            System.out.println("Final Price: " + finalPrice);
                            System.out.println("------------------------------------------------------");
                            total += finalPrice;
                        }
                        System.out.println("Total: " + total);
                    }
                }
            }
        } while (run);
        input.close();
        System.out.println("Goodbye!");
    }
}