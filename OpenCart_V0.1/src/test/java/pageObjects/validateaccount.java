package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class validateaccount extends BasePage {
	
	 public validateaccount(WebDriver driver)
	    {
	    	super(driver);
	    	
	    }
	
	 @FindBy(xpath="//img[@alt='client brand banner']") WebElement visible;
	
	 @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']") WebElement logoutdrpdwn;
	 @FindBy(xpath="//a[normalize-space()='Logout']") WebElement logout;
	 
	 public boolean displayed()
	 {
		 try
		 {
		return( visible.isDisplayed());
		 }
		 catch(Exception e)
		 {
			return false;
		 }
	 }
	 public void clicklogout()
	 {
		 logoutdrpdwn.click();
		 logout.click();
	 }

}
