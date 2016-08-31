package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigations
{
	public static  WebDriver driver;

	@Test
	public static void Navigate()
	{
		driver = new FirefoxDriver();
		driver.get("http://lms.clariontechnologies.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Know Your Client")).click();
		String link = "http://lms.clariontechnologies.co.in/course/index.php?categoryid=63";
		driver.findElement(By.xpath(".//*[@id='inst4']/div[2]/ul/li/ul/li[2]/ul/li[3]/ul/li[1]/p/a/span")).click();
		driver.findElement(By.id("username")).sendKeys("abcdefg");
		driver.findElement(By.id("password")).sendKeys("abcdefg");
		driver.findElement(By.id("loginbtn")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().forward();
		//driver.navigate().to(link);
			}
	 


}
