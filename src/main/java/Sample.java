
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Sample {
    static AppiumDriver driver;
    @BeforeClass
    public static AppiumDriver initializeDriver() throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_33");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("avd", "Pixel_6_API_33");
        capabilities.setCapability("avdLaunchTimeout","1800000");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String path = "C:\\Users\\varsha\\Downloads\\Sauce.apk";
        capabilities.setCapability(MobileCapabilityType.APP, path);
        //  capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        //  capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, capabilities);
        return driver;
    }
    @Test
    public void firstTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("appium");
    }
}
