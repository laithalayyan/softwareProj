package roles;

import org.example.AdminDashboard;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.AdminDashboard.*;
import static roles.User.*;

public class Installer {
    public static boolean regInstaller;
    public static boolean listInstaller;
    public static boolean isRegInstaller() {
        return regInstaller;
    }

    public static void setRegInstaller(boolean regInstaller) {
        Installer.regInstaller = regInstaller;
    }

    public static boolean isListInstaller() {
        return listInstaller;
    }

    public static void setListInstaller(boolean listInstaller) {
        Installer.listInstaller = listInstaller;
    }

    private int id;
    private String username;
    private String email;
    private String password;
    private String userType;

    private String date;

    public String getDate() {
        return date;
    }

    private static List<Appointment> appointments;

    public static void setAppointments(List<Appointment> appointments) {
        //this.appointments = appointments;
    }
    public static void addAppintments(Appointment appointment){
        appointments.add(appointment);
    }


    private static Logger logger = Logger.getLogger(Installer.class.getName());

    public Installer(){}
    public Installer(int id ,String username, String email, String password,String userType,String date) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = "installer";
        this.date=date;
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
    public List<AvailableDates> getAvailableDates() {
        return availableDates;
    }

    public static void manageInstallers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\nInstaller Management\n1. Register Installer\n2. List Installers" +
                    "\n3. Back\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setRegInstaller(true);
                    registerInstaller();
                    break;
                case 2:
                    setListInstaller(true);
                    listInstallers();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
    public static void date(){
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        switch (date){
            case "done":
                break;
            default:
                availableDates.add(new AvailableDates(date,loggedIngetName));
                date();
        }
    }

    private static void registerInstaller() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter installer's id: ");
        int id = scanner.nextInt();

        logger.info("Enter installer's username: ");
        String username = scanner.nextLine();

        logger.info("Enter installer's email: ");
        String email = scanner.nextLine();

        logger.info("Enter installer's password: ");
        String password = scanner.nextLine();

        logger.info("Enter the dates you are available at(Write 'Done' When finish)");
        String date = scanner.nextLine();
        switch (date){
            case "done":
                break;
            default:
                installersDatabase.add(new Installer(id,username, email, password,"installer",date));
                availableDates.add(new AvailableDates(date,loggedIngetName));
                date();
        }

        //installersDatabase.add(new Installer(id,username, email, password,"installer"));
        logger.info("Installer registration successful!");
    }
    public static void reginstaller(int id,String username , String email,String password ,String type,String date){
        installersDatabase.add(new Installer(id,username, email, password,type,date));
        logger.info("Installer registration successful!");
    }
    public static boolean reginstallerTest(int id,String username , String email,String password ,String type,String date){
            for(Installer installer:installersDatabase){
                if(installer.getEmail()==email&&installer.getUsername()==username){
                    logger.info("Installer already registered!");
                    return false;
                }
            }
        installersDatabase.add(new Installer(id,username, email, password,type,date));
        logger.info("Installer registration successful!");
        return true;
    }
    public static void reginstallerav(String date,String installer){
        availableDates.add(new AvailableDates(date,installer));
    }

    public static void listInstallers() {
        /*for(AvailableDates availableDatess:availableDates){
            //logger.info("\nAvailable Date For Installers:\n"+availableDates.indexOf(availableDatess) + "-" + "Installer Name:" + availableDatess.getInstaller() + "  Date Available:" + availableDatess.getDate() );
            //logger.info(inst);
        }*/
        logger.info("Available Date For Installers:\n");
        for(Installer installer:installersDatabase){
            logger.info(installer.getId()+" - "+"Installer Name:"+installer.getUsername()+" - "+"Available Date:"+installer.getDate());
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
