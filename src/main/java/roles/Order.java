package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
//import static roles.Category.listCategories;
import static roles.Appointment.scheduleAppointment;
import static roles.Category.listCategories;
import static roles.Customer.getLoggedInCustomer;
//import static roles.Product.listCategories;
import static roles.Installer.listInstallers;
import static roles.Product.listProducts;
import static roles.Product.searchProducts;

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

    public static void manageOrders() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Order Management");
            System.out.println("1. Place Order");
            System.out.println("2. List Orders");
            System.out.println("3. List Categories");
            System.out.println("4. Back");
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
                    listCategories();
                    break;
                case 4:
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



        System.out.println("Do you want to search specifc products ? (y/n)");
        String pro = scanner.nextLine();
        switch (pro){
            case "y":
                searchProducts();
                ordersteps();
                break;
            case "n":
                ordersteps();
                break;
        }


    }

    public static void ordersteps(){
        Scanner scanner = new Scanner(System.in);
        List<Product> selectedProducts = new ArrayList<>();
        while (true) {
            System.out.print("Enter the name of the product you want to order (or 'done' to finish): ");
            String input = scanner.nextLine();

            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(input)&&product.getAvailablity()!=0) {
                    selectedProducts.add(product);
                    product.setAvailablity();
                    listProducts();
                    break;
                }else if (product.getAvailablity()==0){ System.out.println("There is no enough");}
            }
            if (input.equalsIgnoreCase("done")) {
                System.out.println("Do you want installation service ? (y/n)");
                String in = scanner.nextLine();
                switch (in){
                    case "y":
                        scheduleAppointment();
                        //String installer = scanner.nextLine();
                        break;


                    case "n":
                        break;
                }
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
        //Customer customer2 =
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