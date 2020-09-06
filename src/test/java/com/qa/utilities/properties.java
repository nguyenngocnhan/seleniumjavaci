package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.qa.base.testBase;

public class properties {
	
	static Properties propConfig = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String filePath = projectPath + "\\src\\test\\configuration\\config.properties";
	
	public static void setProperties(String key, String value){
		OutputStream fos = null;
		
		
		try {
			fos = new FileOutputStream(filePath);
			propConfig.setProperty(key, value);
			propConfig.store(fos, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void getProperties(){
		InputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		try {
			propConfig.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testBase.browser = propConfig.getProperty("browser");
		testBase.urltest = propConfig.getProperty("test_url");
		}

}
