package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Browser {
	WebDriver driver;
  
	
		@BeforeTest
		 
	    @Parameters("browser")
	 
	    public WebDriver setup(String browser) throws Exception{
	 
	        //Check if parameter passed from TestNG is 'firefox'
	 
	        if(browser.equalsIgnoreCase("firefox")){
	 
	        //create firefox instance
	 
	            driver = new FirefoxDriver();
	            driver.manage().window().maximize();
	            
	 
	        }
	 
	        //Check if parameter passed as 'chrome'
	 
	        else if(browser.equalsIgnoreCase("chrome")){
	 
	            //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
	 
	            System.setProperty("webdriver.chrome.driver","src\resources\\chromedriver.exe");
	 
	            //create chrome instance
	 
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	 
	        }
	 
	else if(browser.equalsIgnoreCase("ie")){
	 
	            //set path to IEdriver.exe You may need to download it from
	 
	     // 32 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_Win32_2.42.0.zip
	 
	     // 64 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_x64_2.42.0.zip
	 
	            System.setProperty("webdriver.ie.driver","src\resources\\IEdriver.exe");
	 
	            //create chrome instance
	 
	            driver = new InternetExplorerDriver();
	            driver.manage().window().maximize();
	 
	        }
	 
	        else{
	 
	            //If no browser passed throw exception
	 
	            throw new Exception("Browser is not correct");
	 
	        }
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	 
	    
  }
}
