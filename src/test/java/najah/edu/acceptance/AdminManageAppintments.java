package najah.edu.acceptance;
import io.cucumber.java.en.*;
import roles.Appointment;
import roles.AvailableDates;
import roles.Installer;
import roles.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static roles.Appointment.*;
import static najah.edu.acceptance.InstallerManagement.*;
import static roles.Installer.*;

public class AdminManageAppintments {
    private String CarModel;
    private String CarDate;
    private String installerNumber;
    private String appointmentDate;
    Appointment appointment;
    public static List<Appointment> appointmentList=new ArrayList<>();

    private static Logger logger = Logger.getLogger(AdminManageAppintments.class.getName());



    @Given("admin choose Schedule Appointment")
    public void adminChooseScheduleAppointment() {
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
        appointment=new Appointment(1,"laith",appointmentDate,CarModel,CarDate);
        appointmentList.add(appointment);
        logger.info("Appointment scheduled successfullyy!");
    }



    @Given("admin choose List Appointments")
    public void adminChooseListAppointments() {
        appointment.setListappointment(true);
        assertTrue(appointment.isListappointment());
    }
    @Then("they should see a list of scheduled appointments")
    public void theyShouldSeeAListOfScheduledAppointments() {
        for(Appointment appointment:appointmentList){
            logger.info("Appointment ID: " + appointment.getAppointmentId() + "\n" +"Customer Name: " + appointment.getCustomerName() +
                    "\n"+"Appointment Date: " + appointment.getAppointmentDate()+"\n"+"Customer Car Date: " + appointment.getCustomerCarDate() +
                    "\n"+"Customer Car Model: " + appointment.getCustomerCarModel());
        }
    }


}