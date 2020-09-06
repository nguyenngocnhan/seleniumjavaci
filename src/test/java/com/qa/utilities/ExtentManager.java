package com.qa.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.qa.base.*;
public class ExtentManager {
private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		if(extent == null){
			extent = new ExtentReports(testBase.projectPath + "/report/extent.html", true, DisplayOrder.OLDEST_FIRST);
			extent
            .addSystemInfo("Host Name", "Localhost")
            .addSystemInfo("Environment", "Automation Testing")
            .addSystemInfo("Author", "Nhan Nguyen")
			.addSystemInfo("3.0.0", "ExtentReport")
			.addSystemInfo("1.2.5", "Cucumber")
			.addSystemInfo("6.1.0", "Appium")
			.addSystemInfo("3.14.0", "Selenium")
			.addSystemInfo("3.3.9", "Maven");
			extent.loadConfig(new File( testBase.projectPath + "/src/test/extentconfig/ReportsConfig.xml"));
		}
		return extent;
	}
}

