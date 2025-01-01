package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Account_Registration;
import pageObjects.HomePage;
import testbase.baseclass;

public class TC001_AccountRegistration extends baseclass {

	
	@Test( groups= {"Regression","Master"})
	public void registration() throws InterruptedException 
	{
		
		logger.info("hi ilamathi... test case started");
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickbuy();
		logger.info("proceeded to buy ticket");
		//hp.clickreg();
		
		 Account_Registration accreg=new  Account_Registration(driver);
		 logger.info("entering ticker booking details");
		 
		 accreg.tickettype();;
		 accreg.name(randomalphabetic());
		 accreg.lastname(randomalphabetic());
		 accreg.contactnum(randomnumeric());
		 accreg.note(randomalphanumeric());
		
		 Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			logger.error("Test failed..");
			logger.debug("debug logs...");
			Assert.fail();
		}
	}


}
