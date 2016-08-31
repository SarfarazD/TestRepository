package test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyLinks {
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tp-automation.aws-staging.diamondmindinc.com/site");
		driver.findElement(By.id("LoginForm_username")).sendKeys("dhee@g.com");
		driver.findElement(By.id("LoginForm_password")).sendKeys("Dheeraj1");
		driver.findElement(By.name("yt0")).click();
		Thread.sleep(1000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement ele= links.get(i);
			String url=ele.getAttribute("href");
			verifyLinkActive(url);	
		}
	}
	public static void verifyLinkActive(String linkUrl){
       	try
 {
           		URL url = new URL(linkUrl);
     HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
          httpURLConnect.setConnectTimeout(10000);
            httpURLConnect.connect();
           if(httpURLConnect.getResponseCode()==200||httpURLConnect.getResponseCode()==100)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
        	  //if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_INTERNAL_ERROR)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
 }
          catch(Exception e)
          {
        	  }
          
 }
          }
