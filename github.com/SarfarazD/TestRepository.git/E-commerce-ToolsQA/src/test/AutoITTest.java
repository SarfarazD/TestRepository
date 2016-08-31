package test;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoITTest {
	
	

	private static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {

	    driver = new FirefoxDriver();vbhvfh

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.get("http://toolsqa.com/automation-practice-form");

	    driver.findElement(By.id("photo")).click();

	    Runtime.getRuntime().exec("D:/Sarfaraz/a.exe");

	    Thread.sleep(10000);
	    
	    System.out.println("File Uploaded succssfully");

	    //driver.close();

	}

}