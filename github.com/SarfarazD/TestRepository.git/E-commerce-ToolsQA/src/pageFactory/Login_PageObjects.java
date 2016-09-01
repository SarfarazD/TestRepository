package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constant;


public class Login_PageObjects {
	
	
	//Here all the page objects available related with Login
	
	@FindBy(id="log") // commit chanes
	WebElement usn;
	
	@FindBy(id="pwd") //my changes
	WebElement pwd;  
	
	@FindBy(id="login") //                           
	WebElement send;
	
	/*public void EnterUsername(String username)
	{
		usn.clear();
		usn.sendKeys(username);
	}
	
//Enter Password
	public void EnterPassword(String password)
	{
		pwd.clear();
		pwd.sendKeys(password);
	}
	*/
	public void ClickOnLogInButton()
	{
		send.click();
	}
	
	//hard Code values
	
	public void EnterUsername()
	{
		usn.clear();
		usn.sendKeys("SARFARAZ");
	}
	
//Enter Password
	public void EnterPassword()
	{
		pwd.clear();
		pwd.sendKeys("asjhdb");
	}

}
