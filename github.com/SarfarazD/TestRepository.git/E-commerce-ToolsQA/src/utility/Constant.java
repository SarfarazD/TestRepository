package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class Constant {
	public WebDriver driver;
	// Property File Location
	public static final String PropertyFile = "C:\\Users\\Sarfaraj Doni\\WorkSpace\\SeleniumProject\\MagentoEccomerceSite\\src\\resources\\constants.properties";
	
	
	// Test Data or Excel Data Location
	public static final String TestdataFileLocation = "src/resources/TestData.xls";
	
	
	//Parameter used for pageObjects
	public static final int WebDriverWaitDuration= Integer.parseInt(GetPropertyValue("WebDriverWaitDuration"));
	public static final int ThreadWaitInmiliseconds= Integer.parseInt(GetPropertyValue("ThreadWaitInmiliseconds"));
	
	//Magento Environment Setup
	public static final String 	ApplicationURL= GetSysPropertyValue("ApplicationURL");
	
	public static final String url ="http://store.demoqa.com/ ";
	
	
	public static Properties prop;
	static String PropertyValue;
	
	public static String GetPropertyValue(String PropertyName) 
	
	{
		prop = AccessPropertiesFile();
		try
		{
			prop.load(new FileInputStream(PropertyFile));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return PropertyValue;
	}


	public static Properties AccessPropertiesFile()
	{
		prop = new Properties();

		// try retrieve data from file
		try 
		{

			prop.load(new FileInputStream(PropertyFile));
		}
		// catch exception in case properties file does not exist
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return prop;
	}
	
	public static String GetSysPropertyValue(String property)
	{
		String PropertyNew=System.getProperty(property);
		
		if(PropertyNew == null || PropertyNew.isEmpty()) 
		{	
			PropertyNew=GetPropertyValue(property);
		}
		return PropertyNew;
		
	}
	
	public void ToGoToUrl(String ApplicationURL) throws InterruptedException
	{
		Thread.sleep(10000);
		driver.get(ApplicationURL);
	}

}
