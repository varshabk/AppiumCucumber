package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ThankYouPage extends BaseTest{
	
	public ThankYouPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
	WebElement thanksTitle;
@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]")
WebElement thanksDescription;
@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]")
WebElement orderStatus;
@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView")
WebElement imageView;
	
	public String getThankTitle() {
		String thankTitle=getText(thanksTitle);
		return thankTitle;
	}
	public String getThankDescription() {
		String thankDesc= getText(thanksDescription);
		return thankDesc;
	}
	public String getOrderStatus() {
		String orderstatus= getText(orderStatus);
		return orderstatus;
	}
	public boolean checkImageDisplayed() {
		return imageView.isDisplayed();
		
	}

}
