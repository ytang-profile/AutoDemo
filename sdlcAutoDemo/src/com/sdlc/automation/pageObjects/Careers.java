package com.sdlc.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Careers {
	WebDriver driver;
	
	public Careers(WebDriver drv) {
		driver = drv;
		PageFactory.initElements(driver, this);
	}
	
	//opening button
    @FindBy(how = How.XPATH, using = "//a[@class='blbutton' and text()='Current Job Openings']")
	public WebElement openingButton; 
}
