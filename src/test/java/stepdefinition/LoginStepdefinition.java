package stepdefinition;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestContextSetup;

public class LoginStepdefinition{
	LoginPage loginpage;
	ProductsPage productsPage;
	TestContextSetup textContext;
	
	
/*	public LoginStepdefinition() {
		loginpage = new LoginPage();
	}*/
	
	
	@Given("I enter username as {string}")
	public void i_enter_username_as(String username) {
	    // Write code here that turns the phrase above into concrete actions
		
		new LoginPage().clickMenu();
		new LoginPage().enterUsername(username);
		
	}
	@When("And password as {string}")
	public void and_password_as(String password) {
	    // Write code here that turns the phrase above into concrete actions
		new LoginPage().enterPassword(password);
	}
	@Then("I click on login button")
	public void i_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage =new LoginPage().loginButton();
	}
	
	@Given("The user enters username as {string}")
	public void the_user_enters_username_as(String username) {
	    // Write code here that turns the phrase above into concrete actions
		new LoginPage().clickMenu();
		new LoginPage().enterUsername("bob@example.com");
	}
	@Given("user enters password as {string}")
	public void user_enters_password_as(String password) {
	    // Write code here that turns the phrase above into concrete actions
		new LoginPage().enterPassword("10203040");
	}
	@Given("user clicks login")
	public void user_clicks_login() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage =new LoginPage().loginButton();
	}
	@Then("user should display with {string} as title")
	public void user_should_display_with_as_title(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String title=productsPage.getProdTitle();
		//loginpage.waitWebDriver();
		
		Assert.assertEquals(title, "Products");
	    
	}

}
