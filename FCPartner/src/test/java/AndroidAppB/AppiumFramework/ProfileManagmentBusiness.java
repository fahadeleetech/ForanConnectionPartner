package AndroidAppB.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.BusinessProfile;
import PageObjects.LoginScreenPo;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
public class ProfileManagmentBusiness extends Base {
	public static AndroidDriver<AndroidElement> driver;
	public static LoginScreenPo loginuser;
	public static PageObjects.MyJobScreen myjob;
	public static PageObjects.MyAccount account;
	public static PageObjects.PersonalProfile profile;
	public static BusinessProfile Bprofile;
	static String verifyskills;
	static String selectedSkill;
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
		Bprofile=  new BusinessProfile(driver);
	}
	@Test (priority=1)
	public static void loginwithvaliduser() {
		loginuser.SigninBtn.click();
		loginuser.PhonePlaceHolder.sendKeys(loginuser.user);
		loginuser.Password.sendKeys(loginuser.userpassword);
		loginuser.Submitbtn.click();
		loginuser.allowbtn.click();}
	@Test (priority=2)
	public static void profileIcon() {
		myjob.profileIcon.click();
		
	}
	@Test (priority=3)
	public static void myAccount() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  account.businessDetail.click();
	}
	@Test (priority=4)
	public static void businessDetail() {
		Bprofile.editsavedeletebtn.click();
		Bprofile.address.click();
		Bprofile.businessDetail.clear();
		Bprofile.businessDetail.sendKeys(Bprofile.BusinessName);
		Bprofile.AboutBusiness.clear();
		Bprofile.AboutBusiness.sendKeys(Bprofile.BusinessAbout);
		String bName = Bprofile.businessDetail.getAttribute("text");
		Assert.assertEquals(Bprofile.BusinessName, bName);
		String aboutB = Bprofile.AboutBusiness.getAttribute("text");
		Assert.assertEquals(Bprofile.BusinessAbout, aboutB);
		String bDate = Bprofile.startdate.getAttribute("text");
		Assert.assertEquals(Bprofile.BusinessStart, bDate);
		Bprofile.address.click();
	}
	@Test (priority=5)
	public static void businessLocation() {
		Bprofile.location.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Bprofile.adjustfrommap.click();
		Bprofile.removeText.click();
		Bprofile.searchBar.click();
		Bprofile.searchBar.sendKeys(Bprofile.Location);
		String suggestion = Bprofile.suggestion.getAttribute("text");
		Assert.assertEquals(Bprofile.Location,suggestion );
			Bprofile.suggestion.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
			Bprofile.confirmbtn.click();
		String address = Bprofile.businessAddress.getAttribute("text");
			Assert.assertEquals(Bprofile.setLocation,  address);
			Bprofile.location.click();
		
	}
	@Test (priority=6)
	public static void skillSelected() { 
		Bprofile.skill.click();
	   selectedSkill = Bprofile.selectedSkill.getAttribute("text");
		System.out.println(selectedSkill +" "+ "skill is selected during Registration");
	}
	@Test (priority=7)
	public static void skillscrollone() {
		
		Bprofile.updateSkill.click();
		//androidx.recyclerview.widget.RecyclerView
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@bounds='[75,387][1005,1697]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform();
	}
	@Test (priority=9)
	public static void skillscrolltwo() {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement sc=driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@bounds='[75,387][1005,1697]']");
		Dimension dm = sc.getSize(); 
		int startX = (int) (dm.width*0.5); 
		int startY = (int) (dm.height*0.8); 
		int endX = (int) (dm.width*0.2); 
		int endY = (int) (dm.height*0.2); 
		AndroidTouchAction ta = new AndroidTouchAction(driver);
		ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
		.moveTo(PointOption.point(endX,endY) ).release().perform();
	}
	/*	@Test (priority=9)
	public static void cookverification() 
	{
		Boolean turefalse = Bprofile.verify();
		if(turefalse) {
			System.out.println("Tick"); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
	}  */
	@Test (priority=10)
	public static void verificationofSelectedSkill() {
	verifyskills = Bprofile.relative10.findElement(By.id("com.el33tech.servicesquad:id/name")).getAttribute("text");
		Assert.assertEquals(selectedSkill, verifyskills);
		Boolean turefalse = Bprofile.verifycook();
		if(turefalse) {
			System.out.println("Tick mark shown on skill"+""+ selectedSkill); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
	}
	@Test (priority=11)
	public static void skillUnselect() {
		Bprofile.cookBtn.click();
	}
	@Test (priority=12)
	public static void verifyOtherSkillsEnabled() {
		Bprofile.movingBtn.click();
		Bprofile.updatebtn.isEnabled();
		Bprofile.movingBtn.click();
		Bprofile.boringBtn.click();
		Bprofile.updatebtn.isEnabled();
		Bprofile.boringBtn.click();
		Bprofile.doorWorksBtn.click();
		Bprofile.updatebtn.isEnabled();
		Bprofile.doorWorksBtn.click();
		Bprofile.lockMasterBtn.click();
		Bprofile.updatebtn.isEnabled();
		Bprofile.lockMasterBtn.click();
	}
	@Test (priority=13)
	public static void updateSkill() {
		Bprofile.maidBtn.click();
		String updateSkilltext = Bprofile.maidBtn.getAttribute("text");
		Boolean turefalse = Bprofile.verifymaid();
		if(turefalse) {
			System.out.println("Tick mark shown on skill"+" "+ updateSkilltext); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
		Bprofile.updatebtn.click();
		 selectedSkill = Bprofile.selectedSkill.getAttribute("text");
		 Assert.assertEquals(updateSkilltext, selectedSkill);
			System.out.println(selectedSkill +" "+ "skill updated");	
	}
	@Test (priority=14)
	public static void updateSkillToCook() {
		//Bprofile.skill.click();
		skillscrollone();
		skillscrolltwo();
		Bprofile.maidBtn.click();
		Bprofile.cookBtn.click();
		String updateSkilltext = Bprofile.cookBtn.getAttribute("text");
		Boolean turefalse = Bprofile.verifycook();
		if(turefalse) {
			System.out.println("Tick mark shown on skill"+" "+ updateSkilltext); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
		Bprofile.updatebtn.click();
		 selectedSkill = Bprofile.selectedSkill.getAttribute("text");
		 Assert.assertEquals(updateSkilltext, selectedSkill);
			System.out.println(selectedSkill +" "+ "skill updated");	
			Bprofile.skill.click();
	}
	@Test (priority=15)
	public static void portfolio() {
		Bprofile.portfolio.click();
		Bprofile.uploadPortfolio.click();
		Bprofile.allowbtn.click();
		Bprofile.allowbtn.click();
		Bprofile.checkboximage.click();
		Bprofile.applyimage.click();
	}
	@Test (priority=16)
	public static void deleteImagePortfolio() {
		TouchAction ta = new TouchAction(driver); 
		ta.longPress(longPressOptions().withElement(element(Bprofile.selectfirstImage)).withDuration(ofSeconds(2))).release().perform();
		Bprofile.selectfirstImage.click();
		Bprofile.editsavedeletebtn.click();
		Bprofile.deletebtn.click();
		Bprofile.backbtn.click();
		Bprofile.portfolio.click();
	}
	@Test (priority=17)
	public static void save() {
	       Bprofile.editsavedeletebtn.click();
	}
	
		
}
