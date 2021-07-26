package com.goibibo.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.AboutUs;
import com.goibibo.qa.pages.Dashboard;

public class AboutUsTest extends TestBase{
	
	Dashboard dashboard;
	AboutUs aboutUs;
	
	public AboutUsTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialize();
		
		dashboard = new Dashboard();
		aboutUs = dashboard.verifyAboutUsLink();
	}
	
	@Test
	public void closeLoginWindowTest(){
		aboutUs.closeLoginWindow();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	


}
