package com.goibibo.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.AboutUs;
import com.goibibo.qa.pages.Dashboard;
import com.goibibo.qa.utilties.TestUtil;
import com.goibibo.qa.utilties.VerifyBrokenLinks;


public class DashboardTest extends TestBase{

	Dashboard dashboard;
	AboutUs aboutUs;
	
	static Logger log = LogManager.getLogger(DashboardTest.class);
	//PropertyConfigurator.configure("C:\\Project\\TestAutomation\\src\\main\\resources\\log4j.properties");
	static List<WebElement> activeLinkImage = new ArrayList<WebElement>();

	public DashboardTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialize();
		
		dashboard = new Dashboard();
	}
	
	@Test(priority=1)
	public void clickAboutUsPageLinkTest() throws IOException {
		//aboutUs = dashboard.verifyAboutUsLink();
		
		log.error("the is correct");
		log.debug("check this");
		log.info("the power");
		
		List<WebElement> pageLinks = driver.findElements(By.tagName("a"));
		pageLinks.addAll(driver.findElements(By.tagName("img")));
		
		int totalLinksAndImages = pageLinks.size();
		System.out.println("Total links and images are " + totalLinksAndImages);
		
		VerifyBrokenLinks verifyBrokenLinks = new VerifyBrokenLinks();
		
		for(int i = 0; i< pageLinks.size(); i++) {
			WebElement ele = pageLinks.get(i);
			String url = ele.getAttribute("href");
			verifyBrokenLinks.checkBrokenLinks(url);
		}
		
		
	}
	
	@Test(priority=2)
	@Parameters ({"fromPlaceListText"})
	public void fromPlaceListTest(String fromPlaceNameText) throws InterruptedException {
		
		dashboard.verifyFromPlace(fromPlaceNameText);
		
	}
	
	@Test(priority=3)
	public void toPlaceNameTest() throws InterruptedException{
		dashboard.verifyToPlace();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
