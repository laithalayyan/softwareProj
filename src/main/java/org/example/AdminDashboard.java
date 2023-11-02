import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String email;
    private String password;
    private String userType;

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
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class AdminDashboard {
    private static ArrayList<User> userDatabase = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static User adminUser;

    public static void main(String[] args) {
        adminUser = new User("admin", "admin@example.com", "adminpassword", "admin");
        userDatabase.add(adminUser);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Dashboard");
            System.out.println("4. Exit");
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
                    if (isAdminLoggedIn()) {
                        adminDashboard();
                    } else {
                        System.out.println("You need to log in as an admin to access the dashboard.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your user type (admin, customer, installer): ");
        String userType = scanner.nextLine();

        User user = new User(username, email, password, userType);
        userDatabase.add(user);

        System.out.println("Registration successful!");
    }

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : userDatabase) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful. User type: " + user.getUserType());
                return;
            }
        }

        System.out.println("Login failed. Please check your email and password.");
    }

    private static boolean isAdminLoggedIn() {
        return adminUser != null && adminUser.getUserType().equals("admin");
    }

    private static void adminDashboard() {
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

    private static void manageProducts() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Product Management");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. List Products");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    listProducts();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        products.add(new Product(name, price));
        System.out.println("Product added successfully.");
    }

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product name to delete: ");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                System.out.println("Product deleted successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void listProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }

    private static void manageCategories() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Category Management");
            System.out.println("1. Add Category");
            System.out.println("2. Delete Category");
            System.out.println("3. List Categories");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    deleteCategory();
                    break;
                case 3:
                    listCategories();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        categories.add(new Category(name));
        System.out.println("Category added successfully.");
    }

    private static void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category name to delete: ");
        String name = scanner.nextLine();
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                System.out.println("Category deleted successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    private static void listCategories() {
        System.out.println("Categories:");
        for (Category category : categories) {
            System.out.println("Name: " + category.getName());
        }
    }

    private static void manageUserAccounts() {
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
}
