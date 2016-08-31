package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.Login_PageObjects;
import utility.Browser;
import utility.Constant;
import utility.SendMailUsingAuthentication;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login
{

public   WebDriver driver;
public static ExtentReports extent;
public String url = "http://live.guru99.com/index.php";
public Browser b = new Browser();


@Parameters({ "browser"})
@BeforeTest
public void setUp(String browser) throws Exception 
{		
	driver= b.setup(browser);
	 extent = new ExtentReports("E://Appium//Report.html", true);
	  extent.config()
	        .documentTitle("Magento Automation Report")
	        .reportName("Regression")
	        .reportHeadline("Login Check");
	
	
}

@Test
  public void LoginCheck() throws InterruptedException
  
{
	driver.get(url);
	
	 driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
	 driver.findElement(By.xpath(".//*[@id='header-account']/div/ul/li[1]/a")).click();
	 
	 Login_PageObjects obj = new Login_PageObjects();
	
	 
	 
	 
	 ExtentTest test = extent.startTest("Login Verification", "This test verifies if user logged in succesfully").assignCategory("Assert","Extent API");
	// driver.findElement(By.id("45754email")).sendKeys("UAN");
	// driver.findElement(By.id("pass")).sendKeys("pass");
	// driver.findElement(By.id("send2")).click();
	 try{
	     
		 driver.findElement(By.id("45754email")).sendKeys("UAN");
		 driver.findElement(By.id("pass")).sendKeys("pass");
		 driver.findElement(By.id("send2")).click();
	   
	    WebDriverWait wait =new WebDriverWait(driver, 20);
	   
	    test.log(LogStatus.PASS, "Login Verification", "User Logged In Succesfully");
	    extent.endTest(test);
	    
	     }catch(Exception e){
	      test.log(LogStatus.FAIL,"<pre>" + e.toString() + "</pre>", "Login  Failed");
	         extent.endTest(test);
	     }
	 }



@AfterTest
public void TearDown() throws Exception
{
	//driver.quit();
	 extent.flush();
	  extent.close();
	//  SendMailUsingAuthentication.main(null);
	       driver.close();

}
}
