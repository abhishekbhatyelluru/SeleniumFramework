package abhishekbhatacademy.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class CkeckoutPage extends AbstactComponentt
{

	WebDriver driver;
	public CkeckoutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css="a.action__submit")
	WebElement submit;
	
	By result=By.cssSelector(".ta-results");

	
	
	public void selectCountry(String countryname)
	{
		Actions aa=new Actions(driver);
	   aa.sendKeys(country,countryname).build().perform();
	 
	   waitToElementToAppear(result);
	   selectcountry.click();
	}
	
	
	public void submitOrder()
	{
		
		submit.click();
	}
	
	
	
}
