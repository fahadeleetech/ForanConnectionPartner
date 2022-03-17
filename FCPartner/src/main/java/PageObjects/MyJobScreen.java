package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyJobScreen {
	public MyJobScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/profile_image")
	public WebElement profileIcon;
}
