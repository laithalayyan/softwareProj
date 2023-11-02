package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import roles.*;

import static roles.Appointment.listAppointments;
import static roles.Appointment.scheduleAppointment;
import static roles.Category.manageCategories;
//import static roles.Customer.getLoggedInCustomer;
import static roles.Installer.listInstallers;
import static roles.Order.listOrders;
import static roles.Order.placeOrder;
import static roles.Product.listProducts;
import static roles.Product.manageProducts;
import static roles.User.*;


public class AdminDashboard {
    public static ArrayList<User> userDatabase = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();

    public static List<Customer> customers = new ArrayList<>();
    public static List<Installer> installers = new ArrayList<>();
    public static int orderIdCounter = 1;
    public static int appointmentIdCounter = 1;
    public static User adminUser;
    public static User customerUser;
    public static User installerUser;
    public static Product product;


    public static void main(String[] args) {
        adminUser = new User("admin", "admin@admin.com", "123", "admin");
        userDatabase.add(adminUser);

        customerUser = new User("customerlith", "customer@customer.com", "123","customer");
        userDatabase.add(customerUser);

        installerUser = new User("intallerlith", "installer@installer.com", "123","installer");
        userDatabase.add(installerUser);

        product=new Product("laith",20);
        products.add(product);
        product=new Product("laith2",20);
        products.add(product);
        product=new Product("laith3",20);
        products.add(product);






        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }






    public static boolean isAdminLoggedIn() {
        return adminUser != null && adminUser.getUserType().equals("admin");
    }
    public static boolean isCustomerLoggedIn() {
        return customerUser != null && customerUser.getUserType().equals("customer");
    }
    public static boolean isInstallerLoggedIn() {
        return installerUser != null && installerUser.getUserType().equals("installer");
    }

    public static void adminDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Dashboard");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Categories");
            System.out.println("3. Manage User Accounts");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageCategories();
                    break;
                case 3:
                    manageUserAccounts();
                    break;
                case 4:
                    System.out.println("Logging out from the admin dashboard.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void customerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("customer Dashboard");
            System.out.println("1. Browse products");
            System.out.println("2. make purchases");
            System.out.println("3. view orders");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    listOrders();
                    break;
                case 4:
                    System.out.println("Logging out from the admin dashboard.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void installerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("installer Dashboard");
            System.out.println("1. View installation requests");
            System.out.println("2. View schedule appointments");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    listAppointments();
                    break;
                case 3:
                    System.out.println("Logging out from the admin dashboard.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}

