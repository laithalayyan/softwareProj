package roles;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
import static roles.User.loggedIngetEmail;

public class Installer {
    private int id;
    private String username;
    private String email;
    private String password;
    private String userType;

    private String avaialable;
    private List<Appointment> appointments;
    //private static List<Installer> installersDatabase = new ArrayList<>();

    public Installer(int id ,String username, String email, String password,String userType,String avaialable) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = "installer";
        this.avaialable=avaialable;
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

    public static void manageInstallers() {
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

        System.out.print("Enter the first date you are available at ");
        String avaialable = scanner.nextLine();

        installersDatabase.add(new Installer(id,username, email, password,"installer",avaialable));
        System.out.println("Installer registration successful!");
    }

    public static void listInstallers() {
        System.out.println("Installers:");
        for (Installer installer : installersDatabase) {
            System.out.println("Installer ID: " + installer.getId()+" Installer name: " + installer.getUsername() + ", Email: " + installer.getEmail());
        }
    }

    public static Installer getLoggedInInstaller() {

        for (Installer installer : installersDatabase) {
            if (installer.getEmail().equals(loggedIngetEmail)) {
                return installer;
            }
        }
        return null;
    }
}
