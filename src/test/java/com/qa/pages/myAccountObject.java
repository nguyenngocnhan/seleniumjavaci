package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class myAccountObject {
	static WebDriver driver = null;

	public myAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	static By linkDashBoard = By.xpath("//a[contains(text(),'Dashboard')]");
	static By linkOrders = By.xpath("//a[contains(text(),'Orders')]");
	static By linkDownloads = By.xpath("//a[contains(text(),'Downloads')]");
	static By linkAddresses = By.xpath("//a[contains(text(),'Addresses')]");
	static By linkLogout = By.xpath("	//a[contains(text(),'Logout')]");
	static By linkAccountDetails = By.xpath("//a[contains(text(),'Account details')]");
	static By textMyAccount = By.xpath("	//div[@id='content']//p[1]");

	public void clickDashBoard() {
		driver.findElement(linkDashBoard).click();
	}

	public void clickOrders() {
		driver.findElement(linkOrders).click();
	}

	public void clickDownloads() {
		driver.findElement(linkDownloads).click();
	}

	public void clickAddresses() {
		driver.findElement(linkAddresses).click();
	}

	public void clickAccountDetails() {
		driver.findElement(linkAccountDetails).click();
	}

	public void clickLogout() {
		driver.findElement(linkLogout).click();
	}

	public boolean assertMyAccount(String strUsername) {
		boolean myAccount = false;
		String[] words = strUsername.split("@");
		String strExpected = "Hello " + words;
		String strActual = driver.findElement(textMyAccount).getText();
		if(strActual.contains(strExpected)){
			myAccount = true;
		}
		return myAccount;
	}
}
