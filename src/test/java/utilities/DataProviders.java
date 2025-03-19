package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";//taking xl file from the testdata
		ExcelUtility xlUtil=new ExcelUtility(path);//creating the object of excel utility file
		
		int totalRowCount=xlUtil.getRowCount("Sheet1");
		int totalCellCount=xlUtil.getCellCount("Sheet1",1);
		
		String loginData[][]= new String[totalRowCount][totalCellCount];
		
		for(int i=1;i<=totalRowCount;i++)// 1 read the data from excel and storing in 2d array
		{
			for(int j=0;j<totalCellCount;j++)// 0 i is row j is column
			{
				loginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j);//1,0
			}
		}
		return loginData;
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
	

}
