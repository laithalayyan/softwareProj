package najah.edu.acceptance;

import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import roles.Category;
import io.cucumber.java.en.*;
import roles.Appointment;
import roles.User;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.deletecat;
import static org.example.Main.manageCat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static roles.Appointment.*;
import static roles.Category.*;
import static roles.Product.productsearch;

public class AdminManageCategories {

    Category category;
    Category category2;
    private String categoryName;
    private String categoryName2;
    private String categoryName3;
    private String categoryName4;
    private String productName;
    List <Category> categoryList = new ArrayList<Category>();


    public static Category categoryyy;

    //categoryyy=new Category("Interior");
        //categoryList.add(categoryyy);
    //categoryyy=new Category("Exterior");
        //categoryList.add(categoryyy);

    @Given("they choose Add Category")
    public void theyChooseAddCategory() {
        category.setAddcat(true);
        assertTrue(isAddcat());
        //manageCat(1);

    }
    @When("Category name iss {string}")
    public void categoryNameIs(String string) {
        this.categoryName=string;
    }
    @When("Category2 name is {string}")
    public void category2NameIs(String string) {
        this.categoryName2=string;
    }
    @Then("the category should be added successfully")
    public void theCategoryShouldBeAddedSuccessfully() {
        //category=new Category(categoryName);

        //addcatTEG(categoryName);
        category=new Category(categoryName);
        category2=new Category(categoryName2);
        categoryList.add(category);
        categoryList.add(category2);

           // category.addcat(categoryName);
          //  category.addcat(categoryName2);

        assertTrue(addcatTest(categoryName));
        assertTrue(addcatTest(categoryName2));
       // assertFalse(addcatTest("lala"));

        //addnoti();
        //listCategoriesTest();

    }


    @Given("they choose Delete Category")
    public void theyChooseDeleteCategory() {
        category.setDeletecat(true);
        assertTrue(isDeletecat());
    }
    @When("Category name is {string}")
    public void categoryNameIss(String string) {
        this.categoryName=string;
    }
    @Then("the category should be removed successfully")
    public void theCategoryShouldBeRemovedSuccessfully() {
        categoryList.remove(category);
        //deletecat(categoryName);
        assertTrue(deletecatTest(categoryName));

    }


    @Given("they choose List Categories")
    public void theyChooseListCategories() {
        category.setListcat(true);
        assertTrue(isListcat());
    }
    @Then("they should see a list of available categories")
    public void theyShouldSeeAListOfAvailableCategories() {
        for(Category category:categoryList){
            System.out.println( category.getName()  );
        }
        listCategoriesTest();
    }


    @When("Category namee is {string}")
    public void categoryNameeIs(String arg0) {
        this.categoryName3=arg0;

    }

    @Then("the category should not be added")
    public void theCategoryShouldNotBeAdded() {
        assertFalse(addcatTest(categoryName3));
    }


    @When("Categoryy namee is {string}")
    public void categoryyNameeIs(String arg0) {
        this.categoryName4=arg0;
    }

    @Then("the category should not be deleted")
    public void theCategoryShouldNotBeDeleted() {
        assertFalse(deletecatTest(categoryName));
    }




    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        Assertions.assertTrue((new Category("Name")).isSearchproduct());
    }

    @Test
    void testConstructor2() {
        // Arrange and Act
        Category actualCategory = new Category("Name");
        actualCategory.setSearchproduct(true);

        // Assert
        assertEquals("Name", actualCategory.getName());
    }

    @Test
    void testAddcatTEG() {
        Category.addcatTEG("Name");
    }
}
