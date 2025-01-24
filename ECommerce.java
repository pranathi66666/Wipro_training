import java.io.*;
import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + '\'' + '}';
    }
}

class Order {
    private int id;
    private Customer customer;
    private List<Product> products;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public double calculateTotalCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", customer=" + customer + ", products=" + products + '}';
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Products:\n");
        for (Product product : products) {
            sb.append("- ").append(product.getName()).append(" ($").append(product.getPrice()).append(")\n");
        }
        sb.append("Total Cost: $").append(calculateTotalCost()).append("\n\n");
        return sb.toString();
    }
}

public class ECommerceManagement {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private static final String ORDER_HISTORY_FILE = "order_history.txt";

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Order createOrder(int orderId, int customerId) {
        Customer customer = customers.stream().filter(c -> c.getId() == customerId).findFirst().orElse(null);
        if (customer == null) {
            System.out.println("Customer not found.");
            return null;
        }
        Order order = new Order(orderId, customer);
        orders.add(order);
        return order;
    }

    public void saveOrderHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_HISTORY_FILE))) {
            for (Order order : orders) {
                writer.write(order.toFileString());
            }
            System.out.println("Order history saved to " + ORDER_HISTORY_FILE);
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ECommerceManagement ecom = new ECommerceManagement();

        // Adding products
        ecom.addProduct(new Product(1, "Laptop", 1200.00));
        ecom.addProduct(new Product(2, "Smartphone", 800.00));

        // Adding customers
        ecom.addCustomer(new Customer(1, "Alice"));
        ecom.addCustomer(new Customer(2, "Bob"));

        // Creating an order
        Order order = ecom.createOrder(1, 1);
        if (order != null) {
            order.addProduct(new Product(1, "Laptop", 1200.00));
            order.addProduct(new Product(2, "Smartphone", 800.00));

            System.out.println("Order Details:");
            System.out.println(order);
        }

        // Saving order history
        ecom.saveOrderHistory();
    }
}
