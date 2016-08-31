package test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Day4 {
	
	
	//File Upload using AutoIT 
	@Test
	public void AutoIT() throws IOException, InterruptedException

	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.get("http://toolsqa.com/automation-practice-form");

	    driver.findElement(By.id("photo")).click();

	    Runtime.getRuntime().exec("D:/Sarfaraz/a.exe");

	    Thread.sleep(10000);
	    
	    System.out.println("File Uploaded succssfully");
	    driver.close();
}
	
	
		
		// File upload using Robot Class 
		@Test
		public void testUpload() throws InterruptedException
		{
			
			String path = "C:/Users/Sarfaraj Doni/Desktop/Day1.java";
			WebDriver  driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://toolsqa.com/automation-practice-form/");
			WebElement element = driver.findElement(By.name("photo"));
			element.click();
			uploadFile(path);
			Thread.sleep(2000);
		}
		
		/**
	     * This method will set any parameter string to the system's clipboard.
	     */
		public static void setClipboardData(String string) {
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		
		public static void uploadFile(String fileLocation) {
	        try {
	        	//Setting clipboard with file location
	            setClipboardData(fileLocation);
	            //native key strokes for CTRL, V and ENTER keys
	            Robot robot = new Robot();
		
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            
	        } catch (Exception exp) {
	        	exp.printStackTrace();
	        }
	   
	}
		
}
