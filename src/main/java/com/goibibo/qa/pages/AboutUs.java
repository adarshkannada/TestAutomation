package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;

public class AboutUs extends TestBase{


	
	@FindBy(xpath="//span[@class='lgRightSection__close']")
	WebElement closeLoginWindow;
	
	public AboutUs() throws IOException {
		super();
		PageFactory.initElements(driver,this);

	}
	
	public void closeLoginWindow(){
		closeLoginWindow.click();
		
	}
	

}
