package najah.edu.acceptance;

import io.cucumber.java.en.*;
import roles.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class signin {
    private String email;
    private String password;

    User user;
    public signin() {
        this.user =new User();
    }

    @Given("I am on the sign-in page")
    public void iAmOnTheSignInPage() {
        assertFalse(user.isAdminIsLogged());
    }
    @When("emaill is {string}")
    public void emailIss(String string) {
        this.email=string;
    }
    @When("passwordd is {string}")
    public void passwordIss(String string) {
        this.password=string;
    }
    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {

    }


    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        System.out.println("This is not admin email");
    }
}
