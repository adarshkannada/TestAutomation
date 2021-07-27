package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;

public class Careers extends TestBase{
	
	@FindBy(xpath="(//img[@alt='goibibo careers logo'])[2]")
	WebElement goIbiboCareersLink;
	

	public Careers() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		
	}
	
	public boolean verifyGoibiboPageLink() throws InterruptedException {
		Thread.sleep(1000);
		goIbiboCareersLink.click();
		return goIbiboCareersLink.isEnabled();
	}
	
	
	
	


}
