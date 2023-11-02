package roles;

import java.util.Scanner;

import static org.example.AdminDashboard.categories;

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
}
