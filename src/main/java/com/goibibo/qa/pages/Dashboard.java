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
	
	@FindBy(id ="gosuggest_inputDest")
	WebElement toPlaceName;
	
	@FindBy(id = "departureCalendar")
	WebElement departureDateField;
	
	@FindBy(id = "returnCalendar")
	WebElement returnDateField;
	
	@FindBy(id = "gi_search_btn")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='DayPicker-Week']/..//div[@class='calDate']")
	WebElement departureDate;
	
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
	
	public void verifyFromPlace(String fromPlaceNameText) throws InterruptedException {
		fromPlaceName.sendKeys(fromPlaceNameText);
		Thread.sleep(1000);
		List<WebElement> fromSearchList = driver.findElements(By.xpath("//ul[@role='listbox']//li[contains(@id,'react-autosuggest')]"));
		
		int j;
		for(j = 0; j< fromSearchList.size() - 1; j++) {
			System.out.println(fromSearchList.get(j).getText());
		}
		
		int i;
		for(i = 0; i < fromSearchList.size() - 1; i++ ) {
			
			if(fromSearchList.get(i).getText() == "Bengaluru") {
				break;
			}
		}
		
		fromSearchList.get(i).click();
		
	}
	
	public void verifyToPlace() throws InterruptedException{
		toPlaceName.sendKeys("Delhi");
		Thread.sleep(1000);
		List<WebElement> toSearchList = driver.findElements(By.xpath("//ul[@role='listbox']//li[contains(@id,'react-autosuggest')]"));
		
		int j;
		for(j = 0; j < toSearchList.size() - 1; j++) {
			System.out.println(toSearchList.get(j).getText());
		}
		
		int i;
		for(i = 0; i < toSearchList.size() - 1 ; i++) {
			if(toSearchList.get(i).getText() == "Delhi") {
				break;
			}
		}
		toSearchList.get(i).click();
	}
	
	
	
}
