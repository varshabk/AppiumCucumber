package stepdefinition;

import base.BaseTest;
import base.DriverManager;
import io.appium.java_client.InteractsWithApps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  BaseTest basetest = new BaseTest();
  DriverManager manager = new DriverManager();
  //basetest.getDriver();
  
	
	@Before
	public void initialize() {
		manager.initDriver();
		
	}
	
/*	@After
	public void quit() {
		((InteractsWithApps) manager.getDriver()).terminateApp(manager.getDriver().getCapabilities().
                getCapability("appPackage").toString());
		 ((InteractsWithApps) manager.getDriver()).activateApp(manager.getDriver().getCapabilities().
                 getCapability("appPackage").toString());
	}*/
}
