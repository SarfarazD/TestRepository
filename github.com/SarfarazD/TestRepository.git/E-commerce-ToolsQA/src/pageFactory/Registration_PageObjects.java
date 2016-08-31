package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_PageObjects {
	
@FindBy(id = "user_login")
WebElement name;

public void EnterUsername()
{
	name.clear();
	name.sendKeys("a");
}


@FindBy(id = "user_email")
WebElement email;

public void EnterEmail()
{
	email.clear();
	email.sendKeys("sarfaraz");
}

@FindBy(id = "aiowps-captcha-answer")
WebElement pwd;

public void EnterPassword()
{
	pwd.clear();
	pwd.sendKeys("sarfaraz");
}

@FindBy(id = "wp-submit")
WebElement sub;
public void SubmitRegistration()
{
	sub.click();
	
}


}
