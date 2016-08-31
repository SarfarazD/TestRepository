package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	public WebDriver driver;
	String url = "http://store.demoqa.com/";
	
	
	@BeforeTest
	public void setup()
	{
		
		//To Open FireFox Browser
		 driver  = new FirefoxDriver();
		//Window in Maximize Mode
		driver.manage().window().maximize();
		
	}

	@Test
	public void run1()
	{
		//to open the url in browser
		driver.get(url);
		
		//Use of Click method & partialLinkText
		driver.findElement(By.partialLinkText("My Account")).click();
		//Store of Text
		WebElement text = driver.findElement(By.id("log"));
		text.sendKeys("QA");
		//Use of By.Name Locator
		WebElement text2 =  driver.findElement(By.name("pwd"));
		text2.sendKeys("QA@123");
		//Use of CSS selector & submit method
		driver.findElement(By.cssSelector("#login")).submit();
		//Use of ClassName, store & print of Text
		
		
		// Use of xPath
		driver.findElement(By.xpath(".//*[@id='meta']/ul/li[1]")).click();
		//Use of navigation
		//Takes youback by one page on the browser’s history.
		driver.navigate().back();
		//Takes you forward by one page on the browser’s history.
		driver.navigate().forward();
		
		String Current = driver.getCurrentUrl();
		System.out.println("The Current URL is :" +Current);
		
		driver.findElement(By.xpath(".//*[@id='menu-item-15']/a")).click();
		
		//driver.findElement(By.xpath(".//*[@id='slide_menu']/a[1]")).click();
		String Pro = driver.findElement(By.className("product_description")).getText();
		System.out.println("Product Desc:"+Pro);
		driver.findElement(By.partialLinkText("My Account")).click();
		//Verify Element is Enabled.
		Boolean a = driver.findElement(By.xpath(".//*[@id='login']")).isEnabled();
		if(a.TRUE)
		{
			System.out.println("Verify Element is Present & Enabled");
		}
		else
		{
			System.out.println(" Element is not Present");
		}
		 
		
		//use of TagName
		driver.findElement(By.tagName("a")).click();
			
	}
	
	
}
