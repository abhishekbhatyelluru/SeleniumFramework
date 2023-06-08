package abhishekbhatacademy.TestComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import abhishekbhatacademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	
	public WebDriver initailizeDriver() throws IOException
	{
		
		//properties class
		Properties  prop =new Properties();	
	//	prop.load(null);   To load the properties we need the file input stream not the direct path....So first convert to fileinputstream
	
		//	FileInputStream fis=new FileInputStream("C:\\Users\\ei13065\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\abhishekbhatacademy\\resources\\GlobalData.properties");
	    //In the above line file name is too long and its my local system path..It will shows error if we run in other system
		//so we use "user.dir" that will identify the project path itself...So that this code can be run in any machine
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\abhishekbhatacademy\\resources\\GlobalData.properties");
		
		prop.load(fis);
		
		String browserName =prop.getProperty("browser");
		
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();     //we have to add dependency to selenium
			driver=new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox code
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public LandingPage launchApplication() throws IOException
	{
		
		driver=initailizeDriver();
		LandingPage landing=new LandingPage(driver);
		landing.goTo();
		return landing;
	}
	@AfterMethod(alwaysRun = true)  //for all the groups it will run 
	public void closeDriver()
	{
		driver.close();
	}
	


}
