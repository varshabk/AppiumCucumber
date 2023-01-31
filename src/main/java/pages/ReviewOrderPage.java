package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewOrderPage extends BaseTest {

	public ReviewOrderPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "product price")
    WebElement reviewPrice;
    @AndroidFindBy(accessibility = "product label")
    WebElement reviewlabel;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Place Order button\"]/android.widget.TextView")
    WebElement placeOrder;
    @AndroidFindBy(accessibility = "total number")
    WebElement totalNumber;
    @AndroidFindBy(accessibility = "total price")
    WebElement totalPrice;
    public String getReviewProductPrice() {
        String reviewPric= getText(reviewPrice);
        return reviewPric;

    }
    public String getProductlabel() {
        String reviewLabel= getText(reviewlabel);
        return reviewLabel;
    }

    public void clickplaceOrder() {
        click(placeOrder);
    }

    public String getTotalNumber() {
        String totalNum=getText(totalNumber);
        return totalNum;
    }
public String getTotalPrice() {
        String totalP=getText(totalPrice);
        return totalP;
}

}
