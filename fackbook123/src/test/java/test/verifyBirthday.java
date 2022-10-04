package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import broswerSetup.Base;
import pages.CreateNewAccount;
import pages.Loginorsignuppage;

public class verifyBirthday extends Base{
	private WebDriver driver;
	private Loginorsignuppage loginorsignuppage;
	private CreateNewAccount createNewAccount;
	private SoftAssert soft;
	
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
		loginorsignuppage =new Loginorsignuppage(driver);
	}
	
	@BeforeMethod
	public void openURL() {
		driver.get("https://www.facebook.com/");		
		soft = new SoftAssert();
		createNewAccount.clickonCreatenewaccount();
	}
	@Test
	public void verifyBirthday() {
		String day=createNewAccount.selectBrithdayDay();
		System.out.println(day);
		boolean result=day.equals("18");
		soft.assertTrue(result);
		String month=createNewAccount.selectBrithdayMonth();
		System.out.println(month);
		boolean result1=month.equals("01");
		soft.assertTrue(result1);
		String year=createNewAccount.selectBrithdayYear();
		System.out.println(year);
		boolean result2=year.equals("1996");
		soft.assertTrue(result2);
		soft.assertAll();
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
