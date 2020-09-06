package com.qa.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelDataProvider {
	static String projectPath = System.getProperty("user.dir");
	//static String excelPath = projectPath + "/src/test/excel/data.xlsx";
	//static String sheetName = "login";
	
	public Object[][] testData(String excelPath, String sheetName) throws IOException{
		
		excel  eObj = new excel(excelPath, sheetName);
		int rowCount = eObj.getRowCount();
		int colCount = eObj.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i = 1; i< rowCount;i++){
			for(int j =0; j< colCount;j++){
				String cellData = eObj.getCellDataString(i, j);
				System.out.println("Cel data["+i+","+j+"]:" + cellData);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
	
	/*@DataProvider(name="testdata1")
	public Object[][] getdata() throws IOException{
		Object data[][] = testData(excelPath,sheetName);
		return data;
	}
	@Test(dataProvider="testdata1")
	public void test1(String username, String password){
		System.out.println(username+ " | " + password);
	}*/
}
