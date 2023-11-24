package roles;

import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
//import static roles.Customer.getLoggedInCustomer;
import static roles.Customer.getLoggedInCustomer;
import static roles.Installer.getLoggedInInstaller;
import static roles.Installer.listInstallers;
import static roles.Order.listOrders;
import static roles.User.customerOrder;

import org.example.AdminDashboard.*;

public class Appointment {
    private int appointmentId;
    private String customerName;
    private String appointmentDate;

    private String carModer;
    private String carDate;

    //private List<Product> orderedProducts;

    public Appointment(int appointmentId, String customerName, String appointmentDate,String carModer , String carDate) {
        this.appointmentId = appointmentId;
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.carDate=carDate;
        this.carModer=carModer;
    }

    public String getCustomerCarDate() {
        return carDate;
    }

    public String getCustomerCarModel() {
        return carModer;
    }
    public int getAppointmentId() {
        return appointmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }


    public static void manageAppointments() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Appointment Management");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. List Appointments");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    listAppointments();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void scheduleAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your car model ?");
        String carmodel = scanner.nextLine();
        System.out.println("what is your car date ?");
        String cardate = scanner.nextLine();

        System.out.println("Choose the installer you want ");
        System.out.println("Available Installers:");
        listInstallers();

        System.out.print("Enter the # of the installer you want to schedule an appointment with: ");
        int installerId = scanner.nextInt();
        scanner.nextLine();

        Installer selectedInstaller = null;
        for (Installer installer : installersDatabase) {
            if (installerId == installer.getId()) {
                selectedInstaller = installer;
                break;
            }
        }

        if (selectedInstaller != null) {
            System.out.print("Enter the appointment date: ");
            String appointmentDate = scanner.nextLine();
            Appointment appointment = new Appointment(appointmentIdCounter, getLoggedInCustomer().getUsername(), appointmentDate,carmodel,cardate);
            selectedInstaller.getAppointments().add(appointment);
            appointmentIdCounter++;
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Installer not found with the given ID.");
        }

    }

    public static void listAppointments() {
        Installer installer = getLoggedInInstaller();
        if (installer != null) {
            System.out.println("Appointments for " + installer.getUsername() + ":");
            List<Appointment> appointments = installer.getAppointments();
            for (Appointment appointment : appointments) {

                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Customer Name: " + appointment.getCustomerName());
                System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                System.out.println("Customer Car Date: " + appointment.getCustomerCarDate());
                System.out.println("Customer Car Model: " + appointment.getCustomerCarModel());
                System.out.println("Products wanted: " );
                listOrders();
                System.out.println("----------");
            }
        } else {
            System.out.println("You need to log in as an installer to view appointments.");
        }
    }
}
