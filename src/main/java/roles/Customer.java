package roles;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static org.example.Main.*;
public class Customer {
    private static boolean regCustomer;
    private static boolean listCustomer;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return userType;
    }
    private String userType;
    private List<roles.Order> orders;
    public static final List<Customer> customers = new ArrayList<>();
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
        logger.info("Number of users in userDatabase: " + userDatabase.size());
        for (User user : userDatabase) {
            logger.info("User Type: " + user.getUserType());
            if (user.getUserType().equalsIgnoreCase(CUSTOMERU)) {
                customerList.append("Username: ").append(user.getUsername()).append(", Email: ").append(user.getEmail()).append("\n");
            }
        }
        logger.info("Generated Customer List: ");
        String cList=customerList.toString();
        logger.info(cList);
        return customerList.toString();
    }
}