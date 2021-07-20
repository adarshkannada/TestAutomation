package com.goibibo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException{
		
		
		prop = new Properties();
		FileInputStream config = new FileInputStream("/home/freedom/Documents/Selenium/GoIbibioTest/src/main/java/com/goibibo/qa/config/config.properties");
		prop.load(config);
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browserName");
		
			if(browserName.equals("chrome")) {
			System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")){
			System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		}
	
	}

}
