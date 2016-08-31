package test;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day5 {
	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
	}
	@Test(dataProvider = "Login")
  public void Login(String Username , String Password , String Scenario)
  {
			driver.findElement(By.xpath(".//*[@id='login-username']")).clear();
			driver.findElement(By.xpath(".//*[@id='login-passwd']")).clear();
			driver.findElement(By.xpath(".//*[@id='login-username']")).sendKeys(Username);
			driver.findElement(By.xpath(".//*[@id='login-passwd']")).sendKeys(Password);
			driver.findElement(By.xpath(".//*[@id='login-signin']")).click();
  }
	
  @DataProvider(name = "Login") 
	 
	 public static Object[][] Login_Yahoo() throws BiffException, IOException{
	  
	  String filePath = "C:/Users/Sarfaraj Doni/Documents/Login.xls";
	  
	   FileInputStream fi = new FileInputStream(filePath);
	   Workbook w = Workbook.getWorkbook(fi);
	   Sheet  s = w.getSheet("Login");
	   int rows = s.getRows();
	   int cols = s.getColumns();
	   Object[][] data =new Object[rows-1][cols];
	     
   for(int r=1;r<=rows-1;r++){
	    	 
	    	 for(int c=0;c<=cols-1;c++)
	    	 {
	    		 data[r-1][c]=s.getCell(c, r).getContents();
	    		 
	    	 }
	     }
		 
		 return data;
	 }
  
  
}
