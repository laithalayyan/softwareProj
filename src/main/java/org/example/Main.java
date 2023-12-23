package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


import roles.*;
import static roles.Appointment.*;
import static roles.Category.*;
import static roles.Customer.*;
import static roles.Installer.*;
import static roles.Order.*;
import static roles.Product.*;
import static roles.User.*;


public class Main {
    public static final ArrayList<User> userDatabase = new ArrayList<>();
    public static final List<Product> products = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();

    public static List<Installer> getInstallersDatabase() {
        return installersDatabase;
    }

    public static List<Product> getproductList(){
        return products;
    }
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

    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static final String INVALIDATION="Invalid choice. Please try again.";

    public static ArrayList<User> getUserDatabase() {
        return userDatabase;
    }
    public static void main(String[] args) {
        adminUser = new User("adminn", "admin@admin.com", "123", "admin");
        userDatabase.add(adminUser);

        String customerValue="customer";
        String installerValue="installer";


        customerUser = new User("customerlaith1", "customer@customer.com", "123",customerValue);
        userDatabase.add(customerUser);

        customerUser2 = new User("customerlaith2", "customer2@customer.com", "123",customerValue);
        userDatabase.add(customerUser2);

        installerUser = new Installer(1, "installerrlaith", "installer@installer.com","123",installerValue,"12/7/2023");
        installersDatabase.add(installerUser);

        installerUser2 = new Installer(2, "installerlaith2", "installer2@installer.com","123",installerValue,"2/2/2024");
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
        availabledate3=new AvailableDates("6/11/2023","installerrlaith2");
        availabledate4=new AvailableDates("8/11/2023","installerlaith2");
        availableDates.add(availabledate1);
        availableDates.add(availabledate2);
        availableDates.add(availabledate3);
        availableDates.add(availabledate4);



        Scanner scanner = new Scanner(System.in);

////////////////////////////////LOGIN AND REGISTER//////////////////////////////////////
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
                    logger.info(INVALIDATION);
            }
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

        logger.info("Enter your user type (customer, installer): ");
        String userType = scanner.nextLine();

        register(username,email,password,userType);
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

