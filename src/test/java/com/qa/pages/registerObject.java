package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerObject {
	static WebDriver driver = null;
	
	public registerObject(WebDriver driver){
		this.driver = driver;
	}
	
	//Elements
	static By txtUsername = By.id("reg_email");
	static By txtPassword = By.id("reg_password");
	static By btnRegister = By.xpath("//button[@name='register']");
	
	//Action
	static void inputUsername(String username){
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
	}
	
	static void inputPassword(String password){
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	static void clickRegister(){
		driver.findElement(btnRegister).click();
	}
	
	public void registerTest(String username, String password){
		inputUsername(username);
		inputPassword(password);
		clickRegister();
	}
}
