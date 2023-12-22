package roles;

import java.util.List;
import java.util.logging.Logger;

import static org.example.Main.*;
import static roles.Customer.getLoggedInCustomer;
import static roles.Product.listProducts;

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