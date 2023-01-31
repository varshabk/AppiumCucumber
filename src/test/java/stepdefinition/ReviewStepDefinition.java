package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ReviewOrderPage;

public class ReviewStepDefinition {
	ReviewOrderPage reviewpage;
	public ReviewStepDefinition() {
		reviewpage = new ReviewOrderPage();
		
	}

	@Given("User is on review page")
	public void user_is_on_review_page() {
	    // Write code here that turns the phrase above into concrete actions
		reviewpage.getProductlabel();
	}
	@When("user verfies the review page details")
	public void user_verfies_the_review_page_details() {
	    // Write code here that turns the phrase above into concrete actions
		reviewpage.getReviewProductPrice();
		reviewpage.getTotalPrice();
		reviewpage.getTotalNumber();
	   
	}
	@When("user clicks on place order button")
	public void user_clicks_on_place_order_button() {
	    // Write code here that turns the phrase above into concrete actions
		reviewpage.clickplaceOrder();
	}
}
