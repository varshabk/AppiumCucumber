package stepdefinition;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.ReviewOrderPage;
import pages.SettingsPage;

public class CheckoutStepDefinition {
	LoginPage loginpage;
	ProductsPage productsPage;
	ProductDetailsPage prodDetailsPage;
	CartPage cartPage;
	SettingsPage settingsPage;
	CheckoutPage checkoutPage;
	ReviewOrderPage reviewPage;
	PaymentPage paymentPage;
	//CartPage cartPage;
	public CheckoutStepDefinition() {
		settingsPage = new SettingsPage();
		productsPage = new ProductsPage();
		prodDetailsPage= new ProductDetailsPage();
		checkoutPage = new CheckoutPage();
		cartPage = new CartPage();
		reviewPage = new ReviewOrderPage();
		paymentPage = new PaymentPage();
	}
	
	@Given("user is on products page")
	public void user_is_on_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	@Given("User clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkoutPage =cartPage.clickCheckoutButton();
		
	//	checkoutPage.clickPaymentButton();
	}
	@Given("user enters the following data")
	public void user_enters_the_following_data(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
List<List<String>> el=dataTable.asLists();
checkoutPage.enterFullName(el.get(1).get(0));
checkoutPage.enterAddressLine(el.get(1).get(1));
checkoutPage.enterCity(el.get(1).get(2));
checkoutPage.enterState(el.get(1).get(3));
checkoutPage.enterZipcode(el.get(1).get(4));
checkoutPage.enterCountry(el.get(1).get(5));
//paymentPage= checkoutPage.clickPaymentButton();
System.out.println("value is" +el.get(1).get(1));
	    
	}
	
	
	@Given("user clicks on payment page")
	public void user_clicks_on_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
		paymentPage=checkoutPage.clickPaymentButton();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Given("User is on payment page")
	public void user_is_on_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	@Given("user enters details as below")
	public void user_enters_details_as_below(io.cucumber.datatable.DataTable dataTable) {
	   List<List<String>> datavalues= dataTable.asLists();
	   paymentPage.enterFullName(datavalues.get(1).get(0));
	   paymentPage.enterCardNumber(datavalues.get(1).get(1));
	   paymentPage.enterExpiry(datavalues.get(1).get(2));
	   paymentPage.entersecurityCode(datavalues.get(1).get(3));
	  // datavalues.get(1).get(0);
	   
	}
	@Given("user clicks on review order button")
	public void user_clicks_on_review_order_button() {
	    // Write code here that turns the phrase above into concrete actions
		reviewPage =paymentPage.clickreviewOrder();
	}
	
	@Then("he should displayed with review order page")
	public void he_should_displayed_with_review_order_page() {
	    // Write code here that turns the phrase above into concrete actions
		String prodlabel =reviewPage.getProductlabel();
	}

}
