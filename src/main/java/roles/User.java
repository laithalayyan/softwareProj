package roles;

import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
//import static roles.Customer.getLoggedInCustomer;
import static roles.Customer.customers;
import static roles.Order.manageOrders;

public class User {
    private String username;
    private String email;
    private String password;
    private String userType;

    private static boolean adminIsLogged;
    private static boolean customerIsLogged;
    private boolean installerIsLogged;
    private boolean issignedup ;
    public static String customerOrder;

    public void setIssignedup(boolean issignedup){
        this.issignedup=issignedup;
    }

    public static String loggedIngetEmail;
    public static String loggedIngetEmailCustomer;

    /*private List<Order> orders;
    public List<Order> getOrders() {
        return orders;
    }*/

    public User() {

    }
    public User(String username, String email, String password, String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

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
            System.out.println("User Account Management");
            System.out.println("1. List User Accounts");
            System.out.println("2. Delete User Account");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
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
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listUserAccounts() {
        System.out.println("User Accounts:");
        for (User user : userDatabase) {
            System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail() + ", User Type: " + user.getUserType());
        }
        for (Installer installer : installersDatabase) {
            System.out.println("Username: " + installer.getUsername() + ", Email: " + installer.getEmail() + ", User Type: " + installer.getUserType());
        }
    }

    private static void deleteUserAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the email of the user account to delete: ");
        String email = scanner.nextLine();

        for (User user : userDatabase) {
            if (user.getEmail().equals(email)) {
                userDatabase.remove(user);
                System.out.println("User account deleted successfully.");
                return;
            }
        }

        System.out.println("User account not found.");
    }
    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your user type (admin, customer, installer): ");
        String userType = scanner.nextLine();

        User us = new User(username, email, password, userType);

        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                System.out.println("this user already exist");
                return ;}

        }
        System.out.println("Registration successful!");
        userDatabase.add(us);


    }

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();



        for (User user : userDatabase) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)&&user.getUserType().equalsIgnoreCase("admin")) {
                System.out.println("Login successful. User type: " + user.getUserType());

                if (isAdminLoggedIn()) {
                    adminDashboard();
                    adminIsLogged=true;
                }
                else System.out.println("You need to log in correctly");
                break; }
            else if(user.getEmail().equals(email) && user.getPassword().equals(password)&&user.getUserType().equalsIgnoreCase("customer")){
                //List<Customer> customer=user.getEmail();
                Customer customer = new Customer(user.getUsername(), user.getEmail(), user.getPassword(), user.getUserType());
                customers.add(customer);
                loggedIngetEmailCustomer = user.getEmail();
                customerOrder=user.getEmail();

                  if(isCustomerLoggedIn()) {
                      customerDashboard();
                      //manageOrders();
                      customerIsLogged = true;
                }
            }
            else
                for (Installer installer : installersDatabase){
                    if(installer.getEmail().equals(email) && installer.getPassword().equals(password) && installer.getUserType().equalsIgnoreCase("installer")){
                        loggedIngetEmail = installer.getEmail();

                        System.out.println("Login successful. User type: " + installer.getUserType());
                        installerDashboard();
                    }
                }


        }

        System.out.println("Login failed. Please check your email and password.");
    }

    public boolean isloggedin(){
        return adminIsLogged && customerIsLogged && installerIsLogged;
    }
    public void login(){
        adminIsLogged=true;
        customerIsLogged=true;
        installerIsLogged=true;
    }
    public void logout(){
        adminIsLogged=false;
        customerIsLogged=false;
        installerIsLogged=false;
    }


    public boolean isAdminIsLogged() {
        return adminIsLogged;
    }

    public boolean isCustomerIsLogged() {
        return customerIsLogged;
    }

    public boolean isInstallerIsLogged() {
        return installerIsLogged;
    }
    public boolean isIssignedup() {
        return issignedup;
    }
}