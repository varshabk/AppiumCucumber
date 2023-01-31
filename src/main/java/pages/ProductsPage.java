package pages;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;

public class ProductsPage extends MenuPage {

    //android.view.ViewGroup[@content-desc="container header"]/android.widget.TextView
   public ProductsPage() {
       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
   }
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    WebElement productTitle;
   @AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"store item text\"])[1]")
   WebElement buttonTitle;
   @AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"store item price\"])[1]")
   WebElement productPrice;
    public String getPageAttribute() {
      return getAttribute(productTitle,"text");
    }
    public String getProdTitle() {
        String title= getText(productTitle);
        System.out.println(title);
        return title;
    }
    public String getProductPrice() {
        String price= getText(productPrice);
        System.out.println(price);
        return price;
    }
    public ProductDetailsPage clickProductTitle() {
        TestUtils.log().info("click product title");
        click(buttonTitle);
        return  new ProductDetailsPage();
    }
}
