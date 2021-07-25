package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.utilties.TestUtil;

public class Dashboard extends TestBase{

	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath="//h1[text()='Domestic and International Flights']")
	WebElement flightsPageLabel;
	
	@FindBy(xpath="//a[text()='About Us']")
	WebElement aboutUsLink;
	
	public Dashboard() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDashboardHeadingLabel() {
		return flightsPageLabel.isDisplayed();
	}
	
	public AboutUs verifyAboutUsLink() throws IOException {
		Actions act = new Actions(driver);
		act.moveToElement(aboutUsLink);
		act.click().perform();
		return new AboutUs();
		//.scrollPageUntil(aboutUsLink, driver);
		//aboutUsLink.click();
		
	}

}
