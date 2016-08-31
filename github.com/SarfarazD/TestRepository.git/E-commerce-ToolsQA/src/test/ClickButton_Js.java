package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ClickButton_Js {

	public static void main(String[] args) {
		
		// Click on Element using java Script Executor
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		WebElement ele = driver.findElement(By.name("btnI"));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", ele);
	}

}
