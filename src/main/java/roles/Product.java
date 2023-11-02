package roles;

import java.util.Scanner;

import static org.example.AdminDashboard.products;

public class Product {
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

    public static void manageProducts() {
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

    public static void listProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }

}
