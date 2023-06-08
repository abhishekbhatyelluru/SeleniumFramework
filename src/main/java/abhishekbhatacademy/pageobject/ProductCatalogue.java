package abhishekbhatacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishekbhatacademy.AbstarctComponents.AbstactComponentt;

public class ProductCatalogue extends AbstactComponentt
{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> allproducts=driver.findElements(By.cssSelector("div.col-sm-10"));
	@FindBy(css="div.col-sm-10")
	List<WebElement> productlist;    //Its a List
	
	@FindBy(css=".ng-animating")
	WebElement loaddisappear;
	
	By productby = By.cssSelector("div.col-sm-10");   //driver.findelement is not there
	By addTocartButton = By.cssSelector("div.card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitToElementToAppear(productby);
		return productlist;
		
	}

	public WebElement getProductByName(String productname)
	{
		 WebElement prod=getProductList().stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
	     return prod;
	     
	}
	
	public void addToCartClick(String productname) throws InterruptedException
	{
		WebElement prodd=getProductByName(productname);
		prodd.findElement(addTocartButton).click();
		
		waitToElementToAppear(toastmessage);
		waitElementToDisappear(loaddisappear);
	}

	

}
