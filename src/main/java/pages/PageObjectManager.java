package pages;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;

public class PageObjectManager extends BaseTest {
	public PageObjectManager() {
		//super(driver);
		// TODO Auto-generated constructor stub
	}

	//AppiumDriver driver;
	public LoginPage getLoginPage() {
		return new LoginPage();
	}
	
	

}
