package najah.edu.acceptance;

import io.cucumber.java.en.*;
import roles.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static roles.Customer.*;

public class CustomersManagement {
    Customer customer;
    Customer customer2;
    private String customerName;
    private String customerEmail;
    private String customerPass;
    private String customer2Name;
    private String customer2Email;
    private String customer2Pass;
    public static List<Customer> customerList=new ArrayList<>();

    @Given("they choose Register Customer")
    public void theyChooseRegisterCustomer() {
        customer.setRegCustomer(true);
        assertTrue(isRegCustomer());
    }
    @When("customer username is {string}")
    public void customerUsernameIs(String string) {
        this.customerName=string;
    }
    @When("customer email is {string}")
    public void customerEmailIs(String string) {
        this.customerEmail=string;
    }
    @When("customer password is {string}")
    public void customerPasswordIs(String string) {
        this.customerPass=string;
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


}
