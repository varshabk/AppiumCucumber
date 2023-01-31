package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ThankYouPage;

public class ThankStepDefinition {
	ThankYouPage thanksPage;
	public ThankStepDefinition() {
		thanksPage = new ThankYouPage();
	}
	@Given("user is on thank you page")
	public void user_is_on_thank_you_page() {
	    // Write code here that turns the phrase above into concrete actions.
		String title =thanksPage.getThankTitle();
		Assert.assertEquals(title, "Thank you for your order");
	}
	@Then("verify the description")
	public void verify_the_description() {
	    // Write code here that turns the phrase above into concrete actions
		String description =thanksPage.getThankDescription();
		Assert.assertEquals(description, "Your new swag is on its way");
	}
	@Then("verify the order status")
	public void verify_the_order_status() {
	    // Write code here that turns the phrase above into concrete actions
		String status =thanksPage.getOrderStatus();
		Assert.assertEquals(status, " Your order has been dispatched and will arrive as fast as the pony gallops!");
		
	}

}
