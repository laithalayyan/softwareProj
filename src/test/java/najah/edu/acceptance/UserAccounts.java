package najah.edu.acceptance;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import static roles.User.*;

public class UserAccounts {
    @Given("they choose list users")
    public void they_choose_list_users() {
        setListAcc(true);
        assertTrue(isListAcc());
    }
    @Then("the users list will appear")
    public void the_users_list_will_appear() {
        listUserAccounts();
    }

    @And("they choose list userss")
    public void theyChooseListUserss() {
    }
}
