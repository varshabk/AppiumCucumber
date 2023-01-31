package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage extends BaseTest {
	
	   public CheckoutPage() {
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	@AndroidFindBy(xpath  ="//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	    WebElement checkoutHeader;
	    @AndroidFindBy(accessibility = "Full Name* input field")
	    WebElement fname;
	    @AndroidFindBy(accessibility = "Address Line 1* input field")
	    WebElement addressLine1;
	    @AndroidFindBy(accessibility = "Address Line 1* input field")
	    WebElement addressLine2;
	    @AndroidFindBy(accessibility = "City* input field")
	    WebElement city;
	    @AndroidFindBy(accessibility ="Zip Code* input field" )
	    WebElement zipcode;
	    @AndroidFindBy(accessibility = "Country* input field")
	    WebElement country;
	    @AndroidFindBy(accessibility = "State/Region input field")
	    WebElement region;
	    @AndroidFindBy(accessibility = "To Payment button")
	    WebElement paymentButton;

	    public void enterFullName(String name) {
	        enterText(fname, name);
	    }

	    public void enterAddressLine(String address1) {
	        enterText(addressLine1, address1);

	    }

	    public void enterAddressLine2(String address2) {
	        enterText(addressLine2, address2);
	    }
	    public void enterCity(String cityValue) {
	        enterText(city, cityValue);
	    }
	    public void enterZipcode(String zip) {
	        enterText(zipcode, zip);
	    }
	public void enterCountry(String countryText) {
	        enterText(country, countryText);
	}
	public void enterState(String stateValue) {
	        enterText(region, stateValue);
	}
	public PaymentPage clickPaymentButton() {
	        click(paymentButton);
	        return new PaymentPage();
	}

}
