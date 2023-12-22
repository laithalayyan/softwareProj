package roles;


import java.util.logging.Logger;

import static org.example.Main.*;
import java.util.List;

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


    public static void productadd(String name,double price,String category,int amount){
        products.add(new Product(name, price, category,amount));
        logger.info("Product added successfully.");
    }
    public static boolean productaddTest(String name,double price,String category,int amount){
        for (Product product : products) {
            if (product.getName().equals(name)) {

                logger.info("Product Found.");
                return false;
            }
        }
        products.add(new Product(name, price, category,amount));
        logger.info("Product added successfully.");
        return true;
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
    public static boolean productdeleteTest(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                logger.info("Product deleted successfully.");
                return true;
            }
        }
        logger.info("Product not found.");
        return false;

    }




    public static void listProductsOrder() {
        logger.info("Products:");
        for (Product product : products) {
            logger.info("Name: " + product.getName() + ", Price: " + product.getPrice() +", Category: " + product.getCategory() + ", Availability: " + product.getAvailablity() );
        }
    }

    public static void listProducts(List<Product> products) {
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




}
