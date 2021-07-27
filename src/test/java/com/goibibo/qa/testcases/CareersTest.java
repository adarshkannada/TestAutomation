package com.goibibo.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.Careers;
import com.goibibo.qa.pages.Dashboard;

public class CareersTest extends TestBase{
	Dashboard dashboard;
	Careers careers;
	
	
	public CareersTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialize();
		
		dashboard = new Dashboard();
		careers = dashboard.verifyCareersLink();
		
	}
	
	@Test(priority=1)
	public void GoibiboCareersLinkEnabledTest() throws InterruptedException {
		Assert.assertTrue(careers.verifyGoibiboPageLink());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
