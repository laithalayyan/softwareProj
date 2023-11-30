package roles;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import static org.example.AdminDashboard.*;
import static roles.Customer.customers;


public class User {

    public static boolean issignedup;

    public static boolean isIssignedup() {
        return issignedup;
    }

    public static void setIssignedup(boolean issignedup) {
        User.issignedup = issignedup;
    }

    public static boolean Adminislogged;
    public static boolean Installerislogged;
    public static boolean Customerislogged;

    public static boolean isAdminislogged() {
        return Adminislogged;
    }

    public static void setAdminislogged(boolean adminislogged) {
        Adminislogged = adminislogged;
    }

    public static boolean isInstallerislogged() {
        return Installerislogged;
    }

    public static void setInstallerislogged(boolean installerislogged) {
        Installerislogged = installerislogged;
    }

    public static boolean isCustomerislogged() {
        return Customerislogged;
    }

    public static void setCustomerislogged(boolean customerislogged) {
        Customerislogged = customerislogged;
    }

    private String username;

    private String email;
    private String password;
    private String userType;




    public static String customerOrder;
    private static Logger logger = Logger.getLogger(User.class.getName());


    public static String loggedIngetEmail;
    public static String loggedIngetName;
    public static String loggedIngetEmailCustomer;


    public User(String username, String email, String password, String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    protected static ArrayList<User> userDatabasee = new ArrayList<>();



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    public static void manageUserAccounts() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("User Account Management");
            logger.info("1. List User Accounts");
            logger.info("2. Delete User Account");
            logger.info("3. Back");
            logger.info("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listUserAccounts();
                    break;
                case 2:
                    deleteUserAccount();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    private static void listUserAccounts() {
        logger.info("User Accounts:");
        for (User user : userDatabase) {
            logger.info("Username: " + user.getUsername() + ", Email: " + user.getEmail() + ", User Type: " + user.getUserType());
        }
        for (Installer installer : installersDatabase) {
            logger.info("Username: " + installer.getUsername() + ", Email: " + installer.getEmail() + ", User Type: " + installer.getUserType());
        }
    }

    private static void deleteUserAccount() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the email of the user account to delete: ");
        String email = scanner.nextLine();

        for (User user : userDatabase) {
            if (user.getEmail().equals(email)) {
                userDatabase.remove(user);
                logger.info("User account deleted successfully.");
                return;
            }
        }

        logger.info("User account not found.");
    }
    public static void registerUser() {
        setIssignedup(false);
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter your username: ");
        String username = scanner.nextLine();

        logger.info("Enter your email: ");
        String email = scanner.nextLine();

        logger.info("Enter your password: ");
        String password = scanner.nextLine();

        logger.info("Enter your user type (admin, customer, installer): ");
        String userType = scanner.nextLine();

        register(username,email,password,userType);


    }
    public static void register(String username,String email,String password,String userType){
        User us = new User(username, email, password, userType);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return ;}
        }
        logger.info("Registration successful!");
        userDatabase.add(us);
    }
    public static boolean registerTest(String username,String email,String password,String userType){
        User us = new User(username, email, password, userType);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return false ;}
        }
        logger.info("Registration successful!");
        userDatabase.add(us);
        return true;
    }


    public static void loginUser() {
        setAdminislogged(false);
        setInstallerislogged(false);
        setCustomerislogged(false);

            Scanner scanner = new Scanner(System.in);

            logger.info("Enter your email: ");
            String email = scanner.nextLine();

            logger.info("Enter your password: ");
            String password = scanner.nextLine();
            signin(email,password);

    }
    public static void adminsignin(User user){

        logger.info("Login successful. User type: " + user.getUserType());
        setAdminislogged(true);
    }

    public static void customersignin(User user){
        Customer customer = new Customer(user.getUsername(), user.getEmail(), user.getPassword(), user.getUserType());
        customers.add(customer);
        loggedIngetEmailCustomer = user.getEmail();
        customerOrder = user.getEmail();
        logger.info("Login successful. User type: " + user.getUserType());
        setCustomerislogged(true);


    }
    public static void installersignin(String email ,String password){
        for (Installer installer : installersDatabase) {
            if (installer.getEmail().equals(email) && installer.getPassword().equals(password) && installer.getUserType().equalsIgnoreCase("installer")) {
                loggedIngetEmail = installer.getEmail();
                loggedIngetName = installer.getUsername();
                setInstallerislogged(true);
            }
        }
        logger.info("Login successful. User type: installer");
    }

    public static List getlist(){
        User customerUser= new User("customer", "customer@customer.com", "123", "customer");
        userDatabasee.add(customerUser);
        User adminUser= new User("admin", "admin@admin.com", "123", "admin");
        userDatabasee.add(adminUser);
        User installerUser= new User("installer", "installer@installer.com", "123", "installer");
        userDatabasee.add(installerUser);
        return userDatabasee;
    }
    public static boolean loginadmin(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("admin")) {
                adminsignin(user);
                return true;
            }
        }
        return false;
    }
    public static boolean logincustomer(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("customer")) {
                customersignin(user);
                return true;
            }
        }
        return false;
    }
    public static boolean logininstaller(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("installer")) {
                customersignin(user);
                return true;
            }
        }
        return false;
    }
    public static void signin(String email,String password){
        for (User user : userDatabase) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("admin")) {
                adminsignin(user);
                if (isAdminislogged()) {
                    adminDashboard();
                } else logger.info("You need to log in correctly");
            } else if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("customer")) {
                customersignin(user);
                if (isCustomerLoggedIn()) {
                    customerDashboard();
                }
            } else {
                installersignin(email, password);
                while (isInstallerislogged()) {
                    installerDashboard();
                }

            }



        }
        logger.info("Login failed. Please check your email and password.");

    }








}