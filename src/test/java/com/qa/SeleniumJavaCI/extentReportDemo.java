package com.qa.SeleniumJavaCI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportDemo {
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
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String screenshotName = System.currentTimeMillis() + ".png";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 htmlReporter = new ExtentHtmlReporter("extent.html");
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		 test = extent.createTest("Test one","Sample description for test one");
		test.log(Status.INFO, "Start testcase");
		 String browser = "chrome";
		browser(browser);
		test.pass("Open Browser!");
		driver.get("http://localhost/shoponline/");
		test.pass("Navigate to ShopOnline");
		testLogin();
	}
	public static void testLogin() {
		// Click on My account
		WebElement linkAccount = driver.findElement(By.xpath("//a[text()='My account']"));
		linkAccount.click();
		test.pass("Navigate to My Account");
		// input username
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.clear();
		txtUsername.sendKeys("test10@gmail.com");
		test.pass("input username");
		// input password
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.clear();
		txtPassword.sendKeys("Test@gmail");
		test.pass("input password");
		// click submit
		WebElement btnSubmit = driver.findElement(By.xpath("//button[@name='login']"));
		btnSubmit.click();
		test.pass("click submit");
		// wait
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass("Wait...");
		captureScreenShot(driver, screenshotName);
		try{
			test.pass("Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());
			test.addScreenCaptureFromPath(screenshotName);
		}catch(IOException e){
			System.out.println(e.getMessage());
			 System.out.println(e.getCause());
		}
		// quit driver
		driver.quit();
		test.pass("quit driver");
		extent.flush();
	}
	
	public static void captureScreenShot(WebDriver driver, String screenshotName){
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File("D:\\workspace\\SeleniumJavaCI\\",screenshotName));
			
		}catch(IOException e){
			 System.out.println(e.getMessage());
			 System.out.println(e.getCause());
		}
	}
}
