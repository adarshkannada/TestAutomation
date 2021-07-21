package com.goibibo.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.AboutUs;
import com.goibibo.qa.pages.Dashboard;


public class DashboardTest extends TestBase{

	Dashboard dashboard;
	AboutUs aboutUs;

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
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
