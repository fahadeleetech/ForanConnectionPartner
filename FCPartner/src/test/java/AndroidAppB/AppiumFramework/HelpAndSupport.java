
package AndroidAppB.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HelpAndSupport extends Base{
	
	public static PageObjects.HelpAndSupportPO HelpAndSupport;
	
	public static AndroidDriver<AndroidElement> driver;
	public static LoginScreen login;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appB");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		HelpAndSupport = new PageObjects.HelpAndSupportPO(driver);
	}
	

	@Test (priority=1)
	public void verifyCallSupportNumber()
		{
			
		driver.findElementById("com.el33tech.servicesquad:id/bt_submit").click();
		
		driver.findElementById("com.el33tech.servicesquad:id/detail_phone").sendKeys("3331100071");//3331100070 to run
		driver.findElementById("com.el33tech.servicesquad:id/et_pass").sendKeys("Haseeb@3");
		driver.findElementById("com.el33tech.servicesquad:id/bt_submit").click();
		
		driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		
		HelpAndSupport.AccountButton.click();
		HelpAndSupport.HelpAndSupportButton.click();
		HelpAndSupport.CustomerSupportButton.click();
		
		String verify = HelpAndSupport.CustomerSupportNumber.getAttribute("text");
		Assert.assertEquals(verify , HelpAndSupport.supportNumber);
		
		}
	
	@Test (priority=2)
	public void verifyEmail()
		{
		
		String verify = HelpAndSupport.MessageSupport.getAttribute("text");
		Assert.assertEquals(verify , HelpAndSupport.supportEmail);

		}
	
	
	@Test (priority=3)
	public void clickOnEmail()
		{
		
		HelpAndSupport.MessageSupport.isEnabled();
			
		}
	

	
	
	@Test (priority=4)
	public void clickOnCallSupportNumber()
		{
				
		HelpAndSupport.CustomerSupportNumber.click();
			
		}
	
	

}
