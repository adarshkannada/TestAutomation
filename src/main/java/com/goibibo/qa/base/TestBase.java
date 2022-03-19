package com.goibibo.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.goibibo.qa.utilties.TestUtil;
import com.goibibo.qa.utilties.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException{

		try {

			prop = new Properties();
			FileInputStream config = new FileInputStream("C:\\Project\\TestAutomation\\src\\main\\java\\com\\goibibo\\qa\\config\\config.properties");
			prop.load(config);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}

	public static void initialize() throws InterruptedException, IOException {
		String browserName = prop.getProperty("browserName");

		if(browserName.equals("chrome")) {
			//System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			//System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverPath"));
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		//create object of eventListenerHandler to register it with EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	
		Thread.sleep(2000);
	}

}