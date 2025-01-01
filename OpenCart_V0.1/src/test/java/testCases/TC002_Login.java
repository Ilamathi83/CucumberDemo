 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Loginpage;
import pageObjects.validateaccount;
import testbase.baseclass;

public class TC002_Login extends baseclass {
	
	@Test (groups= {"Regression","Master"})
	public void loginpage()
	{
		Loginpage lp=new Loginpage(driver);
		lp.loginname(p.getProperty("customername"));
		lp.loginpassword(p.getProperty("customerpasswrd"));
		lp.button();
		
		validateaccount validate=new validateaccount(driver);
		Boolean checkpage=validate.displayed();
		Assert.assertTrue(checkpage);
	}
	
	
}
