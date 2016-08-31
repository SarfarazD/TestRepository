package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Grid {
    // Expected Title
    private String expectedTittle = "Google11";
 
    @Test
    public void verifyTitleTest() throws MalformedURLException {
 
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox"); // chrome, iexplore
        cap.setPlatform(Platform.ANY);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
 
        // Open the website
        driver.get("https://www.google.com");
 
        // Get the actual title using selenium code
        String actualTittle = driver.getTitle();
 
        // Verify the page title using by comparison of Actual and Expected
        Assert.assertEquals(expectedTittle, actualTittle);
        System.out.println("title:" +actualTittle);
        driver.close();
    }
}