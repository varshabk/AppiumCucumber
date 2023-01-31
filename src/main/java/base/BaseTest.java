package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.TestUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static io.appium.java_client.pagefactory.AndroidFindBy.*;

public class BaseTest {
    public static AppiumDriver driver;
    protected static Properties prop;
    AppiumDriverLocalService service;
    static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public static String port = "4723";
    public static String ipAddress ="127.0.0.1";


   
    TestUtils utils = new TestUtils();

    public BaseTest(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void startRecord(ITestResult result) {
        ((CanRecordScreen) driver).startRecordingScreen();

    }

    public void initDriver() {
        if (driver == null) {
            TestUtils.log().info("SERVICE MESSAGE: Init driver");
            service = startAppiumServer(ipAddress, Integer.parseInt(port));
            try {
                initEnvironment(service);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void stopScreenRecord() {
        String media = ((CanRecordScreen) driver).stopRecordingScreen();
        String videoPath = "videos";
        File videoDir = new File(videoPath);
        if (!videoDir.exists()) {
            videoDir.mkdirs();
        }
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(videoDir + "/recordescreen.mp4");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fout.write(Base64.getDecoder().decode(media));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


  /*  @BeforeTest
    public AppiumDriver initializeDriver() throws IOException {
        prop = new Properties();
        log.info("setting up the driver");
        FileInputStream fis = new FileInputStream("D:\\AppiumProject\\AppiumProject\\src\\main\\resources\\config.properties");
        prop.load(fis);
        log.info("loading the property file");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        log.info("getting the desired capabilities");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_33");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("avd", "Pixel_6_API_33");
        capabilities.setCapability("avdLaunchTimeout", "1800000");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String path = prop.getProperty("androidappLocation");
        capabilities.setCapability(MobileCapabilityType.APP, path);
            capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
            capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, capabilities);
        // ((AndroidDriver)driver).startActivity(com.saucelabs.mydemoapp.rn,com.saucelabs.mydemoapp.rn.MainActivity);
        return driver;
    }*/

    public void waitforVisibility(WebElement e) {
        //WebDriverWait w = new WebDriverWait(driver, Duration.of(second, 15));
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(15));
        w.until(ExpectedConditions.visibilityOf(e));


    }

    public void enterText(WebElement e, String text) {
        waitforVisibility(e);
        e.sendKeys(text);
    }

    public String getAttribute(WebElement e, String value) {
        //  waitforVisibility(e);
        String attr = e.getAttribute(value);
        return attr;
    }

    public void click(WebElement e) {
        waitforVisibility(e);
        e.click();
    }

    public String getText(WebElement e) {
        waitforVisibility(e);
        return e.getText();
    }

    public void waitWebDriver() {
       WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public WebElement scrollElement(String word) {

        WebElement element = ((AndroidDriver) driver).findElement(AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"part_text\"))"));

        return element;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public String getDateTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        return df.format(date);
    }

    protected void initEnvironment(AppiumDriverLocalService service) throws IOException {

     //   if (isEmulator) {
            //method to start android emulator
      //      startAppiumEmulator();
            //provide your emulator name here
            //Pixel_6_API_Tiramisu
            prop = new Properties();
            log.info("setting up the driver");
            FileInputStream fis = new FileInputStream("D:\\AppiumProject\\AppiumProject\\src\\main\\resources\\config.properties");
            prop.load(fis);
            log.info("loading the property file");
            DesiredCapabilities caps = new DesiredCapabilities();
            log.info("getting the desired capabilities");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_33");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability("avd", "Pixel_6_API_33");
            caps.setCapability("avdLaunchTimeout", "1800000");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String path = prop.getProperty("androidappLocation");
            caps.setCapability(MobileCapabilityType.APP, path);
            caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
            caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        driver = new AndroidDriver(service.getUrl(), caps);
            //  URL url = new URL("http://127.0.0.1:4723");
          //  driver = new AndroidDriver(url, caps);
            // ((AndroidDriver)driver).startActivity(com.saucelabs.mydemoapp.rn,com.saucelabs.mydemoapp.rn.MainActivity);
        }

    public AppiumDriverLocalService startAppiumServer (String ipAddress,int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(
                        "C://Users//Nimesh//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress).usingPort(port).withArgument(() -> "--base-path", "/wd/hub").build();
        if (!checkIfServerIsRunnning(port)) {
            service.start();
        }
        return service;
    }
    private boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
