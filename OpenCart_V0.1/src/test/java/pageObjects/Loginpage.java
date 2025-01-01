package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {
	
	// here just enter the login page details like user name passwrd and button
	// validate my acc page-- use any element to identify whther the browser opens correct doc
	
	public Loginpage (WebDriver driver)
	{
		super(driver);
	}
       @FindBy(xpath="//input[@placeholder='Username']") WebElement username;
       @FindBy(xpath="//input[@placeholder='Password']" )WebElement password;
      @FindBy(xpath="//button[@type='submit']") WebElement btn;
       
  public void loginname(String name)
  {
	  username.sendKeys(name);
  }
  
  public void loginpassword(String passwrd)
  {
	  password.sendKeys(passwrd);
  }

  public void button()
  {
	  btn.click();
  }

}
