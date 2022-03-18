package AndroidAppB.AppiumFramework;
import io.appium.java_client.touch.WaitOptions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LoginScreenPo;

import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ProfileManagmentPersonal extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static LoginScreenPo loginuser;
	public static PageObjects.MyJobScreen myjob;
	public static PageObjects.MyAccount account;
	public static PageObjects.PersonalProfile profile;
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appB");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginuser = new LoginScreenPo(driver);
		myjob = new PageObjects.MyJobScreen(driver);
		account = new PageObjects.MyAccount(driver);
		profile=  new PageObjects.PersonalProfile(driver);
	}
	@Test (priority=1)
	public static void loginwithvaliduser() {
		loginuser.SigninBtn.click();
		loginuser.PhonePlaceHolder.sendKeys(loginuser.user);
		loginuser.Password.sendKeys(loginuser.userpassword);
		loginuser.Submitbtn.click();
		loginuser.allowbtn.click();
		
	}
	@Test (priority=2)
	public static void profileIcon() {
		myjob.profileIcon.click();
		
	}
	@Test (priority=3)
	public static void MyAccount() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  account.profileimage.click();
	}
	@Test (priority=4)
	public static void FirstLastname() {
		profile.editbtn.click();
		profile.firstname.clear();
		profile.firstname.sendKeys(profile.FristN);
		profile.lastname.clear();
		profile.lastname.sendKeys(profile.LastN);
		profile.savebtn.click();
	}
	@Test (priority=5)
	public static void verification() {
		String FristNverification = profile.firstname.getAttribute("text"); 
		String LastNverification = 	profile.lastname.getAttribute("text");
		String phoneNumber = profile.phonenumber.getAttribute("text");
		String Cnic = profile.IDcard.getAttribute("text");
		Assert.assertEquals(profile.FristN, FristNverification);
		Assert.assertEquals(profile.LastN, LastNverification );
		Assert.assertEquals(profile.CNIC, Cnic);
		Assert.assertEquals(profile.phoneNum, phoneNumber);
	}
	@Test (priority=6)
	public static void scroll() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//android.widget.ScrollView[@bounds='[0,191][1080,2040]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform();
		profile.uploadSideA.click();
		profile.allowbtn.click();
		profile.allowbtn1.click();
		profile.checkmark.click();
		profile.applybtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//profile.tickmark.click();
		
	}
	@Test (priority=7)
	public static void scrolltwo() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//android.widget.ScrollView[@bounds='[0,191][1080,2040]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform();
		profile.uploadSideB.click();
		profile.checkmark.click();
		profile.applybtn.click();
		profile.tickmark.click();
	}
	@Test (priority=8)
	public static void scrollthree() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//android.widget.ScrollView[@bounds='[0,191][1080,2040]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform();
		profile.uploadphoto.click();
		profile.checkmark.click();
		profile.applybtn.click();
		profile.tickmark.click();
	}
	
}
