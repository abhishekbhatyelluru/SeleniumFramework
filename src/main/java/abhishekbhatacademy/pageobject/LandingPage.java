package abhishekbhatacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class LandingPage extends AbstactComponentt
{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#userEmail")
	WebElement username;
	
	@FindBy(css="input#userPassword")
	WebElement password;
	
	@FindBy(css="input#login")
	WebElement loginbutton;
	
	@FindBy(css="div.toast-message")
	WebElement errormesg;
	

	public void landingpageapplication(String emailid, String pass)
	{
		
		username.sendKeys(emailid);
		password.sendKeys(pass);
		loginbutton.click();
		
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrormesgg()
	{
		waitWebToElementToAppear(errormesg);
		return errormesg.getText();
	}
	

}
