package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import utility.Report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UrlCheck {
	
	private ExtentReports reporter =  Report.getReporter();

@Test
	public void TestUrl()
	{
		ExtentTest testReporter = reporter.startTest("URL CHECK", "This is a simple URL Check Test Case");
		testReporter.log(LogStatus.INFO, "Starting test Execution");
		WebDriver driver =  new FirefoxDriver();
		driver.get("http://store.demoqa.com");
		testReporter.log(LogStatus.INFO, "Url is Clicked successfully");
		
		reporter.endTest(testReporter);
	}
	
}

