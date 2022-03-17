package AndroidAppB.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LoginScreenPo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
public class LoginScreen extends Base{
	public static AppiumDriver<AndroidElement> driver;
	public static LoginScreenPo loginuser;
	public static String phoneheading;
	public static String phoneplaceholder;
	public static String placeholderpassword;
	public static String TextForgotpassword;
	public static String TextRegister;
	public static String TextCountryCode;
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appB");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginuser = new LoginScreenPo(driver);
	}
	@Test (priority=1)
	public static void verfication() {
		loginuser.SigninBtn.click();
		phoneheading = loginuser.phonetitle.getAttribute("text");
	    Assert.assertEquals(loginuser.Phone, phoneheading);
	   phoneplaceholder = loginuser.PhonePlaceHolder.getAttribute("text");
	   Assert.assertEquals(loginuser.Placeholderphone, phoneplaceholder);
	   placeholderpassword = loginuser.Password.getAttribute("text");
	  Assert.assertEquals(loginuser.Passwordplaceholder, placeholderpassword); 
	  TextForgotpassword = loginuser.forgotpassword.getAttribute("text");
	  Assert.assertEquals(loginuser.ForgotpasswrodText, TextForgotpassword);
	  TextRegister = loginuser.Donthaveanaccount.getAttribute("text");
	  Assert.assertEquals(loginuser.Registertext, TextRegister);
	  TextCountryCode = loginuser.CountryCode.getAttribute("text");
	  Assert.assertEquals(loginuser.CountryCodeText, TextCountryCode);
	}
	@Test (priority=2)
	public static void phonenumber() { 
		loginuser.SigninBtn.isEnabled();
		loginuser.PhonePlaceHolder.sendKeys(loginuser.user);
		loginuser.SigninBtn.isEnabled();
	}
	@Test (priority=3)
	public static void passworderrormessage() { 
		 Assert.assertEquals(loginuser.Passwordplaceholder, placeholderpassword);
			loginuser.Submitbtn.click();
			String errorEmpty = loginuser.errorMessage.getAttribute("text");
			 Assert.assertEquals(loginuser.emptypassword, errorEmpty);
			 System.out.println(loginuser.emptypassword);
		
	}
	@Test (priority=4)
	public static void passwordfieldminimumcharacter() { 
		loginuser.Password.sendKeys(loginuser.minimumcharacter);
		loginuser.Submitbtn.click();
		String errormsg = loginuser.errorMessage.getAttribute("text");
		 Assert.assertEquals(loginuser.ErrormsgonMinimumcharacter, errormsg);
		 System.out.println(loginuser.ErrormsgonMinimumcharacter);
		 
	}
	@Test (priority=5)
	public static void invalidPasssword() { 
		loginuser.Password.sendKeys(loginuser.invalidpassword);
		loginuser.Submitbtn.click();
		String errormsg = loginuser.errorMessage.getAttribute("text");
		Assert.assertEquals(loginuser.invalidpasswordmsg, errormsg);
	}
	@Test (priority=6)
	public static void notRegisteruser() {
		loginuser.PhonePlaceHolder.sendKeys(loginuser.unregisteruser);
		loginuser.Password.sendKeys(loginuser.userpassword);
		loginuser.Submitbtn.click();
		String errorEmpty = loginuser.errorMessage.getAttribute("text");
		 Assert.assertEquals(loginuser.usernotexist, errorEmpty);
		 System.out.println(loginuser.usernotexist);
	}
	@Test (priority=7)
	public static void loginwithvaliduser() {
		loginuser.PhonePlaceHolder.sendKeys(loginuser.user);
		loginuser.Password.sendKeys(loginuser.userpassword);
		loginuser.Submitbtn.click();
		loginuser.allowbtn.click();
		
	}
	
	

}
