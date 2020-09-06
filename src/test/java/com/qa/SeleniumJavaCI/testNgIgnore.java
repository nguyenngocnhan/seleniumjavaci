package com.qa.SeleniumJavaCI;

import static org.junit.Assert.assertFalse;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.qa.listeners.retryAnalyzer;

public class testNgIgnore {
	
	@Test
	public void test1() {
		System.out.println("I am on test 1");
	}

	
	@Test(retryAnalyzer = retryAnalyzer.class)
	public void test2() {
		System.out.println("I am on test 2");
		assertFalse(true);
	}
	
	@Test
	public void test3() {
		System.out.println("I am on test 3");
	}

	
	@Test(retryAnalyzer = retryAnalyzer.class)
	public void test4() {
		System.out.println("I am on test 4");
		assertFalse(true);
	}
}
