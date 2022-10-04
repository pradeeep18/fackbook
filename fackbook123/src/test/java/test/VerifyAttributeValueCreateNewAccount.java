package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import broswerSetup.Base;
import pages.CreateNewAccount;
import utils.Utility;

public class VerifyAttributeValueCreateNewAccount extends Base {
	private WebDriver driver;
	private CreateNewAccount createNewAccount;
	private SoftAssert soft;
	private int TestId;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		if(browserName.equals("Chrome")) 
		{
		driver=openChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
		  driver=openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void createPOMObject() {
		createNewAccount=new CreateNewAccount(driver);
		
	}
	
	@BeforeMethod
	public void openURL() {
		driver.get("https://www.facebook.com/");
		soft = new SoftAssert();
		createNewAccount.clickonCreatenewaccount();
	}
	
	@Test (priority =1)
	public void verifyAttributeValueFirstName() {
		TestId=19;
		String firstname=createNewAccount.getAttributeValueFirstName();
		boolean result =firstname.equals("First na");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@Test  (priority =2)
	public void verifyAttributeValueLastName() {
		TestId=20;
		String lastname=createNewAccount.getAttributeValueLastName();
		boolean result =lastname.equals("Surna");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@Test  (priority =3)
	public void verifyAttributeValueMobileEmailId() {
		TestId=21;
		String mobileNo=createNewAccount.getAttributeValueMobileNoEmailId();
		boolean result =mobileNo.equals("Mobile number or email address");
		soft.assertTrue(result);
		soft.assertAll();
	}
	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.screenShot(TestId);
		}
	}
	@AfterClass
	public void removeObject() {
		createNewAccount=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
}
