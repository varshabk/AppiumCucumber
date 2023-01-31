package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.SettingsPage;

public class ProductDetailsStepdef {
	LoginPage loginpage;
	ProductsPage productsPage;
	ProductDetailsPage prodDetailsPage;
	CartPage cartPage;
	SettingsPage settingsPage;
	public ProductDetailsStepdef() {
		loginpage = new LoginPage();
		cartPage = new CartPage();
		prodDetailsPage = new ProductDetailsPage();
		settingsPage = new SettingsPage();
		
	}
	
/*	@Given("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		productsPage=loginpage.login("bob@example.com", "10203040");
	}
	
	@Given("user verifies product title")
	public void user_verifies_product_title() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage.getProdTitle();
	}*/
	@Given("User clicks on product name")
	public void user_clicks_on_product_name() {
	    // Write code here that turns the phrase above into concrete actions
		 productsPage = settingsPage.goShopping();
		prodDetailsPage = productsPage.clickProductTitle();
	}
	@Given("user verfies product details")
	public void user_verfies_product_details() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prodDetailsPage.getProductDetailTitle();
	}
	@When("user clicks add to cart")
	public void user_clicks_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		prodDetailsPage.clickAddCart();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("user verifies cartpage details")
	public void user_verifies_cartpage_details() {
	    // Write code here that turns the phrase above into concrete actions
	cartPage.clickCartIcon();
		
	}

}
