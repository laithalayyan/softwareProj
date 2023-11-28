package roles;


import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.AdminDashboard.*;

public class Product {
    public static boolean addProduct;
    public static boolean deleteProduct;
    public static boolean listProduct;

    public static boolean isAddProduct() {
        return addProduct;
    }

    public static void setAddProduct(boolean addProduct) {
        Product.addProduct = addProduct;
    }

    public static boolean isDeleteProduct() {
        return deleteProduct;
    }

    public static void setDeleteProduct(boolean deleteProduct) {
        Product.deleteProduct = deleteProduct;
    }

    public static boolean isListProduct() {
        return listProduct;
    }

    public static void setListProduct(boolean listProduct) {
        Product.listProduct = listProduct;
    }

    private String name;
    private double price;

    private String category;

    private int availablity;

    private static Logger logger = Logger.getLogger(Product.class.getName());

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
            logger.info("\nProduct Management\n1. Add Product\n2. Delete Product" +
                    "\n3. List Products\n4. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setAddProduct(true);
                    addProduct();
                    break;
                case 2:
                    setDeleteProduct(true);
                    deleteProduct();
                    break;
                case 3:
                    setListProduct(true);
                    listProducts();
                    break;
                case 4:
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
    public static void productadd(String name,double price,String category,int amount){
        products.add(new Product(name, price, category,amount));
        logger.info("Product added successfully.");
    }
    public static void productdelete(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                logger.info("Product deleted successfully.");
                return;
            }
        }
        logger.info("Product not found.");
    }

    private static void addProduct() {
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

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the product name to delete: ");
        String name = scanner.nextLine();
        productdelete(name);

    }

    public static void listProducts() {
        logger.info("Products:");
        for (Product product : products) {
            logger.info("Name: " + product.getName() + ", Price: " + product.getPrice() +", Category: " + product.getCategory() + ", Availability: " + product.getAvailablity() );
        }
    }

    public static void productsearch(String name){
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
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



}
