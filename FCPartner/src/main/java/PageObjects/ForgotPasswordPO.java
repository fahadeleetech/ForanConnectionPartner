package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgotPasswordPO{
	
	public String error = "Please enter a valid password!";
	
	
	public ForgotPasswordPO(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement SignIn;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_forgot_pass")
	public WebElement ForgetpasswordButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_phone")
	public WebElement ForgetpasswordNumber;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement SubmitButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/firstPinView")
	public WebElement WriteOTP;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement Verify;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/et_pass")
	public WebElement Password;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/et_c_pass")
	public WebElement ConfirmPassword;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement LastSubmitButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/container")// Blank Click
	public WebElement BlankClick;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_phone")
	public WebElement LoginPhoneNumber;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/et_pass")
	public WebElement LoginPassword;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_submit")
	public WebElement LoginSigninButton;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public WebElement LoginAllowButton;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/textinput_error")
	public WebElement ErrorMessage;
	
	


}
