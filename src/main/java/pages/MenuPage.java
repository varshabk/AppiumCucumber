package pages;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;

public class MenuPage extends BaseTest {
    public MenuPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "open menu")
    WebElement settingsPage;
    public SettingsPage settingsButton() {
        TestUtils.log().info("click on settings button");
        click(settingsPage);
        return new SettingsPage();
    }
}
