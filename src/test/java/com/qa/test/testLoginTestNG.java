package com.qa.test;


import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.testBase;
import com.qa.pages.homepageObject;
import com.qa.pages.loginObject;
import com.qa.pages.myAccountObject;
import com.qa.utilities.excelDataProvider;


//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;



public class testLoginTestNG extends testBase{
	//ATUTestRecorder recorder;
	 
	static excelDataProvider proData = new excelDataProvider();
	static String excelPath = projectPath + "/src/test/excel/data.xlsx";
	static String sheetName = "login";
	
	@DataProvider(name="testdata1")
	public static Object[][] getdata() throws IOException{
		Object data[][] = proData.testData(excelPath,sheetName);
		return data;
	}
	
	@Test(dataProvider="testdata1")
	public void loginTest(String username, String password) {
		
		homepageObject hpObj = new homepageObject(driver);
		loginObject lgObj = new loginObject(driver);
		myAccountObject maObj = new myAccountObject(driver);
		
		hpObj.clickMyAccount();
		logger.info("Click to My account!");
		lgObj.loginTest(username, password);
		logger.info("Perform login form!");
		maObj.assertMyAccount(username);
		logger.info("Verify Account!");
		// wait
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maObj.clickLogout();
		logger.info("Click Logout!");

	}
	
	
}
