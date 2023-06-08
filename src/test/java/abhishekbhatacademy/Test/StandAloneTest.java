package abhishekbhatacademy.Test;

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

import abhishekbhatacademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver","C:\\Abhishek\\chromedriver.exe");
				//or
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();      //we have to add dependency to selenium
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
	
		
		//email=yiwovo8122@usharer.com
		//password=Asdfghjkl@1234
		
		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("yiwovo8122@usharer.com");
		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Asdfghjkl@1234");
		driver.findElement(By.cssSelector("input#login")).click();
		
	
		
		
		
		List<WebElement> allproducts=driver.findElements(By.cssSelector("div.col-sm-10"));
		
//		for(int i=0; i<=allproducts.size();i++)
//		{
//			String producttext=allproducts.get(i).findElement(By.tagName("b")).getText().trim();
//			System.out.println(producttext);
//			
//			if(producttext.equalsIgnoreCase("IPHONE 13 PRO"))
//			{
//				allproducts.get(i).findElement(By.cssSelector("button.w-10")).click();
//				break;
//			}
//			
//		}
		
		//or or or or
		
	    WebElement prod=allproducts.stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase("IPHONE 13 PRO")).findFirst().orElse(null);
		prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
		
		
		//Wait until "product added to cart" mesg is displayed
		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		 //waiting until that load becomes end while add to cart
	      waitt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	      
	      driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
	      
	      
	      
	      //checking add to cart item present in cart list
	      List<WebElement> cartitemList=driver.findElements(By.cssSelector("div.cartSection h3"));
	      
//	      for(int i=0; i<cartitemList.size();i++)
//	      {
//	    	  String textt=cartitemList.get(i).getText().trim();
//	    	  if(textt.equalsIgnoreCase("IPHONE 13 PRO"))
//	    	  {
//	    		 Assert.assertTrue(true);
//	    	  }
//	    	  
//	      }
//	      
	      boolean match=cartitemList.stream().anyMatch(s->s.getText().equalsIgnoreCase("IPHONE 13 PRO"));  //returns true if it is equal
	      Assert.assertTrue(match);
	      
	      //checkout
	      driver.findElement(By.cssSelector("div.subtotal button")).click();
	      
	      
	      
	    //  driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")).sendKeys("India");
	        //or or or
	      
	      Actions aa=new Actions(driver);
	      aa.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")),"India").build().perform();
	      
	      
	      waitt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
	      
	      driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	      
	      // Thread.sleep(3000);
	      TimeUnit.SECONDS.sleep(1);
	      
	      driver.findElement(By.cssSelector("a.action__submit")).click();
	      
	      TimeUnit.SECONDS.sleep(3);
	      
	      //Checking the display messege
	      String displaymsg = driver.findElement(By.cssSelector("h1.hero-primary")).getText().trim();
	      Assert.assertTrue(displaymsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	      
	      driver.close();
	
	}

}
