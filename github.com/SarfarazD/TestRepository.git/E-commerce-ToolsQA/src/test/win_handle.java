package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class win_handle {
	
	public static void main(String[] args) 
	{
		  WebDriver driver =new FirefoxDriver();
		  driver.get("file://C:/Users/Sarfaraj%20Doni/AppData/Roaming/Skype/My%20Skype%20Received%20Files/OpenWindow.html");
		  
		  driver.findElement(By.id("numb")).sendKeys("123");
		  
		  driver.findElement(By.id("btnConfirm")).click();
		  String firstwindowHandler=driver.getWindowHandle();
		  
		  System.out.println("first window handler :" +firstwindowHandler);
		  
		  System.out.println("list of window handler :" +driver.getWindowHandles());
		  
		  for(String winHandle: driver.getWindowHandles())
		  {
		   driver.switchTo().window(winHandle);
		  }
		  driver.findElement(By.name("firstName")).sendKeys("ABCD");
		  
		  String sectwindowHandler=driver.getWindowHandle();
		  driver.switchTo().window(firstwindowHandler);
		  
		  driver.findElement(By.id("numb")).sendKeys("ghgh"); 
		  
		  
		  driver.switchTo().window(sectwindowHandler);
		  driver.findElement(By.name("firstName")).sendKeys("ffdfdf");

}
}