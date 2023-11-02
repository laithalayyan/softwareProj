package roles;

import java.util.List;
import java.util.Scanner;

import static org.example.AdminDashboard.*;
//import static roles.Customer.getLoggedInCustomer;
import static roles.Installer.getLoggedInInstaller;
import static roles.Installer.listInstallers;
import org.example.AdminDashboard.*;

public class Appointment {
    private int appointmentId;
    private String customerName;
    private String appointmentDate;

    public Appointment(int appointmentId, String customerName, String appointmentDate) {
        this.appointmentId = appointmentId;
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
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


    private static void manageAppointments() {
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

        System.out.println("Available Installers:");
        listInstallers();

        System.out.print("Enter the ID of the installer you want to schedule an appointment with: ");
        int installerId = scanner.nextInt();
        scanner.nextLine();

        Installer selectedInstaller = null;
        for (Installer installer : installers) {
            if (installerId == installer.getId()) {
                selectedInstaller = installer;
                break;
            }
        }

        if (selectedInstaller != null) {
            System.out.print("Enter the appointment date: ");
            String appointmentDate = scanner.nextLine();
            //Appointment appointment = new Appointment(appointmentIdCounter, getLoggedInCustomer().getUsername(), appointmentDate);
            //selectedInstaller.getAppointments().add(appointment);
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
                System.out.println("----------");
            }
        } else {
            System.out.println("You need to log in as an installer to view appointments.");
        }
    }
}
