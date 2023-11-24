package roles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import static org.example.AdminDashboard.*;
import static org.example.AdminDashboard.categories;
import java.awt.image.*;

public class Product {


    private String name;
    private double price;

    private String category;

    private int availablity;

    public Product(String name, double price,String category,int availablity ) {
        this.name = name;
        this.price = price;
        this.category=category;
        this.availablity=availablity;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setAvailablity() {
        availablity = availablity-1;
    }

    public double getPrice() {
        return price;
    }
    public int getAvailablity() {
        return availablity;
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
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();
        System.out.print("Enter product amount: ");
        int ava = scanner.nextInt();
        products.add(new Product(name, price, category,ava));
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
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() +", Category: " + product.getCategory() + ", Availability: " + product.getAvailablity() );
        }
    }

    public static void searchProducts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for specific product by name:");
        String pro = scanner.nextLine();
        for (Product product : products) {

            if (product.getName().equalsIgnoreCase(pro)) {
                System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }



}
