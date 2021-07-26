package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;

public class AboutUs extends TestBase{


	
	@FindBy(xpath="//span[@class='lgRightSection__close']")
	WebElement closeLoginWindow;
	
	@FindBy(xpath="//a[text()='Hotels']")
	WebElement HotelsLink;
	
	public AboutUs() throws IOException {
		super();
		PageFactory.initElements(driver,this);

	}
	
	public void closeLoginWindow(){
		closeLoginWindow.click();
		
	}
	
	public void clickHotelsLink(){
		
		String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
		HotelsLink.sendKeys(clicklnk);
		
		
	}
	

}
