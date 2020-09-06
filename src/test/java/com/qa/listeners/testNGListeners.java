package com.qa.listeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.qa.base.testBase;
import com.qa.utilities.utils;
import com.relevantcodes.extentreports.LogStatus;

public class testNGListeners extends testBase implements ITestListener, ISuiteListener {

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Completed: " + context.getName());
		// calling flush writes everything to the log file
				
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Failure: " + result.getName());
		screenshotName = System.currentTimeMillis() + ".png";
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		utils.captureScreenShot();
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+ " Fail with exception: "+ result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotName));
		
		Reporter.log("<a target=\"_blank\" href=\"\\"+screenshotName+"\">Screen Short</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"\\"+screenshotName+"\"><img src=\"\\"+screenshotName+"\" height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Skips: " + result.getName());
		test.log(LogStatus.SKIP, result.getName().toUpperCase());
		rep.endTest(test);
		rep.flush();
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Started: " + result.getName());
		test = rep.startTest(result.getName().toUpperCase());
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********** Test Successed: " + result.getName());
		screenshotName = System.currentTimeMillis() + ".png";
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		utils.captureScreenShot();
		test.log(LogStatus.PASS, result.getName().toUpperCase()+ " PASS");
		test.log(LogStatus.PASS, test.addScreenCapture(screenshotName));
		
		Reporter.log("<a target=\"_blank\" href=\"\\"+screenshotName+"\">Screen Short</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"\\"+screenshotName+"\"><img src=\"\\"+screenshotName+"\" height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
	}

}
