package com.qa.SeleniumJavaCI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBrowser {

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
		String browser = "chrome";
		browser(browser);
		driver.get("http://localhost/shoponline/");
		testLogin();
		//testRegister();
	}

	public static void testLogin() {
		// Click on My account
		WebElement linkAccount = driver.findElement(By.xpath("//a[text()='My account']"));
		linkAccount.click();
		// input username
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.clear();
		txtUsername.sendKeys("test10@gmail.com");
		// input password
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.clear();
		txtPassword.sendKeys("Test@gmail");
		// click submit
		WebElement btnSubmit = driver.findElement(By.xpath("//button[@name='login']"));
		btnSubmit.click();
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

	public static void testRegister() {
		// Click My account
		WebElement linkAccount = driver.findElement(By.xpath("//a[text()='My account']"));
		linkAccount.click();
		// Input email register
		WebElement txtRegEmail = driver.findElement(By.id("reg_email"));
		txtRegEmail.clear();
		txtRegEmail.sendKeys("test10@gmail.com");
		// Input password register
		WebElement txtRegPassword = driver.findElement(By.id("reg_password"));
		txtRegPassword.clear();
		txtRegPassword.sendKeys("Test@gmail");
		// Click register button
		WebElement btnRegister = driver.findElement(By.xpath("//button[@name='register']"));
		btnRegister.click();
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
