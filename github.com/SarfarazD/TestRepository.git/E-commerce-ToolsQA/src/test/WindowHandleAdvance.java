package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandleAdvance {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "src/BrowserDriver/chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent Window: " +parent_window);
		 driver.findElement(By.xpath(".//*[@id='button1']")).click();;
		 driver.manage().window().maximize();
		Set<String>s1=driver.getWindowHandles();
		 
		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		 
		while(I1.hasNext())
		{
		 
		   String child_window=I1.next();
		 
		// Here we will compare if parent window is not equal to child window then we  will close
		 
		if(!parent_window.equals(child_window))
		{
			System.out.println("Child Window: " +child_window);
			driver.switchTo().window(child_window);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='main-nav']/li[2]/a/span")).click();
			//driver.findElement(By.xpath(".//*[@id='dl-menu']/div/ul/li[2]/a/span")).click();
			driver.switchTo().window(parent_window);
			driver.get("http://google.com");
			driver.switchTo().window(child_window);
			driver.get("http://learn-automation.com/");
			driver.close();
			driver.switchTo().window(parent_window);
			driver.close();
		}
		
	
	}

	}
}
