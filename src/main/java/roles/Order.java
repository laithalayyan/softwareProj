package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.AdminDashboard.*;
import static roles.Appointment.scheduleAppointment;
import static roles.Category.listCategories;
import static roles.Customer.getLoggedInCustomer;
import static roles.Product.listProducts;
import static roles.Product.searchProducts;

public class Order {
    static String xchoice="Invalid choice. Please try again.";
    public static boolean placeOrderr;
    public static boolean listOrder;
    public static boolean listCategories;

    public static boolean isPlaceOrder() {
        return placeOrderr;
    }

    public static void setPlaceOrder(boolean placeOrder) {
        Order.placeOrderr = placeOrder;
    }

    public static boolean isListOrder() {
        return listOrder;
    }

    public static void setListOrder(boolean listOrder) {
        Order.listOrder = listOrder;
    }


    public static boolean isListCategories() {
        return listCategories;
    }

    public static void setListCategories(boolean listCategories) {
        Order.listCategories = listCategories;
    }

    private int orderId;
    private List<Product> orderedProducts;
    private double totalPrice;
    private static Logger logger = Logger.getLogger(Order.class.getName());
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
        
        for (Product product : orderedProducts) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public static void manageOrders() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\nOrder Management\n1. Place Order\n2. List Orders" +
                    "\n3. List Categories\n4. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setPlaceOrder(true);
                    placeOrder();
                    break;
                case 2:
                    setListOrder(true);
                    listOrders();
                    break;
                case 3:
                    setListCategories(true);
                    listCategories();
                    break;
                case 4:
                    return;
                default:
                    logger.info(xchoice);
            }
        }
    }

    public static void placeOrder() {
        Scanner scanner = new Scanner(System.in);


        logger.info("Available Products:");
        listProducts();


        logger.info("Do you want to search specifc products ? (y/n)");
        String pro = scanner.nextLine();
        switch (pro){
            case "y":
                searchProducts();
                ordersteps();
                break;
            case "n":
                ordersteps();
                break;
            default:

                logger.info(xchoice);
                placeOrder();
        }


    }

    static List<Order> orderss;
    static Customer customer1;
    static List<Product> selectedProducts = new ArrayList<>();
    public static void orderstep1(String input){
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(input)&&product.getAvailablity()!=0) {
                selectedProducts.add(product);
                product.setAvailablity();
                listProducts();
                break;
            }else if (product.getAvailablity()==0){ logger.info("There is no enough");}
        }
    }
    public static void ordersteps(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("Enter the name of the product you want to order (or 'done' to finish): ");
            String input = scanner.nextLine();

            orderstep1(input);

            if (input.equalsIgnoreCase("done")) {
                logger.info("Do you want installation service ? (y/n)");
                String in = scanner.nextLine();
                switch (in){
                    case "y":
                        scheduleAppointment();
                        break;
                    case "n":
                        return;

                    default:
                        logger.info(xchoice);
                }
                break;

            }
        }
        if(Appointment.getinstaller()==null){
            logger.info(xchoice);
            return;
        }

        Customer customer = getLoggedInCustomer();
        Order order = new Order(orderIdCounter, selectedProducts);

        if (selectedProducts.isEmpty()) {
            logger.info("No products selected. Order not placed.");
        }


            if(customer==null){

                logger.info("Insert Customer Name: ");
                String customername=scanner.nextLine();
                logger.info("Insert Customer email: ");
                String customeremail=scanner.nextLine();
                customer1=new Customer(customername,customeremail,"","customer");
                customer1.getOrders().add(order);
                orderss=customer1.getOrders();
            }else customer.getOrders().add(order);
            orderIdCounter++;
            logger.info("Order placed successfully!");
        }

    public static void listOrders() {
        Customer customer = getLoggedInCustomer();
        if (customer != null) {
            logger.info("Orders for " + customer.getUsername() + ":");
            List<Order> orders = customer.getOrders();
            for (Order order : orders) {
                logger.info("Order ID: " + order.getOrderId());
                logger.info("Ordered Products:");
                for (Product product : order.getOrderedProducts()) {
                    logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
                }
                logger.info("Total Price: " + order.getTotalPrice());
            }
        } else {
            logger.info("Orders for " + customer1.getUsername() + ":");
            for (Order order : orderss) {
                logger.info("Order ID: " + order.getOrderId());
                logger.info("Ordered Products:");
                for (Product product : order.getOrderedProducts()) {
                    logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
                }
                logger.info("Total Price: " + order.getTotalPrice());
            }
        }
    }
}