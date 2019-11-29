package com.sdlc.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JobListing {
WebDriver driver;
	
	public JobListing(WebDriver drv) {
		driver = drv;
		PageFactory.initElements(driver, this);
	}
	
	//keyword text box
    @FindBy(how = How.XPATH, using = "//input[@id='jsb_f_keywords_i']")
	public WebElement keywordTextbox; 
    
    //search button
    @FindBy(how = How.XPATH, using = "//input[@id='jsb_form_submit_i']")
	public WebElement searchButton; 
}
