package najah.edu.acceptance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Main;
import roles.Customer;

import static org.junit.Assert.assertEquals;
import static roles.Customer.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

public class CustomerSteps {

    private Customer customer;
    private String registrationResult;
    private String customerListResult;
    private String loggedInCustomerNameResult;
    private String custName;
    private String custEmail;
    private String custPass;

    @Given("I am managing customers")
    public void setUpCustomerManagement() {
        customer = new Customer();
        setRegCustomer(false);
        setListCustomer(false);
    }

    @When("I choose to register a new customer")
    public void registerNewCustomer(List<CustomerDetails> customerDetails) {
        setRegCustomer(true);

    }
    @And("customerrrr username is {string}")
    public void customerrrrUsernameIs(String arg0) {
        this.custName=arg0;
    }

    @And("customerrrr password is {string}")
    public void customerrrrPasswordIs(String arg0) {
        this.custPass=arg0;
    }

    @And("customerrrr email is {string}")
    public void customerrrrEmailIs(String arg0) {
        this.custEmail=arg0;
    }

    @Then("the system should display the result")
    public void theSystemShouldDisplayTheResult() {
        regCustTest(custName, custEmail, custPass, "customer");
        //registerCustomer();

    }

    @When("I choose to list customers")
    public void listCustomers() {
        customerListResult = customer.listCustomers();
    }

    @When("I check the logged-in customer's name")
    public void getLoggedInCustomerName() {
        loggedInCustomerNameResult = Main.getLoggedInCustomerName();
    }

    @Then("the system should display {string}")
    public void verifyResult(String expectedResult) {
        assertEquals(expectedResult, registrationResult);
    }

    @Then("the system should display the list of customers:")
    public void verifyCustomerList(List<CustomerDetails> expectedCustomers) {
        for (CustomerDetails expectedCustomer : expectedCustomers) {
            String expectedUsername = expectedCustomer.getUsername();
            String expectedEmail = expectedCustomer.getEmail();
            String expectedEntry = "Username: " + expectedUsername + ", Email: " + expectedEmail;
            assertEquals(true, customerListResult.contains(expectedEntry));
        }
    }

    @Then("the system should display the customer's name {string}")
    public void verifyLoggedInCustomerName(String expectedCustomerName) {
        assertEquals(expectedCustomerName, loggedInCustomerNameResult);
    }




    // Inner class to represent customer details in the Gherkin table
    public static class CustomerDetails {
        private String username;
        private String email;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
