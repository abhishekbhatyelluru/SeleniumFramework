package abhishekbhatacademy.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import abhishekbhatacademy.TestComponent.BaseTest;
import abhishekbhatacademy.pageobject.CartPage;
import abhishekbhatacademy.pageobject.LandingPage;
import abhishekbhatacademy.pageobject.ProductCatalogue;


public class ErrorValidationTest extends BaseTest
{

	@Test(groups= {"ErrorHandling"})
	public void loginErrorvalidation() throws IOException
	{

		LandingPage landing=launchApplication();
		//give wrong password in login page and check for error mesg
		landing.landingpageapplication("yiwovo8122@usharer.com","As");
	    Assert.assertEquals("Incorrect email or password.",landing.getErrormesgg());	
					
	}
	
	@Test
	public void productvalidation() throws IOException, InterruptedException
	{

		LandingPage landing=launchApplication();
		landing.landingpageapplication("yiwovo8122@usharer.com","Asdfghjkl@1234");
		
				
		ProductCatalogue productcatalogueobj=new ProductCatalogue(driver);
		List<WebElement> products=productcatalogueobj.getProductList();
		String productname="IPHONE 13 PRO";
		productcatalogueobj.addToCartClick(productname);
		productcatalogueobj.gotoCartPage();
		
		CartPage cartpageobj=new CartPage(driver);
		//giving wrong name & checking it is not displaying this product
		boolean match=cartpageobj.verifyProductDisplay("IPHONE 13 PRO000000000000000000");
		Assert.assertFalse(match); //Output should be false as this product not present in this cart
					
	} 
	
	

}
