package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleScript
{

	public static WebDriver driver;
	
	@BeforeClass
	public static void Browser()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public static void TestSearch() throws Exception
	{
		driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[2]")).sendKeys("Clarion");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
	}
	/*
	@AfterClass
	public static void Tear_down()
	{
		driver.close();
	}*/
}

