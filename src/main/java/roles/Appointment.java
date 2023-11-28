package roles;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import static org.example.AdminDashboard.*;
import static roles.Customer.getLoggedInCustomer;
import static roles.Installer.getLoggedInInstaller;
import static roles.Installer.listInstallers;
import static roles.Order.listOrders;


public class Appointment {
    public static boolean listappointment;
    public static boolean isChooseSchedule ;
    public static boolean isListappointment() {
        return listappointment;
    }
    public static void setListappointment(boolean listappointment) {
        Appointment.listappointment = listappointment;
    }
    public static boolean isChooseSchedule() {
        return isChooseSchedule;
    }
    public static void setChooseSchedule(boolean chooseSchedule) {
        isChooseSchedule = chooseSchedule;
    }
    private int appointmentId;
    private String customerName;
    private String appointmentDate;

    private String carModer;
    private String carDate;
    private static Logger logger = Logger.getLogger(Appointment.class.getName());


    public Appointment() {

    }
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

    public String carMM;

    public String getCarMM() {
        return carMM;
    }

    public static void setCarMM(String carMM) {

    }

    public static void scheduleAppointment() {
        setChooseSchedule(true);
        Scanner scanner = new Scanner(System.in);
        logger.info("what is your car model ?");
        String carmodel = scanner.nextLine();
        logger.info("what is your car date ?");
        String cardate = scanner.nextLine();

        logger.info("Choose the installer you want ");
        logger.info("Available Installers:");
        listInstallers();

        logger.info("Enter the # of the installer you want to schedule an appointment with: ");
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
            logger.info("Enter the appointment date: ");
            String appointmentDate = scanner.nextLine();
            Appointment appointment = new Appointment(appointmentIdCounter, getLoggedInCustomer().getUsername(), appointmentDate,carmodel,cardate);
            selectedInstaller.getAppointments().add(appointment);
            appointmentIdCounter++;
            logger.info("Appointment scheduled successfully!");
        } else {
            logger.info("Installer not found with the given ID.");
        }

    }

    public static void listAppointments() {
        setListappointment(true);
        Installer installer = getLoggedInInstaller();
        if (installer != null) {
            logger.info("Appointments for " + installer.getUsername() + ":");
            List<Appointment> appointments = installer.getAppointments();
            for (Appointment appointment : appointments) {

                logger.info("Appointment ID: " + appointment.getAppointmentId() + "\n" +"Customer Name: " + appointment.getCustomerName() +
                        "\n"+"Appointment Date: " + appointment.getAppointmentDate()+"\n"+"Customer Car Date: " + appointment.getCustomerCarDate() +
                        "\n"+"Customer Car Model: " + appointment.getCustomerCarModel());
                logger.info("Products wanted: " );

                listOrders();
                logger.info("----------");
            }
        } else {
            logger.info("You need to log in as an installer to view appointments.");
        }
    }

}
