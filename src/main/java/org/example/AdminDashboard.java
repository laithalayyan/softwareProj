package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import roles.*;
import static roles.Appointment.*;
import static roles.Category.listCategories;
import static roles.Category.manageCategories;
import static roles.Customer.manageCustomers;
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
    public static List<AvailableDates> availableDates = new ArrayList<>();

    public static AvailableDates availabledate1;
    public static AvailableDates availabledate2;
    public static AvailableDates availabledate3;
    public static AvailableDates availabledate4;
    public static int orderIdCounter = 1;
    public static int appointmentIdCounter = 1;
    public static User adminUser;
    public static User customerUser;
    public static User customerUser2;
    public static Installer installerUser;
    public static Installer installerUser2;
    public static Product product;
    public static Category categoryy;

    private static Logger logger = Logger.getLogger(AdminDashboard.class.getName());

    public static ArrayList<User> getUserDatabase() {
        return userDatabase;
    }
    public static void main(String[] args) {
        adminUser = new User("admin", "admin@admin.com", "123", "admin");
        userDatabase.add(adminUser);

        customerUser = new User("customerlaith1", "customer@customer.com", "123","customer");
        userDatabase.add(customerUser);

        customerUser2 = new User("customerlaith2", "customer2@customer.com", "123","customer");
        userDatabase.add(customerUser2);

        installerUser = new Installer(1, "installerlaith", "installer@installer.com","123","installer","12/7/2023");
        installersDatabase.add(installerUser);

        installerUser2 = new Installer(2, "installerlaith2", "installer2@installer.com","123","installer","2/2/2024");
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

        availabledate1=new AvailableDates("20/11/2023","installerlaith");
        availabledate2=new AvailableDates("2/11/2023","installerlaith");
        availabledate3=new AvailableDates("6/11/2023","installerlaith2");
        availabledate4=new AvailableDates("8/11/2023","installerlaith2");
        availableDates.add(availabledate1);
        availableDates.add(availabledate2);
        availableDates.add(availabledate3);
        availableDates.add(availabledate4);



        Scanner scanner = new Scanner(System.in);


            logger.info("\n1.Register\n2.Login\n3.Exit\nChoose an option: ");

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
                    logger.info("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
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
                logger.info("\nAdmin Dashboard\n1. Manage Products\n2. Manage Categories\n3. Manage User Accounts\n4. Manage Customers\n" +
                        "5. Manage Installers\n6. Manage Appointments\n7. Manage Orders\n8. Logout\nChoose an option: ");
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
                        logger.info("Logging out from the admin dashboard.");
                        loginUser();
                        return;
                    default:
                        logger.info("Invalid choice. Please try again.");
                }
            }}
    }

    public static void customerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\ncustomer Dashboard\n1. Browse products\n2. make purchases\n3. view orders\n4. List Categories\n" +
                    "5. Logout\nChoose an option: ");
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
                    logger.info("Logging out from the admin dashboard.");
                    loginUser();
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    public static void installerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\ninstaller Dashboard\n1. View installation requests\n2. schedule appointments" +
                    "\n3. Logout\nChoose an option: ");
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
                    logger.info("Logging out from the installer dashboard.");
                    loginUser();
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }


}

