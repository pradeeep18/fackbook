package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount {
	
		private WebDriver driver;
		
		@FindBy (xpath = "(//a[@role='button'])[2]") 
		private WebElement createnewaccountbutton ;
		
		@FindBy (xpath ="//input[@name='firstname']") 
		private WebElement firstname;
		
		@FindBy (xpath = "//input[@name='lastname']")
		private WebElement lastname;
		
		@FindBy (xpath = "//input[@name='reg_email__']")
		private WebElement mobilenoemail;
		
		@FindBy (xpath = "//input[@name='reg_passwd__']")
		private WebElement newpassword;

		@FindBy (xpath = "//select[@name='birthday_day']")
		private WebElement birthdayday;
		
		@FindBy (xpath = "//select[@name='birthday_month']")
		private WebElement birthdaymonth;
		
		@FindBy (xpath = "//select[@name='birthday_year']")
		private WebElement birthdayyear;
		
		@FindBy (xpath = "(//input[@type='radio'])[1]")
		private WebElement women;
		
		@FindBy (xpath = "(//input[@type='radio'])[2]")
		private WebElement male;
		
		@FindBy (xpath = "(//input[@type='radio'])[3]")
		private WebElement custom;
		
		@FindBy (xpath="(//font[text()='Sign up'])[3]")
		private WebElement signin;
		
	
		public CreateNewAccount(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;	
		}
		
		public String getAttributeValueFirstName() {
		String attributevalue=firstname.getAttribute("aria-label");
		return attributevalue;
		}
		public String getAttributeValueLastName() {
		String attributevalue=lastname.getAttribute("aria-label");
		return attributevalue;
		}
		
		public String getAttributeValueMobileNoEmailId() {
			String attributevalue=mobilenoemail.getAttribute("aria-label");
		return attributevalue;
		}
		
		public void clickonCreatenewaccount() {
			createnewaccountbutton.click();
		}
		public void sendFirstname() {
			firstname.sendKeys("pradeep");
		}
		public void sendLastname() {
			lastname.sendKeys("khatode");
		}
		public void sendMobilenoEmailid() {
			mobilenoemail.sendKeys("khatodepradeep@gmail.com");
		}
		public void sendNewpassword() {
			newpassword.sendKeys("pradeep123");
		}
		public String selectBrithdayDay() {
			Select sel=new Select(birthdayday);
			sel.selectByIndex(17);
			
			String date=birthdayday.getText();
			return date;
		}
		public String selectBrithdayMonth() {
			Select sel=new Select(birthdaymonth);
			sel.selectByIndex(0);
			String month=birthdaymonth.getText();
			return month;
		}
		public String selectBrithdayYear() {
			Select sel=new Select(birthdayyear);
			sel.selectByVisibleText("1996");
			String year=birthdaymonth.getText();
			return year;
		}
		public void selectWomen() {
			women.click();
		}
		public void selectMale() {
			male.click();
		}
		public void selectCustom() {
			custom.click();
		}
		public void clickonSignin() {
			signin.click();
		}
		public boolean maleIsSelected() {
			boolean result=male.isSelected();
			return result;
		}	
		public boolean womenIsSelected() {
			boolean result=women.isSelected();
			return result;
		}
		public boolean customIsSelected() {
			boolean result=custom.isSelected();
			return result;
		}
		public boolean clickOnCustom() {
			custom.click();
			boolean result=custom.isSelected();
			return result;
		}
}
