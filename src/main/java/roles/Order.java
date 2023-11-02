package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
import static roles.Customer.getLoggedInCustomer;
import static roles.Product.listProducts;
import roles.Product;

public class Order {
    private int orderId;
    private List<Product> orderedProducts;
    private double totalPrice;




    public Order(int orderId, List<Product> orderedProducts) {
        this.orderId = orderId;
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : orderedProducts) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    static void manageOrders() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Order Management");
            System.out.println("1. Place Order");
            System.out.println("2. List Orders");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    listOrders();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Products:");
        listProducts();

        List<Product> selectedProducts = new ArrayList<>();

        while (true) {
            System.out.print("Enter the name of the product you want to order (or 'done' to finish): ");
            String input = scanner.nextLine();

            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(input)) {
                    selectedProducts.add(product);
                    break;
                }
            }
            if (input.equalsIgnoreCase("done")) {
                break;
            }
        }

        if (selectedProducts.isEmpty()) {
            System.out.println("No products selected. Order not placed.");
        } else {
            Customer customer = getLoggedInCustomer();
            Order order = new Order(orderIdCounter, selectedProducts);
            customer.getOrders().add(order);
            orderIdCounter++;
            System.out.println("Order placed successfully!");
        }
    }

    public static void listOrders() {
        Customer customer = getLoggedInCustomer();
        if (customer != null) {
            System.out.println("Orders for " + customer.getUsername() + ":");
            List<Order> orders = customer.getOrders();
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Ordered Products:");
                for (Product product : order.getOrderedProducts()) {
                    System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
                }
                System.out.println("Total Price: " + order.getTotalPrice());
                System.out.println("----------");
            }
        } else {
            System.out.println("You need to log in as a customer to view orders.");
        }
    }
}