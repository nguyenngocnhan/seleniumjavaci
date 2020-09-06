package com.qa.SeleniumJavaCI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browserStackDemo {
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String filePath = projectPath + "\\src\\test\\configuration\\config.properties";
	static String username = null;
	static String access = null;

	public static void main(String[] args) throws Exception {
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
		username = prop.getProperty("usernameBrowserStack");
		access = prop.getProperty("accessKeyBrowserStack");
		String AUTOMATE_USERNAME = username;
		String AUTOMATE_ACCESS_KEY = access;
		final String URL = "https://" + AUTOMATE_USERNAME + ":"+ AUTOMATE_ACCESS_KEY+ "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("browser", "chrome");
		caps.setCapability("browser_version", "85.0 beta");
		caps.setCapability("os", "Windows");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://localhost/shoponline/");
		By linkMyAccount = By.xpath("//a[text()='My account']");
		WebElement element = driver.findElement(linkMyAccount);
		element.click();
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
