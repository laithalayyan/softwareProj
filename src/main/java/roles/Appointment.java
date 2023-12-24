package roles;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static org.example.Main.*;
import static roles.Installer.*;


public class Appointment {
    private static boolean listappointment;
    private static boolean isChooseSchedule ;
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
    public static void addToIntallerList(Installer installer){
        installersDatabase.add(installer);
    }
    private int appointmentId;
    private String customerName;
    private String appointmentDate;


    private String carModer;
    private String carDate;
    public static final List<Appointment> appointments2=new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Appointment.class.getName());



    public Appointment( String customerName, String appointmentDate,String carModer , String carDate) {
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



    static Installer selectedInstaller = null;
    public static boolean scheduleAppointment(String carmodel,String carDate,int installerId,List<Installer> installersDatabase) {
        for(Installer installer:installersDatabase){
            if(installerId==installer.getId()){
                selectedInstaller=installer;
                setInstaller(installer);
                Appointment appointment=new Appointment(getLoggedInCustomerName(), installer.getDate(),carmodel,carDate);
                appointments2.add(appointment);
                Installer.setAppointments(appointments2);
                addAppintments(appointment);
                logger.info("Appointment scheduled successfully!");
                return true;

            }
        }
        logger.info("There is no appointment available with this number!");
        listInstallers();
        return false;

    }


    public static void setInstaller(Installer installer){
        selectedInstaller=installer;
    }
    public static Installer getinstaller(){
        return selectedInstaller;
    }
    public static void listAppointments(Installer installer11,List<Installer> installersDatabase) {
        setListappointment(true);
        for(Installer installer:installersDatabase) {
            if ((installer.getId())==(installer11.getId())) {
                logger.info("Appointments for " + installer.getUsername() + ":");
                appointmentsList(installer11);
            }
        }
    }
    public static void appointmentsList(Installer installer){
        List<Appointment> appointments = getAppointments(installer);
        for (Appointment appointment : appointments) {
            logger.info("Appointment ID: " + appointment.getAppointmentId() + "\n" + "Customer Name: " + appointment.getCustomerName() +
                    "\n" + "Appointment Date: " + appointment.getAppointmentDate() + "\n" + "Customer Car Date: " + appointment.getCustomerCarDate() +
                    "\n" + "Customer Car Model: " + appointment.getCustomerCarModel());
            logger.info("Products wanted: ");
            listOrders();
        }
    }
}
