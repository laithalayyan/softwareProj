package najah.edu.acceptance;

import io.cucumber.java.en.*;
import org.example.AdminDashboard;
import roles.Customer;
import roles.Installer;
import roles.Product;
import roles.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static roles.User.*;

public class signin {
    User user;
    User user2;
    User user3;
    Installer installer;
    Customer customer;
    public static List<User> userList=new ArrayList<>();
    public static List<User> userList2=new ArrayList<>();
    public static List<Installer> installerList=new ArrayList<>();
    public static List<Customer> customerList=new ArrayList<>();

    private String AdminEmail;
    private String CustomerEmail;
    private String InstallerEmail;
    private String AdminPass;
    private String CustomerPass;
    private String InstallerPass;



    @Given("admin is not logged in")
    public void adminIsNotLoggedIn() {
        user.setAdminislogged(false);
        assertFalse(isAdminislogged());
    }
    @When("Admin eemail is {string}")
    public void adminEemailIs(String string) {
        this.AdminEmail=string;
    }
    @When("Admin ppassword is {string}")
    public void adminPpasswordIs(String string) {
        this.AdminPass=string;
    }
    @Then("the admin login")
    public void theAdminLogin() {
        user=new User("admin",AdminEmail,AdminPass,"admin");
        userList.add(user);
        this.userList2=User.getlist();
        assertTrue(loginadmin(AdminEmail,AdminPass,userList2));
    }



    @Given("customer is not logged in")
    public void customerIsNotLoggedIn() {
        user.setCustomerislogged(false);
        assertFalse(isCustomerislogged());
    }
    @When("Customer eemail is {string}")
    public void customerEemailIs(String string) {
        this.CustomerEmail=string;
    }
    @When("Customer ppassword is {string}")
    public void customerPpasswordIs(String string) {
        this.CustomerPass=string;
    }
    @Then("the customer login")
    public void theCustomerLogin() {
        user2=new User("customer",CustomerEmail,CustomerPass,"customer");
        userList.add(user2);
        //setUserDatabasee();
        this.userList2=User.getlist();
        assertTrue(logincustomer(CustomerEmail,CustomerPass,userList2));
    }




    @Given("installer is not logged in")
    public void installerIsNotLoggedIn() {
        user.setInstallerislogged(false);
        assertFalse(isInstallerislogged());
    }
    @When("Installer eemail is {string}")
    public void installerEemailIs(String string) {
        this.InstallerEmail=string;
    }
    @When("Installer ppassword is {string}")
    public void installerPpasswordIs(String string) {
        this.InstallerPass=string;
    }

    @Then("the installer login")
    public void theInstallerLogin() {
        user3=new User("installer",InstallerEmail,InstallerPass,"installer");
        userList.add(user3);
        //installersignin(InstallerEmail,InstallerPass);
        //assertFalse(isInstallerislogged());
        this.userList2=User.getlist();
        assertTrue(logininstaller(InstallerEmail,InstallerPass,userList2));
    }


}