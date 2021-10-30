package com.goibibo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.goibibo.qa.utilties.TestUtil;
import com.goibibo.qa.utilties.WebEventListener;

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
			System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverPath"));
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

	public static void TakeScreenshot() {
		TakesScreenshot srcshot = ((TakesScreenshot)driver);
		File src = srcshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}