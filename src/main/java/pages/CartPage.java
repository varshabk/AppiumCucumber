package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends BaseTest {
	public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    WebElement cartIcon;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    WebElement cartHeader;
    @AndroidFindBy(accessibility = "product label")
    WebElement productLabel;
    @AndroidFindBy(accessibility = "product price")
    WebElement productPrice;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter amount\"]/android.widget.TextView")
    WebElement productQuantity;
    @AndroidFindBy(xpath="//android.widget.ScrollView[@content-desc=\"cart screen\"]/android.view.ViewGroup/android.widget.TextView")
WebElement copyRight;
    @AndroidFindBy(accessibility = "total price")
    WebElement priceTotal;
    @AndroidFindBy(accessibility = "total number")
    WebElement numberTotal;
    @AndroidFindBy(accessibility = "Proceed To Checkout button")
    WebElement checkOutButton;

    public void clickCartIcon() {
        click(cartIcon);
    }

    public String getCartHeader() {
       String cartText = getText(cartHeader);
       return cartText;
    }
    public String getProductTitle() {
        String prodTitle= getText(productLabel);
        return prodTitle;
    }
    public String getProdQuantity() {
        String quantity= getText(productQuantity);
        return quantity;
    }
    public String getPriceLabel() {
        String priceLabel=getText(productPrice);
        return priceLabel;
    }
    public String getPriceTotal() {
        String totalPrice= getText(priceTotal);
        return totalPrice;
    }
    public String getTotalQuantity() {
        String totalQuantity=getText(productQuantity);
        return totalQuantity;
    }

    public CheckoutPage clickCheckoutButton() {
        click(checkOutButton);
        return new CheckoutPage();
    }
}

