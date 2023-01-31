import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    public static AppiumDriver initializeDriver() throws MalformedURLException{
        AppiumDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_33");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("avd", "Pixel_6_API_33");
        // capabilities.setCapability("avdLaunchTimeout","1800000");
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\ApiDemos-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, path);
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, capabilities);
        return driver;
    }

}
