package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginObject {
	static WebDriver driver = null;
	
	
	public loginObject(WebDriver driver){
		this.driver = driver;
	}
	
	//Elements
	static By txtUsername = By.id("username");
	static By txtPassword = By.id("password");
	static By btnLogin = By.xpath("//button[@name='login']");
	
	//Action
	static void inputUserName(String username){
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
	}
	
	static void inputPassword(String password){
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	static void clickSubmit(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		
		element.click();
	}
	
	public void loginTest(String username, String password){
		inputUserName(username);
		inputPassword(password);
		clickSubmit();
	}
}
