package com.goibibo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.goibibo.qa.utilties.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase() throws IOException{

		try {
			
			if(System.getProperty("os.name").equals("Linux"))
			{
			prop = new Properties();
			FileInputStream config = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\goibibo\\qa\\config\\configL.properties");
			prop.load(config);
			}
			else if(System.getProperty("os.name").equals("Windows 10"))
			{
				prop = new Properties();
				FileInputStream config = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\goibibo\\qa\\config\\config.properties");
				prop.load(config);
			}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	


	public static void initialize() throws InterruptedException {
			String browserName = prop.getProperty("browserName");
		
			if(browserName.equals("chrome")) {
			System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")){
			System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			Thread.sleep(2000);

			
	}

}