package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Loginpage;
import pageObjects.validateaccount;
import testbase.baseclass;
import utilities.dataproviders;

public class TC003_LoginDataDriven_OrangeHRM extends baseclass {
	
	
	@Test(dataProvider="logincredentials",dataProviderClass=dataproviders.class, groups= {"Regression","Master"})
	public void Verify_credentials(String name, String passwrd, String exp) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.loginname(name);
		lp.loginpassword(passwrd);
		lp.button();
		
		validateaccount validate=new validateaccount(driver);
		Boolean checkpage=validate.displayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(checkpage==true)
			{
			Assert.assertTrue(true);
			validate.clicklogout();
		   }
			
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(checkpage==true)
		{
			validate.clicklogout();
			Assert.assertTrue(false);
		
	}
	else
	{
		Assert.assertTrue(true);
	}
		Thread.sleep(8000);
}
	//Thread.sleep(5000);
	}	

}
