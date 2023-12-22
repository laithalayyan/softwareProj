package najah.edu.acceptance;
import io.cucumber.java.en.*;
import roles.Appointment;
import roles.Installer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static roles.Appointment.*;
import static org.example.Main.*;

public class AdminManageAppintments {
    private String CarModel;
    private String CarDate;
    private String installerNumber;
    private String appointmentDate;
    Appointment appointment;
    Installer installer;
    Installer installer111= new Installer(1, "installerrlaith", "installer@installer.com","123","installer","12/7/2023");
    Installer installer222= new Installer(222, "installerrRRlaith", "installer@installer.com","123","installer","12/7/2023");
    public static List<Appointment> appointmentList=new ArrayList<>();
    public static List<Installer> installersDatabase = new ArrayList<>();
    Appointment appointment111=new Appointment("LAITH","12/7/2002","LL","2012");


    private static Logger logger = Logger.getLogger(AdminManageAppintments.class.getName());



    @Given("admin choose Schedule Appointment")
    public void adminChooseScheduleAppointment() {
        addToIntallerList(installer111);
        //addToIntallerList(installer222);
        appointment.setChooseSchedule(true);
        assertTrue(isChooseSchedule());
    }
    @When("car model is {string}")
    public void carModelIs(String string) {
        this.CarModel=string;
    }
    @When("car date is {string}")
    public void carDateIs(String string) {
        this.CarDate=string;
    }
    @Then("Available Installers will be shown")
    public void availableInstallersWillBeShown() {
    }
    @When("installer number is {string}")
    public void installerNumberIs(String string) {
        this.installerNumber=string;
    }
    @When("appointment date is {string}")
    public void appointmentDateIs(String string) {
        this.appointmentDate=string;
    }
    @Then("the appointment should be scheduled successfully")
    public void theAppointmentShouldBeScheduledSuccessfully() {
        appointment=new Appointment("laith",appointmentDate,CarModel,CarDate);
        appointmentList.add(appointment);
        List<Installer> installersDatabase=getInstallersDatabase();
        scheduleAppointment(CarModel,CarDate,installer111.getId(),installersDatabase);
        scheduleAppointment(CarModel,CarDate,installer222.getId(),installersDatabase);
        //logger.info("Appointment scheduled successfullyy!");

    }



    @Given("admin choose List Appointments")
    public void adminChooseListAppointments() {
        appointment.setListappointment(true);
        assertTrue(appointment.isListappointment());
    }
    @Then("they should see a list of scheduled appointments")
    public void theyShouldSeeAListOfScheduledAppointments() {
        List<Installer> installersDatabase=getInstallersDatabase();
        List<Appointment> appointments = Installer.getAppointments(installer111);
        //appointmentsList(installer111);
        listAppointments(installer111,installersDatabase);
        /*for(Appointment appointment:appointmentList){
            logger.info("Appointment ID: " + appointment.getAppointmentId() + "\n" +"Customer Name: " + appointment.getCustomerName() +
                    "\n"+"Appointment Date: " + appointment.getAppointmentDate()+"\n"+"Customer Car Date: " + appointment.getCustomerCarDate() +
                    "\n"+"Customer Car Model: " + appointment.getCustomerCarModel());
        }*/
    }


}