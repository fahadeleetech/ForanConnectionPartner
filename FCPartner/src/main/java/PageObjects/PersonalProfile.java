package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PersonalProfile {
	public String FristN = "AzeemaQ";
	public String LastN = "QadeerA";
	public String phoneNum = "3331100062";
	public String CNIC = "1234545677879";
	public PersonalProfile(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//com.el33tech.servicesquad:id/menu_crop
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Crop\"]")
	public WebElement tickmark;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/check_view")
	public WebElement checkmark;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/button_apply")
	public WebElement applybtn;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
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

	
}
