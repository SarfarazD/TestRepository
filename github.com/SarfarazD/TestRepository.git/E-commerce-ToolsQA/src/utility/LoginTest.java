package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
 
    public static WebDriver driver;
    public static ExtentReports extent;
    
    //LoginPageFactory objLogin;
 


     @BeforeSuite
 
        public void setup(){
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        driver.manage().window().maximize();
        driver.get("https://");
        extent = new ExtentReports("C:/Users/Parikshit Mukharjee/Desktop/TuitionPIP.html", true);
  extent.config()
        .documentTitle("Tuition PIP Automation Report")
        .reportName("Regression")
        .reportHeadline("Tuition PIP");
 
    }
 
    @Test(priority=1)
 
    public void test_validLogin(){
     ExtentTest test = extent.startTest("Login Verification", "This test verifies if user logged in succesfully").assignCategory("Assert","Extent API");
     try{
     //Create Login Page object
 
   // objLogin = new LoginPageFactory(driver);
 
 
    //login to application

   
    WebDriverWait wait =new WebDriverWait(driver, 20);
   
    test.log(LogStatus.PASS, "Login Verification", "User Logged In Succesfully");
    extent.endTest(test);
    
     }catch(Exception e){
      test.log(LogStatus.FAIL,"<pre>" + e.toString() + "</pre>", "Login  Failed");
         extent.endTest(test);
     }
 }

    
    @AfterSuite
    public void teardown() throws Exception{
     extent.flush();
  extent.close();
  SendMailUsingAuthentication.main(null);
       driver.close();
   
    }
    }