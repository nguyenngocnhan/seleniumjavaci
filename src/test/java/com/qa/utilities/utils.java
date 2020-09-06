package com.qa.utilities;

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

import com.qa.base.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils extends testBase{
	
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

	public static void captureScreenShot() {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File(testBase.projectPath + "/report/" + screenshotName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}