package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	
	

	
	@Test
	public void HandleDropDown()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='continents']")).click();
		Select ele = new Select( driver.findElement(By.name("continents")));
		ele.selectByVisibleText("Antartica");
		System.out.println("Selected Antartica using Visible Text");
		//driver.findElement(By.xpath(".//*[@id='continents']")).click();
		//ele.selectByIndex(1);
		//System.out.println("Selected Asia using Value");
		driver.close();
		
	
	}
	
	@Test
	public void HandleAlert_Window() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
 
		for(int i = 0; i < 3; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 
		Set<String> allWindowHandles = driver.getWindowHandles();
 
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to Alert Page");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.findElement(By.id("alert")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		
		System.out.println("Alert is----"+alertText);
		
		driver.close();
		}
		
		
	}
	
	@Test
	public void handleFrame()
	
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/iframe-practice-page/");
	
	
		WebElement iframeElement = driver.findElement(By.id("IF1"));
		driver.switchTo().frame(iframeElement);
		driver.findElement(By.xpath(".//*[@id='content']/form/fieldset/div[1]/input[1]")).sendKeys("Test User");
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeElement).close();
		driver.close();
		
	}
	
	@Test
	public void handleTables()
	
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-table");
	
	
		
		//Here we are storing the value from the cell in to the string variable
		String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[1]")).getText();
		System.out.println(sCellValue);
		
		driver.close();
	}
	
	
	

}
