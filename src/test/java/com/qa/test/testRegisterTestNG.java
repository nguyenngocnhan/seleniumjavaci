package com.qa.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.testBase;
import com.qa.pages.homepageObject;
import com.qa.pages.myAccountObject;
import com.qa.pages.registerObject;
import com.qa.utilities.excelDataProvider;


public class testRegisterTestNG extends testBase{

	static excelDataProvider proData = new excelDataProvider();
	static String excelPath = projectPath + "/src/test/excel/data.xlsx";
	static String sheetName = "register";
	
	@DataProvider(name="testdata1")
	public static Object[][] getdata() throws IOException{
		Object data[][] = proData.testData(excelPath,sheetName);
		return data;
	}
	
	
	@Test(dataProvider="testdata1")
	public  void registerTest(String username, String password) {
		
		homepageObject hpObj = new homepageObject(driver);
		registerObject regObj = new registerObject(driver);
		myAccountObject maObj = new myAccountObject(driver);
		
		hpObj.clickMyAccount();
		logger.info("Click to My account!");
		regObj.registerTest(username, password);
		logger.info("Perform register form!");
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
