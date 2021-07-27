package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.qa.base.TestBase;

public class Careers extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 2);
	
	@FindBy(xpath="(//img[@alt='goibibo careers logo'])[2]")
	WebElement goIbiboCareersLink;
	

	public Careers() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		
	}
	
	public boolean verifyGoibiboPageLink() throws InterruptedException {
		Thread.sleep(1000);
		
		
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();

		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		//click on link that opens Link in new tab
		goIbiboCareersLink.click();
				
		//Wait for the new window or tab
		wait.until(numberOfWindowsToBe(2));
		
		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		//Wait for the new tab to finish loading content
		wait.until(titleIs("Selenium documentation")
		
		
		
	
		
		return goIbiboCareersLink.isEnabled();
	}
	
	
	
	


}
