package org.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import roles.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.*;

import javax.imageio.ImageIO;

//import static roles.Category.manageCategories;
//import static roles.Customer.getLoggedInCustomer;
import static roles.Appointment.*;
import static roles.Category.listCategories;
import static roles.Category.manageCategories;
import static roles.Customer.manageCustomers;
import static roles.Installer.listInstallers;
import static roles.Installer.manageInstallers;
import static roles.Order.*;
import static roles.Product.*;
import static roles.User.*;


public class AdminDashboard {
    public static ArrayList<User> userDatabase = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();

    //public static List<Customer> customers = new ArrayList<>();
    public static List<Installer> installersDatabase = new ArrayList<>();
    public static int orderIdCounter = 1;
    public static int appointmentIdCounter = 1;
    public static User adminUser;
    public static User customerUser;
    public static User customerUser2;
    public static Installer installerUser;
    public static Installer installerUser2;
    public static Product product;
    public static Category categoryy;


    public static void main(String[] args) {
        adminUser = new User("admin", "admin@admin.com", "123", "admin");
        userDatabase.add(adminUser);

        customerUser = new User("customerlaith1", "customer@customer.com", "123","customer");
        userDatabase.add(customerUser);

        customerUser2 = new User("customerlaith2", "customer2@customer.com", "123","customer");
        userDatabase.add(customerUser2);

        installerUser = new Installer(1, "installerlaith", "installer@installer.com","123","installer","12-12-2023");
        installersDatabase.add(installerUser);

        installerUser2 = new Installer(2, "installerlaith2", "installer2@installer.com","123","installer","12-11-2023");
        installersDatabase.add(installerUser2);

        categoryy=new Category("Interior");
        categories.add(categoryy);
        categoryy=new Category("Exterior");
        categories.add(categoryy);
        categoryy=new Category("Mirors");
        categories.add(categoryy);
        categoryy=new Category("Tears");
        categories.add(categoryy);
        product=new Product("miror",20,"mirors",20);
        products.add(product);
        product=new Product("tear",20,"tears",30);
        products.add(product);
        product=new Product("interior",20,"Interior",40);
        products.add(product);
        product=new Product("exterior",20,"Exterior",50);
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

    private static boolean adminDash;
    public static void adminDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            adminDash=true;
            if(isAdminLoggedIn()==true) {
                System.out.println("Admin Dashboard");
                System.out.println("1. Manage Products");
                System.out.println("2. Manage Categories");
                System.out.println("3. Manage User Accounts");
                System.out.println("4. Manage Customers");
                System.out.println("5. Manage Installers");
                System.out.println("6. Manage Appointments");
                System.out.println("7. Manage Orders");
                System.out.println("8. Logout");
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
                        manageCustomers();
                        break;
                    case 5:
                        manageInstallers();
                        break;
                    case 6:
                        manageAppointments();
                        break;
                    case 7:
                        manageOrders();
                        break;
                    case 8:
                        System.out.println("Logging out from the admin dashboard.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }}
    }

    public static void customerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("customer Dashboard");
            System.out.println("1. Browse products");
            System.out.println("2. make purchases");
            System.out.println("3. view orders");
            System.out.println("4. List Categories");
            System.out.println("5. Logout");
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
                    listCategories();
                    break;
                case 5:
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
            System.out.println("2. schedule appointments");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAppointments();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    System.out.println("Logging out from the installer dashboard.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}

