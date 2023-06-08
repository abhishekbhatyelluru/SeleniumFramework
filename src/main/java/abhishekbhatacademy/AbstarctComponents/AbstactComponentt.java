package abhishekbhatacademy.AbstarctComponents;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstactComponentt 
{
	WebDriver driver;
	
	public AbstactComponentt(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[routerlink*=cart]") 
	WebElement cartclick;
	
	@FindBy(css="button[routerlink=\"/dashboard/myorders\"]") 
	WebElement orderclick;
	
	
	
	
	public void waitToElementToAppear(By findby)
	{
		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitt.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	
	public void waitWebToElementToAppear(WebElement ele)
	{
		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitt.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	
	public void waitElementToDisappear(WebElement ele) throws InterruptedException
	{
//		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(5));
//		waitt.until(ExpectedConditions.invisibilityOf(ele));
		
		TimeUnit.SECONDS.sleep(2);
	}
	
	
	public void gotoCartPage()
	{
		cartclick.click();
	}
	
	
	public void gotoOrderPage()
	{
		orderclick.click();
	}

}
