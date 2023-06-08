package abhishekbhatacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class ConfirmationPage extends AbstactComponentt
{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="h1.hero-primary")
	WebElement confirmorder;
	
	public String confirmorder()
	{
		 String displaymsg = confirmorder.getText().trim();
		 return displaymsg;
	}
	
	
	
}
