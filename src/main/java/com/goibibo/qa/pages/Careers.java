package com.goibibo.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.qa.base.TestBase;

public class Careers extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 2);
	
	@FindBy(xpath="//a[text()='Careers']") //older xpath-(//img[@alt='goibibo careers logo'])[2]
	WebElement goIbiboCareersLink; 
	

	public Careers() throws IOException {
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		
	}
	
	public void verifyGoibiboCareersPageLink() throws InterruptedException {
		Thread.sleep(1000);
		
		String parentWindowHandle = driver.getWindowHandle(); //Store the ID of the original window
		System.out.println(parentWindowHandle);
		
//		goIbiboCareersLink.click(); //click on some link on the newly opened tab
		Set<String> allWindowHandles = driver.getWindowHandles(); //get the handles of all the windows that are currently open using the command
		System.out.println(allWindowHandles);
		
		Iterator<String> checkAllWindows = allWindowHandles.iterator(); // Now iterate using Iterator
		while(checkAllWindows.hasNext()) {
			String childWindow = checkAllWindows.next();
			
			if(!parentWindowHandle.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindowHandle);
		//return goIbiboCareersLink.isEnabled();
	}
	
	
	
	


}
