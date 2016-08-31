package test;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WinHandle {

	/*
	public static void main(String[] args) throws InterruptedException {
		// This method will print the list of windows sting unique id
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent Window : -----" +parentWin);
		WebElement clickEle = driver.findElement(By.id("button1"));
		
		for (int i =0 ; i<3 ; i++)
		{
			clickEle.click();
			Thread.sleep(3000);
		}
		
		Set<String> allWin = driver.getWindowHandles();
		for(String handle : allWin)
		{
			System.out.println("Window handle - > " + handle);
		}
	}*/
	
	
	public static void main(String[] args) throws InterruptedException
	{
 
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
		
			clickElement.click();
			Thread.sleep(3000);
		 
		Set<String> all = driver.getWindowHandles();
		for( String handle : all)
		{
		System.out.println("Window ids------" + handle);
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.id("alert")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		
		System.out.println("Alert is----"+alertText);
		}
		
		
		//driver.switchTo().window(parentWindowHandle);
		/*for(int i = 0; i < 3; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 
		Set<String> allWindowHandles = driver.getWindowHandles();
 
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://google.com");
			driver.switchTo().window(parentWindowHandle);
			
		}
 */
	}

}
