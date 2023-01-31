import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import java.net.MalformedURLException;

public class AndroidBase {
   static Logger logger= LogManager.getLogger(AndroidBase.class);
    public static void main(String[] args) {

        try {
            logger.warn("initilaizing the driver");
            AppiumDriver driver=AppiumSetup.initializeDriver();
            Thread.sleep(2000);
            logger.debug("selecting the elements");
           driver.findElement(AppiumBy.accessibilityId("Views")).click();
            driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
         //   driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        //    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        //    longClick(driver);
            logger.info("performing scroll");
          //  scrollGesture(driver);
          // System.out.println(driver.findElement(AppiumBy.accessibilityId("Preference")).getText());
            Thread.sleep(1500);
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public static void longClick(AppiumDriver driver) {
        WebElement element= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));

    }

    public static void scrollGesture(AppiumDriver driver)
    {
        boolean canScroll=true;
        WebElement el = driver.findElement(AppiumBy.xpath("//android.widget.Gallery/android.widget.ImageView[1]"));
        while(canScroll) {
            driver.executeScript("mobile:scrollGesture", ImmutableMap.of("elementId",((RemoteWebElement)el).getId()),
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "left",
                    "percent", 0.75);






        }

    }}
