package abhishekbhatacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class OrdersPage extends AbstactComponentt 
{
    WebDriver driver;

	public OrdersPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	public boolean verifyOrderDisplay(String productname)
	{
		boolean match=orderlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		return match;
		
		
	}


	
	
	

}
