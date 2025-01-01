package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver); // initiating driver keyword from parent class
	}
	
    @FindBy(id="menu-item-574") WebElement buynow;
   //@FindBy(xpath="//a[normalize-space()='Register']") WebElement reg;

 public void clickbuy()
{
	buynow.click();
}

/**  public void clickreg()
{
	reg.click();
}**/
}
