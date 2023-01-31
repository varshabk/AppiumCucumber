package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductsStepDefinition {
	LoginPage loginpage;
	ProductsPage productsPage;
	ProductDetailsPage prodDetailsPage;
	public ProductsStepDefinition() {
		productsPage = new ProductsPage();
		prodDetailsPage= new ProductDetailsPage();
	}
	
	@Given("User is on products page")
	public void user_is_on_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage.getProdTitle();
	}
	@Given("Verify the productname")
	public void verify_the_productname() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage.getProdTitle();
	}
	@Given("Verify the productprice")
	public void verify_the_productprice() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage.getProductPrice();
	}
	@When("user clicks on productname")
	public void user_clicks_on_productname() {
	    // Write code here that turns the phrase above into concrete actions
		prodDetailsPage = productsPage.clickProductTitle();
	}
	@Then("user should be on productdetails page")
	public void user_should_be_on_productdetails_page() {
	    // Write code here that turns the phrase above into concrete actions
	//	productsPage.waitWebDriver();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String prodDetailTitle=prodDetailsPage.getProductDetailTitle();
		
		Assert.assertEquals(prodDetailTitle, "Sauce Labs Backpack");
		
	}
	
}
