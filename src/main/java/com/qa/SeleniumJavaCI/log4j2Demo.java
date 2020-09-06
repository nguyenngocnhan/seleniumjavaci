package com.qa.SeleniumJavaCI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j2Demo {

	private static Logger logger = LogManager.getLogger(log4j2Demo.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n Hello world...!\n");
		logger.info("This is information message!");
		logger.error("This is error message!");
		logger.warn("This is warn message!");
		logger.fatal("This is fatal message!");
		System.out.println("\nCompleted..!\n");
	}

}
