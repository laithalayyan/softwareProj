package najah.edu.acceptance;
import io.cucumber.java.en.*;
import roles.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.manageProducts;
import static org.junit.jupiter.api.Assertions.*;
import static roles.Installer.*;
import static roles.Order.*;
import static roles.Product.*;

public class ProductManagement {
    private String productName;
    private int productPrice;
    private int productAmount;
    private String productCategory;
    private String product2Name;
    private int product2Price;
    private int product2Amount;
    private String product2Category;
    private String productdelete;

    Product product;
    Product product2;

    public static List<Product> productList=new ArrayList<>();

    @Given("they choose Add Product")
    public void theyChooseAdddProduct() {
        product.setAddProduct(true);
        assertTrue(isAddProduct());
    }
    @When("productt name is {string}")
    public void producttNameIs(String string) {
        this.productName=string;
    }
    @When("product price is {int}")
    public void productPriceIs(Integer int1) {
        this.productPrice=int1;
    }
    @When("product category is {string}")
    public void productCategoryIs(String string) {
        this.productCategory=string;
    }
    @When("product amount is {int}")
    public void productAmountIs(Integer int1) {
        this.productAmount=int1;
    }
    @When("product2 name is {string}")
    public void product2NameIs(String string) {
        this.product2Name=string;
    }
    @When("product2 price is {int}")
    public void product2PriceIs(Integer int1) {
        this.product2Price=int1;
    }
    @When("product2 category is {string}")
    public void product2CategoryIs(String string) {
        this.product2Category=string;
    }
    @When("product2 amount is {int}")
    public void product2AmountIs(Integer int1) {
        this.product2Amount=int1;
    }
    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
        product=new Product(productName,productPrice,productCategory,productAmount);
        product2=new Product(product2Name,product2Price,product2Category,product2Amount);
        productList.add(product);
        productList.add(product2);
        //productadd(productName,productPrice,productCategory,productAmount);
        //productadd(product2Name,product2Price,product2Category,product2Amount);
        assertTrue(productaddTest(productName,productPrice,productCategory,productAmount));
        assertTrue(productaddTest(product2Name,product2Price,product2Category,product2Amount));
    }



    @Given("they choose Delete Product")
    public void theyChooseDeleteeProduct() {
        product.setDeleteProduct(true);
        assertTrue(isDeleteProduct());
    }
    @When("product to delete name is {string}")
    public void productToDeleteNameIs(String string) {
        this.productdelete=string;
    }
    @Then("the product should be removed successfully")
    public void theProductShouldBeRemovedSuccessfully() {
        productList.remove(productdelete);
        //productdelete(productdelete);

        assertTrue(productdeleteTest(productdelete));

    }



    @Given("they choose List Products")
    public void theyChooseListtProducts() {
        product.setListProduct(true);
        assertTrue(isListProduct());
    }
    @Then("they should see a list of available products")
    public void theyShouldSeeAListOfAvailableProducts() {
        listProducts();
    }





    @Given("they have choices :Add Product or Delete Product or List Products or Back")
    public void theyHaveChoicesAddProductOrDeleteProductOrListProductsOrBack() {

    }

    @When("they choose AddProduct")
    public void theyChooseAddProduct() {
        //int result=manageProducts();
        //assertTrue();
        int choice = manageProducts(1);
        assertEquals(choice,1);

    }

    @And("they choose DeleteProduct")
    public void theyChooseDeleteProduct() {

        int choice = manageProducts(2);
        assertEquals(choice,2);
    }

    @And("they choose ListProducts")
    public void theyChooseListProducts() {
        int choice = manageProducts(3);
        assertEquals(choice,3);
    }

    @And("they choose Back")
    public void theyChooseBack() {
        int choice = manageProducts(4);
        assertEquals(choice,2);
    }

    @Then("successfulyy done")
    public void successfulyyDone() {
    }


}
