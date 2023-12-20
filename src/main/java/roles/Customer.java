package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.AdminDashboard.*;
import static roles.User.loggedIngetEmail;
import static roles.User.loggedIngetEmailCustomer;


public class Customer {
    public static boolean regCustomer;
    public static boolean listCustomer;

    public static boolean isRegCustomer() {
        return regCustomer;
    }

    public static void setRegCustomer(boolean regCustomer) {
        Customer.regCustomer = regCustomer;
    }

    public static boolean isListCustomer() {
        return listCustomer;
    }

    public static void setListCustomer(boolean listCustomer) {
        Customer.listCustomer = listCustomer;
    }


    private String username;
    private String email;
    private String password;
    private String userType;
    public List<roles.Order> orders;
    public static List<Customer> customers = new ArrayList<>();
    private static Logger logger = Logger.getLogger(Customer.class.getName());

    public Customer(){}
    public Customer(String username, String email, String password,String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = "customer";
        this.orders = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }



    public List<Order> getOrders() {
        return orders;
    }

    public static void manageCustomers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\nCustomer Management\n1. Register Customer\n2. List Customers" +
                    "\n3. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setRegCustomer(true);
                    registerCustomer();
                    break;
                case 2:
                    setListCustomer(true);
                    listCustomers();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    public static void regCust(String username,String email,String password,String type){
        User us = new User(username, email, password, type);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return ;}
        }
        userDatabase.add(us);
        logger.info("Customer registration successful!");
    }
    public static boolean regCustTest(String username,String email,String password,String type){
        User us = new User(username, email, password, type);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return false;}
        }
        userDatabase.add(us);
        logger.info("Customer registration successful!");
        return true;
    }
    public static void registerCustomer() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter customer's username: ");
        String username = scanner.nextLine();

        logger.info("Enter customer's email: ");
        String email = scanner.nextLine();

        logger.info("Enter customer's password: ");
        String password = scanner.nextLine();

        regCust(username,email,password,"customer");




    }

    public static void listCustomers() {
        logger.info("Customers:");
        for (User user : userDatabase) {
            if(user.getUserType().equalsIgnoreCase("customer")){
                logger.info("Username: " + user.getUsername() + ", Email: " + user.getEmail());
            }

        }
    }

    public static Customer getLoggedInCustomer() {
        for (Customer customer : customers) {

            if (customer.getEmail().equals(loggedIngetEmailCustomer)) {
                return customer;
            }
        }
        return null ;
    }
    public static String getLoggedInCustomerName() {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(loggedIngetEmailCustomer)) {
                return customer.getUsername();
            }
        }
        return null ;
    }

    public static Customer getOrderdCustomer() {
        for (Customer customer : customers) {

            if (customer.getEmail().equals(loggedIngetEmail)) {
                return customer;
            }
        }
        return null ;
    }




}