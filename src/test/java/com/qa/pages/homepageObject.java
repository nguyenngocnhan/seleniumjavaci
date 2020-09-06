package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepageObject {
	static WebDriver driver = null;

	public homepageObject(WebDriver driver) {
		this.driver = driver;
	}

	static String temp = null;

	static By linkMyAccount = By.xpath("//a[text()='My account']");
	static By linkHome = By.xpath("//ul[@class='nav-menu']//a[contains(text(),'Home')]");
	static By linkCart = By.xpath("//li[@class='page_item page-item-7 focus']//a[contains(text(),'Cart')]");
	static By linkCheckOut = By.xpath("//li[@class='page_item page-item-8 focus']//a[contains(text(),'Checkout')]");
	static By linkExample = By.xpath("//li[@class='page_item page-item-2 focus']//a[contains(text(),'Sample Page')]");
	static By linkProduct = By.xpath("//h2[contains(text(),'" + temp + "')]");

	public void clickMyAccount() {
		driver.findElement(linkMyAccount).click();
	}

	public void clickHome() {
		driver.findElement(linkHome).click();
	}

	public void clickCart() {
		driver.findElement(linkCart).click();
	}

	public void clickclickMyAccount() {
		driver.findElement(linkCheckOut).click();
	}

	public void clickExample() {
		driver.findElement(linkExample).click();
	}

	public void clickProduct(String temp) {
		driver.findElement(By.xpath("//h2[contains(text(),'" + temp + "')]")).click();
	}
}
