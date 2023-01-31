package pages;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
   public LoginPage() {
	 PageFactory.initElements(new AppiumFieldDecorator(driver), this);  
   }

    @AndroidFindBy(accessibility = "open menu")
    public WebElement menuitem;
    @AndroidFindBy(accessibility = "menu item log in")
    public WebElement loginMenu;
    @AndroidFindBy(accessibility = "Username input field")
    public WebElement username;
    @AndroidFindBy(accessibility = "Password input field")
    public WebElement password;
    @AndroidFindBy(accessibility = "Login button")
    public WebElement loginButton;


    public void clickMenu() {
        //enterText(h);
        menuitem.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(loginMenu);
    }


    public void enterUsername(String user) {
        username.clear();
        enterText(username, user);

    }

    public void enterPassword(String pwd) {
        password.clear();
        enterText(password, pwd);

    }

    public ProductsPage loginButton() {
        click(loginButton);
        return new ProductsPage();

    }
    public ProductsPage login(String username, String password) {
        clickMenu();
        waitWebDriver();
        enterUsername(username);
        waitWebDriver();
        enterPassword(password);
        waitWebDriver();
       return  loginButton();
    }
}

