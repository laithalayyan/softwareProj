package roles;

import java.util.Scanner;

import static org.example.AdminDashboard.categories;
import static org.example.AdminDashboard.products;
import static roles.Product.searchProducts;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void manageCategories() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Category Management");
            System.out.println("1. Add Category");
            System.out.println("2. Delete Category");
            System.out.println("3. List Categories");
            System.out.println("4. Search Product");
            System.out.println("5. Back");
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
                    searchProducts();
                    break;
                case 5:
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

        System.out.println("Do you want to add products to this Category(y) , or leave it empty(n) ? ");
        String c = scanner.nextLine();
        switch (c) {
            case "y":
                System.out.print("Enter product name: ");
                String pname = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter product availability: ");
                int ava = scanner.nextInt();
                products.add(new Product(pname, price, name,ava));
                System.out.println("Product added successfully.");
            case "n":
                System.out.println("Category added successfully.");

        }

    }

    private static void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category name to delete: ");
        String name = scanner.nextLine();
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                for (Product product : products) {
                    if (product.getCategory().equals(name)) {
                        products.remove(product);
                        return;
                    }
                }
                System.out.println("Category deleted successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    public static void listCategories() {
        System.out.println("Categories:");
        for (Category category : categories) {
            /*if(!categories.contains(product.getCategory())){
                categories.add(product.getCategory());
            }*/

            System.out.println( category.getName()  );
        }
        /*for(int i=0 ;i<categories.size();i++){
            System.out.println("Name: " + categories.get(i));
        }*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select Category to Show category products: ");
        String cat = scanner.nextLine();
        for(Product product:products) {
            if (product.getCategory().equalsIgnoreCase(cat)) {
                System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }


}
