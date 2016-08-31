package test;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class win2 {

public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "src/BrowserDriver/chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		String parent_window = driver.getWindowHandle();
		
		System.out.println("Parent Window: " +parent_window);
		 driver.findElement(By.xpath(".//*[@id='button1']")).click();;
		 driver.manage().window().maximize();
		 
		//Set<String> C_W = driver.getWindowHandles();
		 
		for(String child : driver.getWindowHandles())
		
		{
		if(!parent_window.equals(child))
		{
			
		driver.switchTo().window(child);
	}

	}
}
}
