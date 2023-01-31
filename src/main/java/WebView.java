import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;

public class WebView {
    public static void main(String[] args) {
        try {
            AppiumDriver driver = AppiumSetup.initializeDriver();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            Thread.sleep(2000);
            swipeGesture(driver);
            Thread.sleep(2000);
            driver.findElement(AppiumBy.accessibilityId("WebView2")).click();

            Thread.sleep(1500);
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void longClick(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

    }

    public static void swipeGesture(AppiumDriver driver) {

        WebElement el = driver.findElement(AppiumBy.accessibilityId("WebView2"));

            driver.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) el).getId()),
                    "direction", "up",
                    "percent", 0.75);



    }
}

