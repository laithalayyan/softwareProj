package najah.edu.acceptance;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Test;
import roles.Customer;
import roles.Order;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static roles.Customer.*;

public class CustomersManagement {
    Customer customer;
    Customer customer2;
    Customer customer3;
    private String customerName;
    private String customerEmail;
    private String customerPass;
    private String customer2Name;
    private String customer2Email;
    private String customer2Pass;
    private String customer3Name;
    private String customer3Email;
    private String customer3Pass;
    public static List<Customer> customerList=new ArrayList<>();


    @Given("they choose Register Customer")
    public void theyChooseRegisterCustomer() {
        customer.setRegCustomer(true);
        assertTrue(isRegCustomer());
    }
    @When("customer username is {string}")
    public void customerUsernameIs(String string) {
        this.customerName=string;
        String name=customer.getUsername();
    }
    @When("customer email is {string}")
    public void customerEmailIs(String string) {
        this.customerEmail=string;
        String ss=customer.getUserType();
        String aa=customer.getEmail();
        List<Order> orders=new ArrayList<>();
    }
    @When("customer password is {string}")
    public void customerPasswordIs(String string) {
        this.customerPass=string;
        customer.setPassword(customerPass);
        String pass=customer.getPassword();
    }
    @When("customer2 username is {string}")
    public void customer2UsernameIs(String string) {
        this.customer2Name=string;
    }
    @When("customer2 email is {string}")
    public void customer2EmailIs(String string) {
        this.customer2Email=string;
    }
    @When("customer2 password is {string}")
    public void customer2PasswordIs(String string) {
        this.customer2Pass=string;
    }
    @Then("the customers should be registered successfully")
    public void theCustomersShouldBeRegisteredSuccessfully() {
        customer=new Customer(customerName,customerEmail,customerPass,"customer");
        customer2=new Customer(customer2Name,customer2Email,customer2Pass,"customer");
        customerList.add(customer);
        customerList.add(customer2);

        //customer.regCust(customerName,customerEmail,customerPass,"customer");
        //customer.regCust(customer2Name,customer2Email,customer2Pass,"customer");
        assertTrue(regCustTest(customerName,customerEmail,customerPass,"customer"));
        assertTrue(regCustTest(customer2Name,customer2Email,customer2Pass,"customer"));

    }


    @Given("they choose List Customers")
    public void theyChooseListCustomers() {
        customer.setListCustomer(true);
        assertTrue(isListCustomer());
    }
    @Then("they should see a list of registered customers")
    public void theyShouldSeeAListOfRegisteredCustomers() {
        listCustomers();
    }


    @When("customerr username is {string}")
    public void customerrUsernameIs(String arg0) {
        this.customer3Name=arg0;
    }

    @And("customerr email is {string}")
    public void customerrEmailIs(String arg0) {
        this.customer3Email=arg0;
    }

    @And("customerr password is {string}")
    public void customerrPasswordIs(String arg0) {
        this.customer3Pass=arg0;
    }

    @Then("the customers should not be registered")
    public void theCustomersShouldNotBeRegistered() {
        customer3=new Customer(customer2Name,customer2Email,customer2Pass,"customer");
        customerList.add(customer3);
        regCustTest(customer3Name,customer3Email,customer3Pass,"customer");
    }


}
