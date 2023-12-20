package najah.edu.acceptance;
import io.cucumber.java.en.*;
import roles.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static roles.Installer.*;
import static roles.Order.*;

public class OrdersManagement {
    Order order;
    Category category;
    private String name;
    public static List<Order> orderList=new ArrayList<>();
    public static List<Category> categoryList=new ArrayList<>();



    @Given("they choose Place Order")
    public void theyChoosePlaceOrder() {
        order.setPlaceOrder(true);
        assertTrue(isPlaceOrder());
    }
    @When("product name is {string}")
    public void productNameIs(String string) {
        this.name=string;
    }
    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {

    }

    @Given("they choose List Orders")
    public void theyChooseListOrders() {
        order.setListOrder(true);
        assertTrue(isListOrder());
    }
    @Then("they should see a list of placed orders")
    public void theyShouldSeeAListOfPlacedOrders() {
    }

    @Then("they should see a list of available product categories")
    public void theyShouldSeeAListOfAvailableProductCategories() {
        order.setListCategories(true);
        assertTrue(isListCategories());
    }


}
