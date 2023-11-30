package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import static org.example.AdminDashboard.*;
import static roles.Customer.getLoggedInCustomer;
import static roles.Customer.getLoggedInCustomerName;
import static roles.Installer.*;
import static roles.Order.listOrders;
import static roles.User.loggedIngetEmail;


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
    public static List<Appointment> appointments2=new ArrayList<>();
    private static Logger logger = Logger.getLogger(Appointment.class.getName());


    public Appointment() {

    }
    public Appointment( String customerName, String appointmentDate,String carModer , String carDate) {
        //this.appointmentId = appointmentId;
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

            logger.info("Appointment Management\n1. List Appointments\n2. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAppointments();
                    break;
                case 2:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

    }


    static Installer selectedInstaller = null;

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

        logger.info("Enter the # of the installer date you want to schedule an appointment with: ");
        int installerId = scanner.nextInt();
        scanner.nextLine();

        //Installer selectedInstaller = null;
        AvailableDates av = null;
        for(Installer installer:installersDatabase){
            if(installerId==installer.getId()){
                selectedInstaller=installer;
                setInstaller(installer);

                Appointment appointment=new Appointment(getLoggedInCustomerName(), installer.getDate(),carmodel,cardate);
                appointments2.add(appointment);
                Installer.setAppointments(appointments2);
                addAppintments(appointment);
                //Appointment.add();
                logger.info("Appointment scheduled successfully!");
                break;
            }
        }
        logger.info("There is no appointment available with this number!");
        listInstallers();
        /*for(AvailableDates availableDatess:availableDates){
            if(installerId==(availableDates.indexOf(availableDatess))){
                for (Installer installer : installersDatabase) {
                    if (installerId == installer.getId()) {
                        selectedInstaller = installer;
                        break;
                    }
                }
                av =availableDatess;
                break;
            }
        }*/

        /*if(av!=null){
            logger.info("Enter the appointment date: ");
            String appointmentDate = scanner.nextLine();
            Appointment appointment = new Appointment(appointmentIdCounter, getLoggedInCustomer().getUsername(), appointmentDate,carmodel,cardate);
            selectedInstaller.getAppointments().add(appointment);
            appointmentIdCounter++;
            logger.info("Appointment scheduled successfully!");
        } else {
            logger.info("Installer not found with the given date.");
        }
        }*/

        /*if (selectedInstaller != null) {
            logger.info("Enter the appointment date: ");
            String appointmentDate = scanner.nextLine();
            Appointment appointment = new Appointment(appointmentIdCounter, getLoggedInCustomer().getUsername(), appointmentDate,carmodel,cardate);
            selectedInstaller.getAppointments().add(appointment);
            appointmentIdCounter++;
            logger.info("Appointment scheduled successfully!");
        } else {
            logger.info("Installer not found with the given ID.");
        }*/

    }


    public static void setInstaller(Installer installer){
        selectedInstaller=installer;
    }
    public static Installer getinstaller(){
        return selectedInstaller;
    }
    //public static List<Appointment> appointmentss=new ArrayList<>();
    public static void listAppointments() {
        setListappointment(true);
        Installer installer1 = getLoggedInInstaller();
        for(Installer installer:installersDatabase) {
            if (installer.equals(installer1)) {
                logger.info("Appointments for " + installer.getUsername() + ":");
                //appointments.add(installer.getAppointments());
                List<Appointment> appointments = installer.getAppointments();
                for (Appointment appointment : appointments) {

                    logger.info("Appointment ID: " + appointment.getAppointmentId() + "\n" + "Customer Name: " + appointment.getCustomerName() +
                            "\n" + "Appointment Date: " + appointment.getAppointmentDate() + "\n" + "Customer Car Date: " + appointment.getCustomerCarDate() +
                            "\n" + "Customer Car Model: " + appointment.getCustomerCarModel());
                    logger.info("Products wanted: ");
                    listOrders();
                    return;
                }
            }return;
        }
        logger.info("There is no apponintments for this installer");
    }

}
