package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreenPo {
	public String Phone =  "Phone Number" ;
	public String Placeholderphone = "301 2345678"; 
	public String Passwordplaceholder = "Password" ;
	public String ForgotpasswrodText = "Forgot password?";
	public String Registertext = "Don't have an account? Register";
	public String CountryCodeText = "(PK) +92";
	public String user = "3331100062";
	public String userpassword = "1234@Azs";
	public String minimumcharacter = "123";
	public String ErrormsgonMinimumcharacter = "Requires a Password of minimum 8 characters";
	public String invalidpasswordmsg ="Please enter a valid password!";
	public String invalidpassword = "12345@Azs";
	public String unregisteruser ="3326217860";
	public String emptypassword = "Password cannot be empty";
	public String usernotexist = "User does not exist";
	public LoginScreenPo(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	//public WebElement allowbtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	public WebElement allowbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/textinput_error")
	public WebElement errorMessage;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement SigninBtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/selected_country_tv")
	public WebElement CountryCode ;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_phone")
	public WebElement PhonePlaceHolder;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/et_pass")
	public WebElement Password;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement Submitbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_forgot_pass")
	public WebElement forgotpassword;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/title_phone")
	public WebElement phonetitle;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/text_input_password_toggle")
	public WebElement passwordtoggle;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_already")
	public WebElement Donthaveanaccount;

}
