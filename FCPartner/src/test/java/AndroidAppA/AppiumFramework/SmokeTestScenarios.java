package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SmokeTestScenarios extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static LoginScreen login;

	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appA");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login = new LoginScreen(driver);
		
	}

	@Test (priority=1)
	public void login()
		{
			//To Write appB Test Scenarios
		}
	
			
	@AfterClass
	public void tearDown()
	{
		service.stop();
	}
}
