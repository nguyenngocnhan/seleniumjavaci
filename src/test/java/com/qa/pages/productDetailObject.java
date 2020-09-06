package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class productDetailObject {

	static WebDriver driver = null;

	public productDetailObject(WebDriver driver){
		this.driver = driver;
	}

	static By addToCart = By.xpath("//button[text()='Add to cart']");
	static By linkHome = By.xpath("//ul[@class='nav-menu']//a[contains(text(),'Home')]");
	static By ddColor = By.xpath("//select[@id='pa_color']");
	static By ddLogo = By.xpath("//select[@id='logo']");
	static By linkCartContents = By.xpath("//a[@class='cart-contents']");
	static By textPrice = By.xpath("//p[@class='price']");
	static By textCardsPrices = By.xpath("//tr[@class='cart-subtotal']//span");
	
	public void clickHome() {
		driver.findElement(linkHome).click();
	}

	public void clickAddToCart() {
		driver.findElement(addToCart).click();
	}
	public void clickCartContents() {
		driver.findElement(linkCartContents).click();
	}

	public void selectColor(String strColor){
		Select color = new Select(driver.findElement(ddColor));
		color.selectByVisibleText(strColor);
	}
	
	public void selectLogo(String strLogo){
		Select logo = new Select(driver.findElement(ddLogo));
		System.out.println(logo);
		logo.selectByValue(strLogo);
	}
	public String getTextPrice(){
		String strPrice = driver.findElement(textPrice).getText().toString().split("₫")[0].toString();
		//double price = Double.parseDouble(strPprice);
		return strPrice;
	}
	public String getCardsPrices(){
		String strCardsPrices = driver.findElement(textCardsPrices).getText().toString().split("₫")[0].toString();
		//double price = Double.parseDouble(strPprice);
		return strCardsPrices;
	}
	public boolean assertProPrice(String strPrice) {
		boolean ProPrice = false;
		String strExpected = strPrice;
		String strActual = driver.findElement(textPrice).getText();
		if(strActual.contains(strExpected)){
			ProPrice = true;
		}
		return ProPrice;
	}
}
