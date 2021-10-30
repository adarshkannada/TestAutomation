package com.goibibo.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//a[text()='Careers']")
	WebElement careersLink;
	
	@FindBy(id="gosuggest_inputSrc")
	WebElement fromPlaceName;
	
	public Dashboard() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDashboardHeadingLabel() {
		return flightsPageLabel.isDisplayed();
	}
	
	public AboutUs verifyAboutUsLink() throws IOException {
		
		aboutUsLink.click();
		return new AboutUs();
		//.scrollPageUntil(aboutUsLink, driver);
		//aboutUsLink.click();
		
	}
	
	public Careers verifyCareersLink() throws IOException {
		careersLink.click();
		return new Careers();
	}
	
	public void verifyFromPlace() throws InterruptedException {
		fromPlaceName.sendKeys("Bengaluru");
		Thread.sleep(3000);
		List<WebElement> fromSearchList = driver.findElements(By.xpath("//ul[@role='listbox']//li[contains(@id,'react-autosuggest')]"));
		System.out.println(fromSearchList);
	}
}
