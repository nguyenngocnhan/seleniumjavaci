package com.qa.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.SeleniumJavaCI.log4j2Demo;
import com.qa.utilities.ExtentManager;
import com.qa.utilities.properties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class testBase {
	public static WebDriver driver = null;
	properties readConfig = new properties();
	public static Logger logger = LogManager.getLogger(log4j2Demo.class);
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String screenshotName = null;
	Properties propConfig = new Properties();
	public static String browser = null;
	public static String urltest = null;
	public static String projectPath = System.getProperty("user.dir");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp(){
		
		properties.getProperties();
		
		com.qa.utilities.utils.browser(browser);
		logger.info("Browser started!");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		driver.get(urltest);
		logger.info("Navigater to " + urltest);
	}
	@AfterSuite
	public void tearDown(){
		if(driver!=null){
			driver.quit();
		}
		logger.debug("Test executed completed!!!!");
	}
}
