package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BusinessProfile {
	public String BusinessName= "El33tech lahore";
	public String BusinessAbout = "Providing Electrician services";
	public String   BusinessStart = "Mon, 14 Mar 2022";
	public String setLocation       = "Block N Gulberg III, Lahore, Punjab, Pakistan";
	public String Location = "Lahore";
	public BusinessProfile(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/linear_skills")
	public WebElement skill;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/linear_b_loc")
	public WebElement location;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/linear_address")
	public WebElement address;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/linear_portfolio")
	public WebElement portfolio;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_edit_save")
	public WebElement editsavedeletebtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_email")
	public WebElement businessDetail;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_about")
	public WebElement AboutBusiness;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/detail_start_date")
	public WebElement startdate;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/linear_to_map")
	public WebElement adjustfrommap;
	
	//com.el33tech.servicesquad:id/iv_back
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/iv_back")
	public WebElement backbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_continue")
	public WebElement deletebtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/iv_remove")
	public WebElement removeText;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/tv_display")
	public WebElement searchBar;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/place_area")
	public WebElement suggestion;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_confirm")
	public WebElement confirmbtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/et_place_address")
	public WebElement businessAddress;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/textTitle1")
	public WebElement updateSkill;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Moving']")
	public WebElement movingBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Maid']")
	public WebElement maidBtn;
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='10']")
	public WebElement relative10;
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='12']")
	public WebElement relative12;
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='13']")
	public WebElement relative13;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gardener']")
	public WebElement gardenerBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cook']")
	public WebElement cookBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cleaning']")
	public WebElement cleaningBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Furniture']")
	public WebElement furnitureBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrical Supplies']")
	public WebElement electricalSuppliesBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock Master']")
	public WebElement lockMasterBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Boring']")
	public WebElement 	boringBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Door Works']")
	public WebElement doorWorksBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glass Designer']")
	public WebElement glassDesignerBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paint']")
	public WebElement paintBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paint Supplies']")
	public WebElement paintSuppliesBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Furniture & Wood']")
	public WebElement furnitureWoodBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrician']")
	public WebElement electricianBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Heating & Cooling']")
	public WebElement heatingCoolingBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Plumber']")
	public WebElement plumberBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electronics & Repair']")
	public WebElement electronicsRepairBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sanitary']")
	public WebElement sanitaryBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Handyman']")
	public WebElement handymanBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Painter']")
	public WebElement painterBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Carpenter']")
	public WebElement carpenterBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AC Mechanic']")
	public WebElement ACMechanicBtn; //
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glass Works']")
	public WebElement glassWorksBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gas Services']")
	public WebElement gasServicesBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hardware']")
	public WebElement hardwareBtn;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Aluminium Work']")
	public WebElement aluminiumWorkBtn;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/bt_update")
	public WebElement updatebtn;
	//android.widget.RelativeLayout
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/check_view")
	public WebElement checkboximage;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/button_apply")
	public WebElement applyimage;
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index='1']")
	public WebElement selectfirstImage;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	public WebElement While;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public WebElement allowbtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
	public WebElement whilesmall;
	
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/add_new_portfolio")
	public WebElement uploadPortfolio;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/name")
	public WebElement nameSkill;
	@AndroidFindBy(id = "com.el33tech.servicesquad:id/t_aa")
	public WebElement selectedSkill;
    public Boolean verifycook() {
    	 return relative10.findElement(By.id("com.el33tech.servicesquad:id/iv_tick")).isDisplayed();
    }
    public Boolean verifymaid() {
   	 return relative13.findElement(By.id("com.el33tech.servicesquad:id/iv_tick")).isDisplayed();
   }
    
	
}
