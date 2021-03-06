package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.qa.pages.homepageObject;
import com.qa.pages.loginObject;
import com.qa.pages.registerObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testRegister {
	public static WebDriver driver = null;

	public static void browser(String browserName) {
		String strBrowser = browserName.toLowerCase();
		if(strBrowser.contains("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(strBrowser.contains("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(strBrowser.contains("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(strBrowser.contains("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(strBrowser.contains("opera")){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		registerTest();
	}

	public static void registerTest() {
		String browser = "chrome";
		browser(browser);
		driver.get("http://localhost/shoponline/");

		homepageObject hpObj = new homepageObject(driver);
		registerObject regObj = new registerObject(driver);
		hpObj.clickMyAccount();
		regObj.registerTest("test11@gmail.com", "Test@gmail");
		// wait
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// quit driver
		driver.quit();
	}
}
