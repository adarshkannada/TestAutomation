package com.goibibo.qa.testcases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.AboutUs;
import com.goibibo.qa.pages.Dashboard;


public class DashboardTest extends TestBase{

	Dashboard dashboard;
	AboutUs aboutUs;
	
	static Logger log = LogManager.getLogger(DashboardTest.class);
	//PropertyConfigurator.configure("C:\\Project\\TestAutomation\\src\\main\\resources\\log4j.properties");

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
		aboutUs = dashboard.verifyAboutUsLink();
		
		log.error("the is correct");
		log.debug("check this");
		log.info("the power");
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
