package be.skenteridis.model;

public class Product {
    private final int id;

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void setProductAmount(int newAmount) {
        productAmount = newAmount;
    }

    private final int quantity;
    private final String name;
    private final double price;
    private static int productAmount = 0;
    public Product(String name, double price, int quantity) {
        id = ++productAmount;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
