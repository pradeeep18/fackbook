package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginorsignuppage {
	
	//Variable declartion
	@FindBy (xpath = "//input[@id='email']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement loginbutton;
	
	
	//Variable Inatillization
	
    public Loginorsignuppage(WebDriver driver) { //driver=test=new chrom
		PageFactory.initElements(driver, this);
	}
    
    //Variable use
    
    public void SendUsername(String user) {
    	username.sendKeys(user);
    }
    
    public void SendPassword(String pass) {
    	password.sendKeys(pass);
    }
	
    public void ClickonLoginButton() {
    	loginbutton.click();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
