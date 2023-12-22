package roles;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.AdminDashboard.categories;
import static org.example.AdminDashboard.products;
import static roles.Product.searchProducts;

public class Category {
    public static boolean ADD_CATTEGO;
    public static boolean DELETE_CAT=true;
    public static boolean listcat;
    public static boolean searchproduct;

    public static void setSearchproduct(boolean searchproduct) {
        Category.searchproduct = searchproduct;
    }
    public static boolean isListcat() {
        return listcat;
    }

    public static void setListcat(boolean listcat) {
        Category.listcat = listcat;
    }
    public static void setAddcat(boolean addcat) {
        Category.ADD_CATTEGO = addcat;
    }

    public static boolean isAddcat() {
        return ADD_CATTEGO;
    }
    public static boolean isDeletecat() {
        return DELETE_CAT;
    }

    public static void setDeletecat(boolean deletecat) {
        Category.DELETE_CAT = deletecat;
    }


    private String name;
    private static Logger logger = Logger.getLogger(Category.class.getName());

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void manageCategories() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\nCategory Management\n1. Add Category\n2. Delete Category" +
                    "\n3. List Categories\n4. Search Product\n5. Back\nChoose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
    }

    public static void addcatTEG(String name){
        categories.add(new Category(name));
    }

    public static boolean addcatTest(String name){
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                logger.info("Category exist");
                return false;
                }
            }
        categories.add(new Category(name));
        addnoti();
        return true;
        }

    public static boolean deletecatTest(String name){
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                deletenoti();
                return true;
            }
        }
        logger.info("Category not found.");
        return false;
    }
    public static void deletenoti(){
        logger.info("Category deleted successfully.");
    }
    public static void addnoti(){
        logger.info("Category addedd successfully.");
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

    public static void listCategoriesTest(){
        for (Category category : categories) {

            logger.info( category.getName()  );
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


}
