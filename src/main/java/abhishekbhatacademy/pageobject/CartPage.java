package abhishekbhatacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class CartPage extends AbstactComponentt 
{

	WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="div.cartSection h3")
	List<WebElement> cartitems;
	
	@FindBy(css="div.subtotal button")
	WebElement checkoutclick;
	
	public List<WebElement> getCartItemsList()
	{
		return cartitems;
	}
	

	public boolean verifyProductDisplay(String productname)
	{
		  boolean match=getCartItemsList().stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));  //returns true if it is equal
	      return match;
	}
	
	
	public void gotoCheckout()
	{
		checkoutclick.click();
	}
	
}
