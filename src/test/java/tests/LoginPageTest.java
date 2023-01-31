package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginPageTest extends BaseTest {
    LoginPage lp;
    ProductsPage productsPage;
    @BeforeTest
    public void initializePage() {
        lp = new LoginPage();
    }
    @Test(priority = 2)
    public void validLoginTest() {
        lp.clickMenu();
        lp.enterUsername("bob@example.com");
        lp.enterPassword("10203040");
        productsPage= lp.loginButton();
       String text= productsPage.getPageAttribute();
        Assert.assertEquals(text,"Products");

    }
    @Test(priority = 1)
    public void invalidLoginTest() {
        lp.clickMenu();
        lp.enterUsername("alice");
        lp.enterPassword("samp");
        lp.loginButton();
    }
}
