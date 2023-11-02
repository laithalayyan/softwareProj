package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.adminUser;

public class Installer {
    private int id;
    private String username;
    private String email;
    private String password;
    private String userType;
    private List<Appointment> appointments;
    private static List<Installer> installers = new ArrayList<>();

    public Installer(int id ,String username, String email, String password,String userType) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = "installer";
        this.appointments = new ArrayList<>();
    }
    public int getId(){
        return id;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    private static void manageInstallers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Installer Management");
            System.out.println("1. Register Installer");
            System.out.println("2. List Installers");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerInstaller();
                    break;
                case 2:
                    listInstallers();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerInstaller() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter installer's id: ");
        int id = scanner.nextInt();

        System.out.print("Enter installer's username: ");
        String username = scanner.nextLine();

        System.out.print("Enter installer's email: ");
        String email = scanner.nextLine();

        System.out.print("Enter installer's password: ");
        String password = scanner.nextLine();

        installers.add(new Installer(id,username, email, password,"installer"));
        System.out.println("Installer registration successful!");
    }

    public static void listInstallers() {
        System.out.println("Installers:");
        for (Installer installer : installers) {
            System.out.println("Username: " + installer.getUsername() + ", Email: " + installer.getEmail());
        }
    }

    public static Installer getLoggedInInstaller() {

        for (Installer installer : installers) {
            if (installer.getUsername().equals(adminUser.getUsername())) {
                return installer;
            }
        }
        return null;
    }
}
