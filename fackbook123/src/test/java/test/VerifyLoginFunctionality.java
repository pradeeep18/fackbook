package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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
import pages.Loginorsignuppage;
import utils.Utility;

public class VerifyLoginFunctionality extends Base {
	private WebDriver driver;
	private Loginorsignuppage loginorsinguppage;
	private int TestId;
	private SoftAssert soft;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			driver=openChromeBrowser();
		}
		if(browserName.equals("Edge")) {
			driver=openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void objectPOMClass() {
	loginorsinguppage=new Loginorsignuppage(driver);
	}
	
	@BeforeMethod
	public void openURL() {
		driver.get("https://www.facebook.com/");
		soft = new SoftAssert();
	}
	@Test
	public void verifyLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		TestId = 18;
		String data =Utility.getExcelData("LoginCredentials", 0, 1);
		loginorsinguppage.SendUsername(data);
		
		String data1 =Utility.getExcelData("LoginCredentials", 1, 1);
		loginorsinguppage.SendPassword(data1);
		//loginorsinguppage.ClickonLoginButton();
		//Thread.sleep(3000);
		String title=driver.getTitle();
		
		soft.assertEquals(title, "(20+) Facebook");
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
		loginorsinguppage=null;
//	}
//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//		driver=null;
//		System.gc();
	}
}
