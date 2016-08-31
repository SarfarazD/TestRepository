package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "src/BrowserDriver/chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://dev.cttransit.webship.com/");
		
		driver.findElement(By.xpath(".//*[@id='edit-trip-planner-date']")).click();
		
		for ( int i =0;i<2;i++)
		{
			driver.findElement(By.xpath("html/body/div[2]/div/div[1]/table/thead/tr[1]/th[3]")).click();
			Thread.sleep(1000);
		}

		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepicker']//td"));
		
		int date_count = dates.size();
		
		for(int i=0; i<date_count;i++)
		{
			String date = dates.get(i).getText();
			
			if(date.equalsIgnoreCase("15"))
			{
				String text1 =driver.findElement(By.cssSelector("body > div:nth-child(11) > div > div.datepicker-days > table > thead > tr:nth-child(1) > th.switch")).getText();
				System.out.println("Month & Year:" +text1);
				dates.get(i).click();
				System.out.println("Date selected:"+date);
				
				break;
			}
		}
	}

}
