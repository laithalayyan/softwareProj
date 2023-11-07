package najah.edu.acceptance;

import io.cucumber.java.en.*;
import roles.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class reg {
    private String username;
    private String email;
    private String password;
    private String Type;
    User user;
    public reg() {
        this.user =new User();
    }


    @Given("that the user is not signed up")
    public void thatTheUserIsNotSignedUp() {
        assertFalse(user.isIssignedup());
    }
    @When("email is {string}")
    public void emailIs(String string) {
        this.email=string;
    }
    @When("password is {string}")
    public void passwordIs(String string) {
        this.password=string;
    }
    @When("username is {string}")
    public void usernameIs(String string) {
        this.username=string;
    }
    @When("type is {string}")
    public void typeIs(String string) {
        this.Type=string;
    }
    @Then("the user will sign up and added to userslist")
    public void theUserWillSignUpAndAddedToUserslist() {
        assertFalse(user.isIssignedup());
    }

    @Then("the user will not sign up")
    public void theUserWillNotSignUp() {
        assertFalse(user.isIssignedup());
    }
    @Then("show why can't sign up")
    public void showWhyCanTSignUp() {
        System.out.println("Cannot regester");
    }

}
