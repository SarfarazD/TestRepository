package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Login_PageObjects;
import utility.Constant;
import utility.Report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest 
{
WebDriver driver;
private ExtentReports reporter =  Report.getReporter();
public String actual = "ERROR: Invalid login credentials.";

@BeforeTest
public void SetUp()
{
	driver = new FirefoxDriver();
	driver.get(Constant.url);
	driver.manage().window().maximize();
}
	
@Test
public void Login()
{
	Login_PageObjects obj = new Login_PageObjects();
	
	ExtentTest testReporter = reporter.startTest("LoginTest001", "This is a simple Login Verification Test Case");
	testReporter.log(LogStatus.INFO, "Starting test LoginTest001");
	driver.findElement(By.cssSelector(".account_icon")).click();
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	testReporter.log(LogStatus.INFO, "Click on Account Link for Login " );
	//obj.EnterUsername();
	driver.findElement(By.id("log")).sendKeys("QA");
	testReporter.log(LogStatus.INFO, "Entering UserName");
	//obj.EnterPassword();
	driver.findElement(By.id("pwd")).sendKeys("QA");
	testReporter.log(LogStatus.INFO, "Entering Password");
	//obj.ClickOnLogInButton();
	driver.findElement(By.id("login")).click();
	testReporter.log(LogStatus.INFO, "Clicked on Login_Button");
	
	String ele = driver.findElement(By.cssSelector(".response")).getText();
	
	if(actual.equals(ele))
	{
		testReporter.log(LogStatus.INFO, "Invalid User & Pwd!! Not acess " );
		System.out.println("Invalid user hence not have access for Login");
		reporter.endTest(testReporter);
	}
	

}
@AfterSuite
public void afterSuite()
{
	reporter.close();
}
}
