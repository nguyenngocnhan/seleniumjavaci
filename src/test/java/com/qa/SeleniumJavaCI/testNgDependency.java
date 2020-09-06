package com.qa.SeleniumJavaCI;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testNgDependency {
  @Test(dependsOnGroups={"regression1"})
  public void test1() {
	  System.out.println("I am on test 1");
  }
  @Test
  public void test2() {
	  System.out.println("I am on test 2");
  }
  
  @Test(groups="regression1")
  public void test3() {
	  System.out.println("I am on test 3");
  }
}
