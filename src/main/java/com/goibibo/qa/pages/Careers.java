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
	
	@FindBy(xpath="(//img[@alt='goibibo careers logo'])[2]")
	WebElement goIbiboCareersLink;
	

	public Careers() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		
	}
	
	public void verifyGoibiboPageLink() throws InterruptedException {
		Thread.sleep(1000);
		
		
		//Store the ID of the original window
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);

		//Check we don't have other windows open already
		//assert driver.getWindowHandles().size() == 1;
		
		//click on link that opens Link in new tab
		//goIbiboCareersLink.click();
				
		//get the handles of all the windows that are currently open using the command
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);
		
		// Now iterate using Iterator
		Iterator<String> checkAllWindows = allWindowHandles.iterator();
		
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
