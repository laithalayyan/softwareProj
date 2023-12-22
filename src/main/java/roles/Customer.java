package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.example.Main.*;
import static roles.User.getLoggedIngetEmailCustomer;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String password;
    private String userType;
    public List<roles.Order> orders;
    public static List<Customer> customers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Customer.class.getName());

    public Customer(){}
    public static final String CUSTOMERU="customer";
    public Customer(String username, String email, String password,String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
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




    public static boolean regCust(String username,String email,String password,String type){
        /*User us = new User(username, email, password, type);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return ;}
        }
        userDatabase.add(us);
        logger.info("Customer registration successful!");*/
        //User user = new User(username, email, password, type);
        User user = new User(username, email, password, type);
        if (!userDatabase.contains(user)) {
            userDatabase.add(user);
            logger.info("Customer registration successful!");
            return true;  // Registration successful
        } else {
            logger.info("Customer registration failed. User with the same email already exists.");
            return false;  // Registration failed
        }
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




    public static String listCustomers() {
        StringBuilder customerList = new StringBuilder("Customers:\n");

        // Debugging information
        System.out.println("Number of users in userDatabase: " + userDatabase.size());

        for (User user : userDatabase) {
            // Debugging information
            System.out.println("User Type: " + user.getUserType());

            if (user.getUserType().equalsIgnoreCase(CUSTOMERU)) {
                customerList.append("Username: ").append(user.getUsername()).append(", Email: ").append(user.getEmail()).append("\n");
            }
        }

        // Debugging information
        System.out.println("Generated Customer List: " + customerList.toString());

        return customerList.toString();
    }

    public static Customer getLoggedInCustomer() {
        for (Customer customer : customers) {

            if (customer.getEmail().equals(getLoggedIngetEmailCustomer())) {
                return customer;
            }
        }
        return null ;
    }
    public static String getLoggedInCustomerName() {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(getLoggedIngetEmailCustomer())) {
                return customer.getUsername();
            }
        }
        return null ;
    }





}