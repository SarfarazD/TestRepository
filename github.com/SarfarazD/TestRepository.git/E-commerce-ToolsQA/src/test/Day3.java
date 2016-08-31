package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Utility;

public class Day3 {
	
	public static WebDriver driver;
	
	ExtentReports report;
	ExtentTest logger;
	
	// Use of MouseOverAction using Actions class
	//Use of Explicit wait
	@Test
	public void MouseOverAction()

	{
		
		report = new ExtentReports("E:\\Testing\\Report\\Suite.html", true);
		logger =report.startTest("RegressionTest");
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://store.demoqa.com/products-page/your-account/");
		logger.log(LogStatus.INFO, "Browser and application Url is up and Running");
		
		//Use of Explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
        
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Product Category")));
 
        //WebElement element = driver.findElement(By.linkText("Product Category"));
 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        driver.findElement(By.linkText("iPadss")).click();
        logger.log(LogStatus.PASS, "Mouse hover action performed!!");
  
        
       // driver.close();
}
	
	//Drag and drop using Actions class methods.
	//Use of Implicit wait
	/*@Test
	public void DragAndDrop()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/products-page/your-account/");
		driver.manage().window().maximize();
		
		//Use of Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.xpath(".//*[@id='header_cart']/a"));
		WebElement to = driver.findElement(By.name("s"));
		
		Actions builder = new Actions(driver);
		 
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		 
		dragAndDrop.perform();
		System.out.println("Drag & Drop Performed!!");
	}*/
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String screenPath = Utility.captureScreenshot(driver, result.getName());
		String image = logger.addScreenCapture(screenPath);
		logger.log(LogStatus.FAIL, "MouseHover Action",image);
	}
	 
	 report.endTest(logger);
	 report.flush();
	 driver.get("E:\\Testing\\Report\\Suite.html");
	 
	}
}