package PageObjects;
import static java.time.Duration.ofSeconds;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PersonalProfile {
	public String FristN = "AzeemaQ";
	public String LastN = "QadeerA";
	public String phoneNum = "3214204308";
	public String CNIC = "1234545677879";
	public PersonalProfile(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement updateToastMessage;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/menu_crop")
	public WebElement tickmark;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/check_view")
	public WebElement checkmark;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/button_apply")
	public WebElement applybtn;
	//@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	//public WebElement allowbtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	public WebElement allowbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_nic")
	public WebElement IDcard;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_edit_save")
	public WebElement editbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_edit_save")
	public WebElement savebtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_fname")
	public WebElement firstname;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_lname")
	public WebElement lastname;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_phone")
	public WebElement phonenumber;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update side A photo']")
	public WebElement uploadSideA;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update side B photo']")
	public WebElement uploadSideB;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update passport photo']")
	public WebElement uploadphoto;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public WebElement allowPopUp;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/iv_back")
	public WebElement backbtn;
	
	public void scroll(AndroidDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//android.widget.ScrollView[@bounds='[0,191][1080,2040]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform(); }

	
}
