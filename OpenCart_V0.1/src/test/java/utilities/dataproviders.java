package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataproviders {
	
	@DataProvider(name="logincredentials")
	public String[][] getData() throws IOException
	{
		String path=".\\TestData\\Reference_Data.xlsx";
		ExcelUtilities xl=new ExcelUtilities(path);
		
		int rowcount=xl.getRowCount("Sheet1");
		int colcount =xl.getCellCount("Sheet1", 1);
		
		 String logindata[][]=new String [rowcount][colcount];
	     for(int i=1;i>=rowcount;i++)
	     {
	    	 for(int j=0;j>=colcount;j++)
	    	 {
	    		 logindata[i-1][j]=xl.getCellData("Sheet1", i, j);
	    	 }
	    	 
	     }
	      
	     return logindata;
	
	
	}

}
