package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage  extends  MenuPage{
    public ProductDetailsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    WebElement detailTitle;
    @AndroidFindBy(accessibility = "Add To Cart button")
    WebElement addCart;
    public String getProductDetailTitle() {
    	waitWebDriver();
        String prodDetailTitle= getText(detailTitle);
        System.out.println(prodDetailTitle);
        return prodDetailTitle;
    }
    
    public CartPage clickAddCart() {
        click(addCart);
        return new CartPage();
    }
}
