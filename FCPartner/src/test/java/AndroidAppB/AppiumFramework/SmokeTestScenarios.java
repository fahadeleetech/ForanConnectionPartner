package AndroidAppB.AppiumFramework;
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
//import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import AndroidAppB.AppiumFramework.Base;
import PageObjects.LoginScreenPo;
import PageObjects.MyAccount;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SmokeTestScenarios extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static LoginScreenPo loginuser;
	public static PageObjects.MyJobScreen myjob;
	public static MyAccount account;
	public static PageObjects.PersonalProfile profile;
	public static PageObjects.BusinessProfile Businessprofile;
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
		loginuser= new LoginScreenPo(driver);
		myjob = new PageObjects.MyJobScreen(driver);
		account = new MyAccount(driver);
		profile=  new PageObjects.PersonalProfile(driver);
		Businessprofile=  new PageObjects.BusinessProfile(driver);
		
	}

	@Test (priority=1)
	public void loginWithExistingUser()
		{
		loginuser.SigninBtn.click();
		loginuser.PhonePlaceHolder.sendKeys(loginuser.user);
		loginuser.Password.sendKeys(loginuser.userpassword);
		loginuser.Submitbtn.click();
		loginuser.allowbtn.click();
		}
	@Test (priority=2)
	public void editVendorPersonalProfile() {
		myjob.profileIcon.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  account.profileimage.click();
		  profile.editbtn.click();
			profile.firstname.clear();
			profile.firstname.sendKeys(profile.FristN);
			profile.lastname.clear();
			profile.lastname.sendKeys(profile.LastN);
			profile.savebtn.click();
			String toastMessage= profile.updateToastMessage.getAttribute("name");
			Assert.assertEquals(toastMessage, "Details Updated Successfully");
			String FristNverification = profile.firstname.getAttribute("text"); 
			String LastNverification = 	profile.lastname.getAttribute("text");
			String phoneNumber = profile.phonenumber.getAttribute("text");
			String Cnic = profile.IDcard.getAttribute("text");
			Assert.assertEquals(profile.FristN, FristNverification);
			Assert.assertEquals(profile.LastN, LastNverification );
			Assert.assertEquals(profile.CNIC, Cnic);
			Assert.assertEquals(profile.phoneNum, phoneNumber);
	} 
	@Test (priority=3)
	public static void  UploadSideAOfCnic() {
		profile.scroll(driver);
		profile.uploadSideA.click();
		profile.allowbtn.click();
		profile.allowPopUp.click();
		profile.checkmark.click();
		profile.applybtn.click();
		String toastMessage= profile.updateToastMessage.getAttribute("name");
		Assert.assertEquals(toastMessage, "Updated Successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//profile.tickmark.click();
		
	}
	@Test (priority=4)
	public static void UploadSideBOfCnic() {
		profile.scroll(driver);
		profile.uploadSideB.click();
		profile.checkmark.click();
		profile.applybtn.click();
		profile.tickmark.click();
		String toastMessage= profile.updateToastMessage.getAttribute("name");
		Assert.assertEquals(toastMessage, "Updated Successfully");
	}
	@Test (priority=5)
	public static void UploadPassportSizeImage(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		profile.scroll(driver);
		profile.uploadphoto.click();
		profile.checkmark.click();
		profile.applybtn.click();
		profile.tickmark.click();
		String toastMessage= profile.updateToastMessage.getAttribute("name");
		Assert.assertEquals(toastMessage, "Updated Successfully");
		profile.backbtn.click();
	}
	
	@Test (priority= 6)
	public void editVendorBusinessProfile() {
	account.businessDetail.click();
	Businessprofile.editsavedeletebtn.click();
	Businessprofile.address.click();
	Businessprofile.businessDetail.clear();
	Businessprofile.businessDetail.sendKeys(Businessprofile.BusinessName);
	Businessprofile.AboutBusiness.clear();
	Businessprofile.AboutBusiness.sendKeys(Businessprofile.BusinessAbout);
	String bName = Businessprofile.businessDetail.getAttribute("text");
	Assert.assertEquals(Businessprofile.BusinessName, bName);
	String aboutB = Businessprofile.AboutBusiness.getAttribute("text");
	Assert.assertEquals(Businessprofile.BusinessAbout, aboutB);
	//String bDate = Businessprofile.startdate.getAttribute("text");
	//Assert.assertEquals(Businessprofile.BusinessStart, bDate);
	Businessprofile.address.click();
	}
	@Test (priority=7)
	public static void businessLocation() {
		Businessprofile.location.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		Businessprofile.adjustfrommap.click();
		Businessprofile.removeText.click();
		Businessprofile.searchBar.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Businessprofile.searchBar.sendKeys(Businessprofile.Location);
		
		String suggestion = Businessprofile.suggestion.getAttribute("text");
		Assert.assertEquals(Businessprofile.Location,suggestion );
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Businessprofile.suggestion.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
			Businessprofile.confirmbtn.click();
		String address = Businessprofile.businessAddress.getAttribute("text");
			Assert.assertEquals(Businessprofile.setLocation,  address);
			Businessprofile.location.click();
		
	}
	@Test (priority= 8) 
	public static void skillSelected() { 
		Businessprofile.skill.click();
	   selectedSkill = Businessprofile.selectedSkill.getAttribute("text");
		System.out.println(selectedSkill +" "+ "skill is selected during Registration");
		Businessprofile.updateSkill.click();
		//androidx.recyclerview.widget.RecyclerView
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Businessprofile.updateskillscroll(driver);
		Businessprofile.updateskillscroll(driver);
	}

	@Test (priority=9)
	public static void verificationofSelectedSkill() {
	verifyskills =Businessprofile.relative11.findElement(By.id("com.el33tech.servicesquad:id/name")).getAttribute("text");
		Assert.assertEquals(selectedSkill, verifyskills);
		Boolean turefalse = Businessprofile.verifycook();
		if(turefalse) {
			System.out.println("Tick mark shown on skill"+""+ selectedSkill); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
	}
	@Test (priority=10)
	public static void skillUnselect() {
		Businessprofile.cookBtn.click();
	}
	@Test (priority=11)
	public static void updateSkillToMaid() {
		Businessprofile.maidBtn.click();
		String updateSkilltext = Businessprofile.maidBtn.getAttribute("text");
		Boolean truefalse = Businessprofile.verifymaid();
		if(truefalse) {
			System.out.println("Tick mark shown on skill"+" "+ updateSkilltext); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
		Businessprofile.updatebtn.click();
		 selectedSkill = Businessprofile.selectedSkill.getAttribute("text");
		 Assert.assertEquals(updateSkilltext, selectedSkill);
			System.out.println(selectedSkill +" "+ "skill updated");	
			String toastMessage= Businessprofile.updateToastMessage.getAttribute("name");
			Assert.assertEquals(toastMessage, "Skills Updated Successfully");
	}
	@Test (priority=12)
	public static void updateSkillToCook() {
		Businessprofile.updateSkill.click();
		Businessprofile.updateskillscroll(driver);
		Businessprofile.updateskillscroll(driver);
		Businessprofile.maidBtn.click();
		Businessprofile.cookBtn.click();
		String updateSkilltext = Businessprofile.cookBtn.getAttribute("text");
		Boolean turefalse = Businessprofile.verifycook();
		if(turefalse) {
			System.out.println("Tick mark shown on skill"+" "+ updateSkilltext); }
		else {
	    	 System.out.println("This skill is not selected");
	    }
		Businessprofile.updatebtn.click();
		 selectedSkill = Businessprofile.selectedSkill.getAttribute("text");
		 Assert.assertEquals(updateSkilltext, selectedSkill);
			System.out.println(selectedSkill +" "+ "skill updated");	
			Businessprofile.skill.click();
			String toastMessage= Businessprofile.updateToastMessage.getAttribute("name");
			Assert.assertEquals(toastMessage, "Skills Updated Successfully");
			
	}
	@Test (priority=13)
	public static void portfolio() {
		Businessprofile.portfolio.click();
		Businessprofile.uploadPortfolio.click();
		//Businessprofile.allowbtn.click();
		//Businessprofile.allowbtn.click();
		Businessprofile.checkboximage.click();
		Businessprofile.applyimage.click();
		
	}
	/*@Test (priority=14)
	public static void deleteImagePortfolio() {
		WebDriverWait waitprofileIcon = new WebDriverWait(driver, 10);
		waitprofileIcon.until(ExpectedConditions.elementToBeClickable(Businessprofile.selectfirstImage));
		TouchAction ta = new TouchAction(driver); 
		ta.longPress(longPressOptions().withElement(element(Businessprofile.selectfirstImage)).withDuration(ofSeconds(2))).release().perform();
		Businessprofile.selectfirstImage.click();
		Businessprofile.editsavedeletebtn.click();
		Businessprofile.deletebtn.click();
		 String toastMessage= Businessprofile.updateToastMessage.getAttribute("name");
			Assert.assertEquals(toastMessage, "Deleted Successfully!");
			Businessprofile.backbtn.click();
			Businessprofile.portfolio.click();
			profile.backbtn.click();
	}*/
}
