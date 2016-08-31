package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeMyTrip {
	public WebDriver driver;
	String url = "http://www.makemytrip.com";
	
	
	@BeforeTest
	public void setup()
	{
		
		//To Open FireFox Browser
		 driver  = new FirefoxDriver();
		//Window in Maximize Mode
		 driver.get(url);
		driver.manage().window().maximize();
		
	}
	/*
	@AfterTest
	
	public void Down()
	{
		driver.close();
	}
*/
	
	/*
	@Test
	public void Testrun1() throws Exception, IndexOutOfBoundsException
	{
		
		Robot r = new Robot();
		driver.findElement(By.xpath(".//*[@id='dwnApp_save_closeIcon']")).click();
		//driver.findElement(By.cssSelector(".flgh_pic.tab_icn")).click();
		driver.findElement(By.cssSelector("#one_way_button1 > span")).click();
		
		driver.findElement(By.cssSelector("#from_typeahead1")).clear();
		WebElement from = driver.findElement(By.cssSelector("#from_typeahead1"));
		from.sendKeys("P");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		
		
		
		
		
		driver.findElement(By.cssSelector("#to_typeahead1")).clear();
		WebElement to = driver.findElement(By.cssSelector("#to_typeahead1"));
		to.sendKeys("M");
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.cssSelector("#start_date_sec")).click();
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-hover")).click();
		driver.findElement(By.xpath(".//*[@id='start_date_sec']/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[6]/a")).click();
		
		for(int i=0 ; i<=2; i++)
		{
			driver.findElement(By.xpath(".//*[@id='adult_count']/a[2]")).click();
		}
		
		Thread.sleep(3000);
		/*
		WebElement element=driver.findElement(By.cssSelector("#prefferedAirline"));
		Select se=new Select(element);
		se.selectByValue("6E");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='flights_submit']")).click();
		  Thread.sleep(3000);
		
		
		
			
			WebElement p = driver.findElement(By.xpath(".//*[@id='widget_row']/div[1]/div/div[2]/ul/li[3]/a"));
			Actions act=new Actions(driver);
			act.contextClick(p).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
			
			
			
			   for (String winHandle : driver.getWindowHandles())
			    
			    { 
				   
			        System.out.println(winHandle);
			        driver.switchTo().window(winHandle);      // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
			    }
			
			   
			    
		driver.findElement(By.cssSelector(".ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all.ui-state-hover")).click();
		driver.close();
	}
	*/
	@Test
	public void FrameCheck()
	{
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(WebElement el : ele){
	      //Returns the Id of a frame.
	        System.out.println("Frame Id :" + el.getAttribute("id"));
	      //Returns the Name of a frame.
	        System.out.println("Frame name :" + el.getAttribute("name"));
	    }
	    
	    driver.findElement(By.tagName("res_iframe")).click();
		driver.switchTo().frame("res_iframe");
	}
}