package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.SettingsPage;

public class ProductsTest extends BaseTest {
    LoginPage lp;
    ProductsPage productsPage;
    SettingsPage settingsPage;
    ProductDetailsPage productDetailsPage;
    @BeforeClass
    public void initializePage() {
        lp = new LoginPage();
        productsPage = new ProductsPage();
        settingsPage = new SettingsPage();
    }
    @Test(priority = 1)
    public void validateProductsPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsPage = settingsPage.goShopping();
      // lp= settingsPage.clickConfirmLogout();
     //   productsPage=lp.login("bob@example.com","10203040");
        String displayedTitle= productsPage.getProdTitle();
        waitWebDriver();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(displayedTitle, "Products");
        String displayedPrice = productsPage.getProductPrice();
        Assert.assertEquals(displayedPrice, "$29.99");
        settingsPage = productsPage.settingsButton();
        lp = settingsPage.clickLogout();
        System.out.println("end of case");

    }
    @Test(priority = 2)
    public void validateProductsDetailsPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsPage = settingsPage.goShopping();
      //  productsPage=lp.login("bob@example.com","10203040");
//settingsPage.clickLogout();

        productDetailsPage = productsPage.clickProductTitle();
       try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String productDetail =productDetailsPage.getProductDetailTitle();
        Assert.assertEquals(productDetail,"Sauce Labs Backpack");
        settingsPage = productsPage.settingsButton();
     //   lp = settingsPage.clickLogout();

    }

}
