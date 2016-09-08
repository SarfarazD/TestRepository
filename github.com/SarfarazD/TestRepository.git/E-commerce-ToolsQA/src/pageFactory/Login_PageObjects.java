package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utility.Constant;


public class Login_PageObjects {
	
	//Author : Sarfaraz Doni   //ab dfv
	
	//Author : nish iravekar
	//date 08/09/2016
	
	@FindBy(id="log")  // nishi is here for work
	WebElement usn;
	
	@FindBy(id="pwd") 
	WebElement pwd;  
	
	//sabddaadisgbfgbfisdgbfedfiedffsefffwsws
	

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
