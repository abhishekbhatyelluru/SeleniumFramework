package abhishekbhatacademy.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abhishekbhatacademy.TestComponent.BaseTest;
import abhishekbhatacademy.pageobject.CartPage;
import abhishekbhatacademy.pageobject.CkeckoutPage;
import abhishekbhatacademy.pageobject.ConfirmationPage;
import abhishekbhatacademy.pageobject.LandingPage;
import abhishekbhatacademy.pageobject.OrdersPage;
import abhishekbhatacademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	
	String productname="IPHONE 13 PRO";

	@Test(dataProvider="getDataa", groups="perchase")
	public void submitorder(String email,String password,String productname) throws IOException, InterruptedException
	{	
		LandingPage landing=launchApplication();
		landing.landingpageapplication("yiwovo8122@usharer.com","Asdfghjkl@1234");
		
				
		ProductCatalogue productcatalogueobj=new ProductCatalogue(driver);
		List<WebElement> products=productcatalogueobj.getProductList();
		
		productcatalogueobj.addToCartClick(productname);
		productcatalogueobj.gotoCartPage();
		
		CartPage cartpageobj=new CartPage(driver);
		boolean match=cartpageobj.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		cartpageobj.gotoCheckout();
		
		
		String countryname="India";
		CkeckoutPage checkoutpageobj=new CkeckoutPage(driver);
		checkoutpageobj.selectCountry(countryname);
		checkoutpageobj.submitOrder();
		
		ConfirmationPage confirmpageobj=new ConfirmationPage(driver);
		String displaymsg=confirmpageobj.confirmorder();
		Assert.assertTrue(displaymsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


	}
	
	@Test(dependsOnMethods="submitorder")  //because before checking in order list, product should added to the orderlist
	public void orderHistoryTest() throws IOException
	{
		LandingPage landing=launchApplication();
		landing.landingpageapplication("yiwovo8122@usharer.com","Asdfghjkl@1234");
		
		OrdersPage orderpageobj=new OrdersPage(driver);
		orderpageobj.gotoOrderPage();
	    Assert.assertTrue(orderpageobj.verifyOrderDisplay(productname));	
		
		
	}
	
	
	@DataProvider
	public Object[][] getDataa()
	{
	 
		return new Object[][] {{"yiwovo8122@usharer.com","Asdfghjkl@1234","IPHONE 13 PRO"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		//object means anything,it may be string,int,double
	
	}
	
	

}
