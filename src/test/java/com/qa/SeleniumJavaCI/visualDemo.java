package com.qa.SeleniumJavaCI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.qa.pages.homepageObject;
import com.qa.pages.loginObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class visualDemo {
	public static WebDriver driver = null;
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String filePath = projectPath + "\\src\\test\\configuration\\config.properties";
	static String APIKEY = null;

	public static void browser(String browserName) {
		String strBrowser = browserName.toLowerCase();
		if (strBrowser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (strBrowser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (strBrowser.contains("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (strBrowser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (strBrowser.contains("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
	}

	public static void main(String[] args) throws IOException {
		InputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		prop.load(fis);
		APIKEY = prop.getProperty("ApiKey");
		Eyes eyes = new Eyes();
		eyes.setApiKey(APIKEY);
		String browser = "chrome";
		browser(browser);
		try {
			eyes.open(driver, "Hello world!", "My first Selenium Java test", new RectangleSize(800, 600));
			driver.get("http://localhost/shoponline/");
			eyes.checkWindow("ShopOnline");
			homepageObject hpObj = new homepageObject(driver);
			loginObject lgObj = new loginObject(driver);
			hpObj.clickMyAccount();
			eyes.checkWindow("Click My Account");
			lgObj.loginTest("test200@gmail.com", "Test@gmail");
			eyes.checkWindow("Perform loign form");
			eyes.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// quit driver
		driver.quit();
	}
}
