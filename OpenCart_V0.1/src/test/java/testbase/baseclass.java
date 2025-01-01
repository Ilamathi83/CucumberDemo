package testbase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseclass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"Regression", "Sanity", "Master"})
	@Parameters({"os","browser"})
	
	public void openbrowser( String os, String br) throws IOException
	 {
		// loading config.properties
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setPlatform(Platform.WIN11);
			//os
			if(os.equalsIgnoreCase("Windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			// browser
			
			switch(br.toLowerCase())
			{
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case "chrome":capabilities.setBrowserName("chrome");break;
			default:System.out.println("No matching browser");return;
			}
			driver=new RemoteWebDriver(new URL(" http://192.168.1.4:4444"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "edge":driver=new EdgeDriver();break;
			case "chrome":driver=new ChromeDriver();break;
			default : System.out.println("Invalid browser name.."); return;
			}
			
		}
		
		

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	 }
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	 public String randomalphabetic()
	 {
		String GeneratedString= RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	 }
	 public String randomnumeric()
	 {
		String Generatednumber= RandomStringUtils.randomNumeric(10);
		return Generatednumber;
	 }
	 public String randomalphanumeric()
	 {
		String alpha= RandomStringUtils.randomAlphabetic(5);
		String beta=RandomStringUtils.randomNumeric(3);
		return(alpha+"@"+beta);
	 }
	 

	 

}
