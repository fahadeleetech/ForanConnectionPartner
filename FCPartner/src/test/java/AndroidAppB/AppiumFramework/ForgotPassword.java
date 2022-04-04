
package AndroidAppB.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ForgotPassword extends Base{
	
	public static PageObjects.ForgotPasswordPO ForgotPasswordPO;
	
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

		ForgotPasswordPO = new PageObjects.ForgotPasswordPO(driver);
	}
	

	@Test 
	public void ForgotPassword() throws InterruptedException
		{
		
		
		ForgotPasswordPO.SignIn.click();
		ForgotPasswordPO.ForgetpasswordButton.click();
		ForgotPasswordPO.ForgetpasswordNumber.sendKeys("3331100082");
		ForgotPasswordPO.SubmitButton.click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.navigate().back();
		ForgotPasswordPO.WriteOTP.sendKeys("123456");
		
		Thread.sleep(5000);
		ForgotPasswordPO.Verify.click();
				
		ForgotPasswordPO.Password.sendKeys("Haseeb@6");
		ForgotPasswordPO.ConfirmPassword.sendKeys("Haseeb@6");
		ForgotPasswordPO.LastSubmitButton.click();
		
				
		
		}
	
	

}
