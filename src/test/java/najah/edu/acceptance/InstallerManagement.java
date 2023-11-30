package najah.edu.acceptance;
import io.cucumber.java.en.*;
import roles.AvailableDates;
import roles.Customer;
import roles.Installer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static roles.Installer.*;

public class InstallerManagement {
    Installer installer;
    AvailableDates availableDate;
    private int id;
    private String username;
    private String email;
    private String pass;
    private String av;

    public static List<Installer> installerList=new ArrayList<>();
    public static List<Installer> installerListdates=new ArrayList<>();

    @Given("they choose Register Installer")
    public void theyChooseRegisterInstaller() {
        installer.setRegInstaller(true);
        assertTrue(isRegInstaller());
    }
    @When("installer id is {int}")
    public void installerIdIs(int string) {
        this.id=string;
    }
    @When("installer username is {string}")
    public void installerUsernameIs(String string) {
        this.username=string;
    }
    @When("installer email is {string}")
    public void installerEmailIs(String string) {
        this.email=string;
    }
    @When("installer password is {string}")
    public void installerPasswordIs(String string) {
        this.pass=string;
    }
    @When("installer avaialbledate is {string}")
    public void installerAvaialbledateIs(String string) {
        this.av=string;
    }
    @Then("the installer should be registered successfully")
    public void theInstallerShouldBeRegisteredSuccessfully() {
        installer=new Installer(id,username,email,pass,"installer");
        installerList.add(installer);
        //reginstaller(id,username,email,pass,"installer");
        availableDate=new AvailableDates(av,installer.getUsername());
        reginstallerav(av,installer.getUsername());
        assertTrue(reginstallerTest(id,username,email,pass,"installer"));
    }

    @Given("they choose List Installers")
    public void theyChooseListInstallers() {
        installer.setListInstaller(true);
        assertTrue(isListInstaller());
    }
    @Then("they should see a list of registered installers with their available dates")
    public void theyShouldSeeAListOfRegisteredInstallersWithTheirAvailableDates() {
        listInstallers();
    }


}
