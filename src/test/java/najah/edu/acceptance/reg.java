package najah.edu.acceptance;

import io.cucumber.java.en.*;
import roles.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static roles.User.isIssignedup;

public class reg {
    private String username;
    private String password;
    private String email;
    private String type;
    private String username2;
    private String password2;
    private String email2;
    private String type2;
    User user;
    User user2;


    @Given("that the user is not signed up")
    public void thatTheUserIsNotSignedUp() {
        user.setIssignedup(false);
        assertFalse(isIssignedup());
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
        this.type=string;
    }
    @Then("the user will sign up and added to userslist")
    public void theUserWillSignUpAndAddedToUserslist() {
        //user.register(username,email,password,type);
        assertTrue(user.registerTest(username,email,password,type));
    }


    @Given("that the user2 is not signed up")
    public void thatTheUser2IsNotSignedUp() {
        user.setIssignedup(false);
        assertFalse(isIssignedup());
    }
    @When("email2 is {string}")
    public void email2Is(String string) {
        this.email2=string;
    }
    @When("password2 is {string}")
    public void password2Is(String string) {
        this.password2=string;
    }
    @When("username2 is {string}")
    public void username2Is(String string) {
        this.username=string;
    }
    @When("type2 is {string}")
    public void type2Is(String string) {
        this.type2=string;
    }
    @Then("the user2 will not signed up")
    public void theUser2WillNotSignedUp() {
        assertFalse(user2.registerTest(username2,email2,password2,type2));
    }




}
