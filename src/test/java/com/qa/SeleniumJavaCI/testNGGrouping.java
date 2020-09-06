package com.qa.SeleniumJavaCI;

import org.testng.annotations.Test;

public class testNGGrouping {
  @Test(groups={"sanity"})
  public void test1() {
	  System.out.println("I am on test 1");
  }
  @Test(groups={"smoke"})
  public void test2() {
	  System.out.println("I am on test 2");
  }
  @Test(groups={"sanity","smoke"})
  public void test3() {
	  System.out.println("I am on test 3");
  }
  @Test(groups={"smoke"})
  public void test4() {
	  System.out.println("I am on test 4");
  }
  @Test(groups={"regression"})
  public void test5() {
	  System.out.println("I am on test 5");
  }
  @Test(groups={"regression"})
  public void test6() {
	  System.out.println("I am on test 6");
  }
  
}
