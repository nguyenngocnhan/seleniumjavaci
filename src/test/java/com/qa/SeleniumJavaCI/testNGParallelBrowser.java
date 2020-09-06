package com.qa.SeleniumJavaCI;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;

public class testNGParallelBrowser {
	static WebDriver driver = null;

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

	
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			browser(browserName);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			browser(browserName);
		} else if (browserName.equalsIgnoreCase("ie")) {
			browser(browserName);
		} else if (browserName.equalsIgnoreCase("edge")) {
			browser(browserName);
		}
		driver.get("https://localhost/shoponline/");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
