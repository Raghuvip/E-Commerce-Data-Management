import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define a Product class to represent products in the e-commerce application
class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Define a class to manage product data
class ProductManager {
    private Map<Integer, Product> products;

    // Constructor
    public ProductManager() {
        this.products = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Method to remove a product
    public void removeProduct(int productId) {
        products.remove(productId);
    }

    // Method to get a product by ID
    public Product getProductById(int productId) {
        return products.get(productId);
    }

    // Method to get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a ProductManager instance
        ProductManager productManager = new ProductManager();

        // Add some products
        productManager.addProduct(new Product(1, "Laptop", 999.99, 10));
        productManager.addProduct(new Product(2, "Smartphone", 599.99, 20));
        productManager.addProduct(new Product(3, "Headphones", 99.99, 30));

        // Retrieve and display all products
        List<Product> allProducts = productManager.getAllProducts();
        System.out.println("All Products:");
        for (Product product : allProducts) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice() + " (" + product.getQuantity() + " in stock)");
        }

        // Remove a product and display updated list
        productManager.removeProduct(2);
        System.out.println("\nProducts after removing Smartphone:");
        for (Product product : productManager.getAllProducts()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice() + " (" + product.getQuantity() + " in stock)");
        }
    }
}