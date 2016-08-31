package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountLink {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new FirefoxDriver();
		driver.get("http://lms.clariontechnologies.co.in");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		
		System.out.println("Total number of link = " +links.size());
		
		for (int i = 1; i<=links.size(); i++)
			 
		{
 
			System.out.println(links.get(i).getText());
 
		}
	}
	
	}
