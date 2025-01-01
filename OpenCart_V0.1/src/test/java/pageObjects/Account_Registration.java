package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration extends BasePage {
	
	public Account_Registration(WebDriver driver)
	{
		super(driver);
	}
	
	    @FindBy(id="product_549") WebElement type;
	    @FindBy(id="travname") WebElement name;
	    @FindBy(id="travlastname") WebElement lstname;
	    @FindBy(id="billing_phone") WebElement phnno;
	    @FindBy(id="order_comments") WebElement note;
	    
	    public void tickettype()
	    {
	    	type.click();
	    }
	    public void name(String customername)
	    {
	    	name.sendKeys(customername);
	    }
	    public void lastname(String customerlastname)
	    {
	    	lstname.sendKeys(customerlastname);
	    }
	    public void contactnum(String number)
	    {
	    	phnno.sendKeys(number);;
	    }
	   public void note(String optional)
	    {
		   
	    	note.sendKeys(optional);
	    }
}
