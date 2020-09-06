package com.qa.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.base.testBase;
import com.qa.pages.homepageObject;
import com.qa.pages.productDetailObject;
import com.qa.utilities.excelDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testAddToCardTestNG extends testBase {
	
	static excelDataProvider proData = new excelDataProvider();
	static String excelPath = projectPath + "/src/test/excel/data.xlsx";
	static String sheetName = "product";
	
	@DataProvider(name="testdata1")
	public static Object[][] getdata() throws IOException{
		Object data[][] = proData.testData(excelPath,sheetName);
		return data;
	}
	
	


	@Test(dataProvider="testdata1")
	public void addToCartTest(String productname, String price) throws IOException {
		System.out.println(productname +" "+ price);
		homepageObject hpObj = new homepageObject(driver);
		productDetailObject proObj = new productDetailObject(driver);
		//to home
		hpObj.clickHome();
		//Click to Album
		hpObj.clickProduct(productname);
		//get Price
		//String strPrice = proObj.getTextPrice();
		//System.out.println(strPrice);
		proObj.assertProPrice(price);
		//Add to card
		proObj.clickAddToCart();
		//Back to home
		hpObj.clickHome();
				
		//View to Cards
		proObj.clickCartContents();
		//get card prices
		String price3 = proObj.getCardsPrices();
		System.out.println(price3);
		
	}

}
