package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends BaseTest{
	public PaymentPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Full Name* input field")
    WebElement fullName;
    @AndroidFindBy(accessibility = "Card Number* input field")
    WebElement cardNumberField;
    @AndroidFindBy(accessibility = "Expiration Date* input field")
    WebElement expiryField;
    @AndroidFindBy(accessibility = "Security Code* input field")
    WebElement securityCode;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Review Order button\"]/android.widget.TextView")
    WebElement reviewOrder;
    public void enterFullName(String name) {
        enterText(fullName, name);
    }
    public void enterCardNumber(String cardNum) {
        enterText(cardNumberField, cardNum);
    }
    public void enterExpiry(String dateValue) {
        enterText(expiryField, dateValue);
    }
 public void entersecurityCode(String code) {
        enterText(securityCode, code);
 }

 public ReviewOrderPage clickreviewOrder() {
        click(reviewOrder);
        return new ReviewOrderPage();
 }

}
