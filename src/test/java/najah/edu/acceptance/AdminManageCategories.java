package najah.edu.acceptance;

import org.junit.experimental.categories.Categories;
import roles.Category;
import io.cucumber.java.en.*;
import roles.Appointment;
import roles.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static roles.Appointment.*;
import static roles.Category.*;
import static roles.Product.productsearch;

public class AdminManageCategories {

    Category category;
    Category category2;
    private String categoryName;
    private String categoryName2;
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

        category=new Category(categoryName);
        category2=new Category(categoryName2);
        categoryList.add(category);
        categoryList.add(category2);

            category.addcat(categoryName);
            category.addcat(categoryName2);

        addnoti();
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
        //category=new Category(categoryName2);
        categoryList.remove(category);
        category.deletecat(categoryName);
        deletenoti();
        //listCategoriesTest();
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





}
