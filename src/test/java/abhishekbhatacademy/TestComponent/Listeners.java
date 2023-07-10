package abhishekbhatacademy.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNGException;
import org.testng.internal.ExitCode;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import abhishekbhatacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	//If we run all the testcases parallely then the "test" will  be override. So replace "test" by threads('extenttest' in this case)
    ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest> ();
	
	
	@Override
	  public void onTestStart(ITestResult result) 
	  {
	     test=extent.createTest(result.getMethod().getMethodName());
	     extenttest.set(test); //it creates a unique thread ID for each test... so that will not override when we run parallel
	  }

	  @Override
	  public void onTestSuccess(ITestResult result) 
	  {
	     extenttest.get().log(Status.PASS, "The testcase is passed!");
	  }

	  @Override
	  public void onTestFailure(ITestResult result) 
	  {
		  extenttest.get().fail(result.getThrowable());  //it will display the error message
	    
	    try 
	    {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
	    } catch (Exception e1) {
			
			e1.printStackTrace();
		} 
	    
	    
	    String filepath = null;
		try 
		{
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);   //method name from base test
		} 
		catch (IOException e) {
		
			e.printStackTrace();
		} 
		
		extenttest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	  }

	  @Override
	  public void onTestSkipped(ITestResult result) {
	    
	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }

	  @Override
	  public void onStart(ITestContext context) {
		  
	  }

	  @Override
	  public void onFinish(ITestContext context) 
	  {
		  extent.flush();
	  }


	
	
}
