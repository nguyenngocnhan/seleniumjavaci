package com.qa.SeleniumJavaCI;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNgParameters {
	@Parameters({"strName"})
	@Test
	public void test(String strName){
		System.out.println("I am an " + strName);
	}
}
