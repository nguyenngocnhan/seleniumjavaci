package com.qa.SeleniumJavaCI;

import org.testng.annotations.Test;

public class testNGPriorityDemo {
  @Test(priority = 1)
  public void Demo1() {
	  System.out.println("I am on demo 1");
  }
  @Test(priority = 2)
  public void Agree() {
	  System.out.println("I am on Agree");
  }
  
  @Test(priority = 2)
  public void ASuccess() {
	  System.out.println("I am on Success");
  }
}
