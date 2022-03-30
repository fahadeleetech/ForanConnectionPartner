package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HelpAndSupportPO{
	
	public String supportEmail = "support@el33tech.com";
	public String supportNumber = "+92-331-33-36726";
	
	public HelpAndSupportPO(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/profile_image")
	public WebElement AccountButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/title_help")
	public WebElement HelpAndSupportButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/headerIndicator")
	public WebElement CustomerSupportButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/text2")
	public WebElement CustomerSupportNumber;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tvEmail")
	public WebElement MessageSupport;
	

}