    ////////////////////////////////////////////////////////////////////
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
    ///////////////////////////////////ADMIN///////////////////////////////
    public static void adminDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            adminDash=true;
            if(isAdminLoggedIn()) {
                logger.info("\nAdmin Dashboard\n1. Manage Products\n2. Manage Categories\n3. Manage User Accounts\n4. Manage Customers\n" +
                        "5. Manage Installers\n6. Manage Appointments\n7. Manage Orders\n8. Logout\nChoose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        manageProductsLists();
                        break;
                    case 2:
                        manageCategories();
                        break;
                    case 3:
                        manageUserAccounts();
                        break;
                    case 4:
                        manageCustomersList();
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
                        logger.info(INVALIDATION);
                }
            }}
    }
    //////////////////////////MANAGE PRODUCTS///////////////////////
    public static int manageProductsLists(){
        Scanner scanner = new Scanner(System.in);
        logger.info("\nProduct Management\n1. Add Product\n2. Delete Product" +
                "\n3. List Products\n4. Back\nChoose an option: ");
        int choice = scanner.nextInt();
        manageProducts(choice);
        return choice;
    }
    public static int manageProducts(int choice) {
        switch (choice) {
            case 1:
                setAddProduct(true);
                addProduct();
                return 1;
            case 2:
                setDeleteProduct(true);
                deleteProduct();
                return 2;
            case 3:
                setListProduct(true);
                listProducts(products);
                return 3;
            case 4:
                adminDashboard();
                return 4;
            default:
                logger.info("Invalid choice. Please try again.");
        }
        return 5;
    }
    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter product name: ");
        String name = scanner.nextLine();
        logger.info("Enter product price: ");
        double price = scanner.nextDouble();
        logger.info("Enter category name: ");
        String category = scanner.nextLine();
        logger.info("Enter product amount: ");
        int ava = scanner.nextInt();
        productadd(name,price,category,ava);
    }
    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the product name to delete: ");
        String name = scanner.nextLine();
        productdelete(name);
    }
    /////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE CATIGORIES/////////////////////
    public static void manageCategories() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nCategory Management\n1. Add Category\n2. Delete Category" +
                "\n3. List Categories\n4. Search Product\n5. Back\nChoose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        manageCat(choice);
    }
    public static void manageCat(int choice){
        switch (choice) {
            case 1:
                setAddcat(true);
                addCategory();
                break;
            case 2:
                setDeletecat(true);
                deleteCategory();
                break;
            case 3:
                setListcat(true);
                listCategories();
                break;
            case 4:
                setSearchproduct(true);
                searchProducts();
                break;
            case 5:
                return;
            default:
                logger.info("Invalid choice. Please try again.");
        }
    }
    private static void addCategory() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter category name: ");
        String name = scanner.nextLine();
        addcatTEG(name);
        logger.info("Do you want to add products to this Category(y) , or leave it empty(n) ? ");
        String c = scanner.nextLine();
        switch (c) {
            case "y":
                logger.info("Enter product name: ");
                String pname = scanner.nextLine();
                logger.info("Enter product price: ");
                double price = scanner.nextDouble();
                logger.info("Enter product availability: ");
                int ava = scanner.nextInt();
                products.add(new Product(pname, price, name,ava));
                logger.info("Product added successfully.");
                break;
            case "n":
                addnoti();
                break;
            default:
                logger.info("Wrong choice!");
        }
    }
    private static void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the category name to delete: ");
        String name = scanner.nextLine();
        deletecat(name);
    }
    public static void deletecat(String name){

        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                for (Product product : products) {
                    if (product.getCategory().equals(name)) {
                        products.remove(product);
                        return;
                    }
                    deletenoti();

                }
            }

        }

    }
    public static void listCategories() {
        logger.info("Categories:");
        for (Category category : categories) {

            logger.info( category.getName()  );
        }
        Scanner scanner = new Scanner(System.in);
        logger.info("Select Category to Show category products: ");
        String cat = scanner.nextLine();
        for(Product product:products) {
            if (product.getCategory().equalsIgnoreCase(cat)) {
                logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }
    public static void searchProducts(){
        Scanner scanner = new Scanner(System.in);
        logger.info("Search for specific product by name:");
        String pro = scanner.nextLine();
        productsearch(pro);
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE USERS ACCOUNTS/////////////////////
    public static void manageUserAccounts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("User Account Management\n1. List User Accounts\n2. Delete User Account\n3. Back\nChoose an option: ");
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
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE CUSTOMERS//////////////////////////
    public static int manageCustomersList(){
        Scanner scanner = new Scanner(System.in);
        logger.info("\nCustomer Management\n1. Register Customer\n2. List Customers" +
                "\n3. Back\nChoose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return manageCustomers(choice);
    }
    public static int manageCustomers(int choice){
        switch (choice) {
            case 1:
                setRegCustomer(true);
                registerCustomer();
                return 1;
            case 2:
                setListCustomer(true);
                listCustomers();
                return 2;
            case 3:
                return 3;
            default:
                logger.info("Invalid choice. Please try again.");
        }
        return 5;
    }
    public static String registerCustomer() {

        Scanner scanner = new Scanner(System.in);
        String username = regCustName(scanner);
        String email = regCustEmail(scanner);
        String password = regCustPass(scanner);

        if (regCustTest(username, email, password, CUSTOMERU)) {
            return "Customer registration successful!";
        } else {
            return "Customer registration failed. User with the same email already exists.";
        }
    }
    public static String regCustName(Scanner scanner){

        logger.info("Enter customer's username: ");
        return scanner.nextLine();
    }
    public static String regCustEmail(Scanner scanner){

        logger.info("Enter customer's email: ");
        return scanner.nextLine();
    }
    public static String regCustPass(Scanner scanner){

        logger.info("Enter customer's password: ");
        return scanner.nextLine();
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE INSTALLERS/////////////////////////
    public static void manageInstallers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("\nInstaller Management\n1. Register Installer\n2. List Installers" +
                    "\n3. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setRegInstaller(true);
                    registerInstaller();
                    break;
                case 2:
                    setListInstaller(true);
                    listInstallers();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
    public static void registerInstaller() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter installer's id: ");
        int id = scanner.nextInt();

        logger.info("Enter installer's username: ");
        String username = scanner.nextLine();

        logger.info("Enter installer's email: ");
        String email = scanner.nextLine();

        logger.info("Enter installer's password: ");
        String password = scanner.nextLine();

        logger.info("Enter the dates you are available at(Write 'Done' When finish)");
        String date = scanner.nextLine();
        switch (date){
            case "done":
                break;
            default:
                installersDatabase.add(new Installer(id,username, email, password,"installer",date));
                availableDates.add(new AvailableDates(date,getLoggedIngetName()));
                date();
        }
        logger.info(INSTALLERSUCCESS);
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE APPOINTMENTS///////////////////////
    public static void manageAppointments() {
        Scanner scanner = new Scanner(System.in);
        Installer installer1 = getLoggedInInstaller();
        logger.info("Appointment Management\n1. List Appointments\n2. Back\nChoose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                listAppointments(installer1,installersDatabase);
                break;
            case 2:
                return;

            default:
                logger.info("Invalid choice. Please try again.");
        }
    }
    public static void date(){
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        switch (date){
            case "done":
                break;
            default:
                availableDates.add(new AvailableDates(date,getLoggedIngetName()));
                date();
        }
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE ORDERS/////////////////////////////
    static String xchoice="Invalid choice. Please try again.";
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
        listProducts(products);
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
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////



    ///////////////////////////CUSTOMER DASH/////////////////////////////
    public static void customerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\ncustomer Dashboard\n1. Browse products\n2. make purchases\n3. view orders\n4. List Categories\n" +
                    "5. Logout\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts(products);
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
                    logger.info(INVALIDATION);
            }
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

    public static void installerDashboard() {
        Scanner scanner = new Scanner(System.in);
        Installer installer1 = getLoggedInInstaller();

        while (true) {
            logger.info("\ninstaller Dashboard\n1. View installation requests\n2. schedule appointments" +
                    "\n3. Logout\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAppointments(installer1,installersDatabase);
                    break;
                case 2:
                    scheduleAppointment2();
                    break;
                case 3:
                    logger.info("Logging out from the installer dashboard.");
                    loginUser();
                    return;
                default:
                    logger.info(INVALIDATION);
            }
        }
    }

    public static List<Order> orderss;
    public static Customer customer1;
    public static List<Product> selectedProducts = new ArrayList<>();
    public static void ordersteps(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("Enter the name of the product you want to order (or 'done' to finish): ");
            String input = scanner.nextLine();

            orderstep1(input,products);

            if (input.equalsIgnoreCase("done")) {
                logger.info("Do you want installation service ? (y/n)");
                String in = scanner.nextLine();
                switch (in){
                    case "y":
                        scheduleAppointment2();
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

    public static void scheduleAppointment2(){
        setChooseSchedule(true);
        Scanner scanner = new Scanner(System.in);
        logger.info("what is your car model ?");
        String carmodel = scanner.nextLine();
        logger.info("what is your car date ?");
        String carDate = scanner.nextLine();
        logger.info("Choose the installer you want ");
        logger.info("Available Installers:");
        listInstallers();
        logger.info("Enter the # of the installer date you want to schedule an appointment with: ");
        int installerId = scanner.nextInt();
        scanner.nextLine();
        scheduleAppointment(carmodel,carDate,installerId,installersDatabase);
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
    public static void addcatTEG(String name){
        categories.add(new Category(name));
    }

    public static Installer getLoggedInInstaller() {

        for (Installer installer : installersDatabase) {
            if (installer.getEmail().equals(getLoggedIngetEmail())) {
                return installer;
            }
        }
        return null;
    }
}

