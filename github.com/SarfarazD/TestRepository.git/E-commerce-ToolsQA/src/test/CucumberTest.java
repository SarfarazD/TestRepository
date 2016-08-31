package test;



import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class CucumberTest {
		private static WebDriver driver = null;
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
 
        driver = new FirefoxDriver();
 
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("http://himalaya:81/mwiki/QA/index.php?title=Special:Userlogin&returnto=Main_Page");
 
        // Find the element that's ID attribute is 'account'(My Account) 
 
        //driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
        // Find the element that's ID attribute is 'log' (Username)
 
        // Enter Username on the element found by above desc.
 
        driver.findElement(By.id("wpName1")).sendKeys("clarion"); 
 
        // Find the element that's ID attribute is 'pwd' (Password)
 
        // Enter Password on the element found by the above desc.
 
        driver.findElement(By.id("wpPassword1")).sendKeys("clarion");
 
        // Now submit the form. WebDriver will find the form for us from the element 
 
        driver.findElement(By.id("wpLoginattempt")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("Login Successfully");
 
        // Find the element that's ID attribute is 'account_logout' (Log Out)
 
        driver.findElement (By.xpath(".//*[@id='pt-logout']/a")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("LogOut Successfully");
 
        // Close the driver
 
        driver.quit();
 
	}
 
}