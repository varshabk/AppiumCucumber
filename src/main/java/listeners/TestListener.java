package listeners;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import reports.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListener implements ITestListener {
       BaseTest base = new BaseTest();
    @Override
    public void onTestStart(ITestResult result) {
ExtentReport.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    //    BaseTest base = new BaseTest();
      //  ExtentReport.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription())
      //          .assignAuthor("varsha");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
ExtentReport.getTest().log(Status.PASS,"Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       if( result.getThrowable()!=null) {
           StringWriter sw= new StringWriter();
           PrintWriter pw= new PrintWriter(sw);
           result.getThrowable().printStackTrace(pw);
           System.out.println(sw.toString());

       }
       String imagePath="screens/image.png";
       String newPath= "screens/"+result.getTestClass().getRealClass().getSimpleName()+result.getMethod().getMethodName()+base.getDateTime()+".png";
      File src= base.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            Reporter.log("this is the screenshot");
            FileUtils.copyFile(src, new File(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
       ExtentReport.getTest().log(Status.FAIL, "Test failed");
        ExtentReport.getTest().fail(String.valueOf(MediaEntityBuilder.createScreenCaptureFromPath(newPath)));



    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP,"Test skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();

    }
}
