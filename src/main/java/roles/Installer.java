package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.example.Main.*;
import static roles.User.*;

public class Installer {
    public static boolean regInstallerr;
    public static boolean listInstaller;
    public static boolean isRegInstaller() {
        return regInstallerr;
    }

    public static void setRegInstaller(boolean regInstaller) {
        Installer.regInstallerr = regInstaller;
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
    public static final String INSTALLERSUCCESS = "Installer registration successful!";

    public String getDate() {
        return date;
    }

    private static List<Appointment> appointments;

    public static void setAppointments(List<Appointment> appointments) {
        //appointments = appointmentsS;
    }
    public static void addAppintments(Appointment appointment){
        appointments.add(appointment);
    }

    private static Logger logger = Logger.getLogger(Installer.class.getName());

    public Installer(int id ,String username, String email, String password,String userType,String date) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
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

    public static List<Appointment> getAppointments(Installer installer) {
        return installer.appointments;
    }





    public static void reginstaller(int id,String username , String email,String password ,String type,String date){
        installersDatabase.add(new Installer(id,username, email, password,type,date));
        logger.info(INSTALLERSUCCESS);
    }
    public static boolean reginstallerTest(int id,String username , String email,String password ,String type,String date){
            for(Installer installer:installersDatabase){
                if(installer.getEmail().equals(email)&&installer.getUsername().equals(username)){
                    logger.info("Installer already registered!");
                    return false;
                }
            }
        installersDatabase.add(new Installer(id,username, email, password,type,date));
        logger.info(INSTALLERSUCCESS);
        return true;
    }
    public static void reginstallerav(String date,String installer){
        availableDates.add(new AvailableDates(date,installer));
    }

    public static void listInstallers() {
        logger.info("Available Date For Installers:\n");
        for(Installer installer:installersDatabase){
            logger.info(installer.getId()+" - "+"Installer Name:"+installer.getUsername()+" - "+"Available Date:"+installer.getDate());
        }
    }



}
