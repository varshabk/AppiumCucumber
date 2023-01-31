package pages;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;

public class SettingsPage extends BaseTest {
    public SettingsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "menu item log out")
    WebElement logoutButton;
    @AndroidFindBy(accessibility = "menu item log in")
    WebElement login;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    WebElement confirmLogout;
   @AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"store item price\"])[4]")
   WebElement pageElement;
   @AndroidFindBy(accessibility = "Go Shopping button")
   WebElement shoppingbutton;
    @AndroidFindBy(accessibility = "open menu")
    WebElement settingsPage;
    public LoginPage clickLogout() {
        TestUtils.log().info("clicking logout");
        click(logoutButton);
        click(confirmLogout);
      click(pageElement);
        TestUtils.log().info("clicking on confirm logout");
        return new LoginPage();
    }
    public LoginPage clickConfirmLogout() {
        click(confirmLogout);
        return new LoginPage();
    }
    public ProductsPage goShopping() {

        click(settingsPage);
        waitWebDriver();
        click(login);
        waitWebDriver();
        click(shoppingbutton);
        waitWebDriver();
        return new ProductsPage();
    }
    public SettingsPage clickSettings() {
    	click(settingsPage);
    	return new SettingsPage();
    }

}
