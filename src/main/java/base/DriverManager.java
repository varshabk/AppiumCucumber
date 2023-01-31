package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
	 public static AppiumDriver driver;
	    protected static Properties prop;
	    AppiumDriverLocalService service;

   // private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();
    public static String port = "4723";
    public static String ipAddress ="127.0.0.1";

    public AppiumDriver getDriver(){
        return driver;
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
        
        protected void initEnvironment(AppiumDriverLocalService service) throws IOException {

            //   if (isEmulator) {
                   //method to start android emulator
             //      startAppiumEmulator();
                   //provide your emulator name here
                   //Pixel_6_API_Tiramisu
                   prop = new Properties();
                   TestUtils.log().info("setting up the driver");
                   FileInputStream fis = new FileInputStream("D:\\AppiumProject\\AppiumProject\\src\\main\\resources\\config.properties");
                   prop.load(fis);
                   TestUtils.log().info("loading the property file");
                   DesiredCapabilities caps = new DesiredCapabilities();
                   TestUtils.log().info("getting the desired capabilities");
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

