package com.sdlc.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	WebDriver driver;
	
	public ContactUs(WebDriver drv) {
		driver = drv;
		PageFactory.initElements(driver, this);
	}
	
	//opening button
    @FindBy(how = How.XPATH, using = "//a[@class='blbutton' and text()='Current Job Openings']")
	public WebElement openingButton; 
    
    //First name
    @FindBy(how = How.XPATH, using = "//*[@id='input_1_1_3']")
   	public WebElement fNameField; 
    
    //Last name
    @FindBy(how = How.XPATH, using = "//*[@id='input_1_1_6']")
   	public WebElement lNameField; 
    
    //Company name
    @FindBy(how = How.XPATH, using = "//*[@id='input_1_2']")
   	public WebElement compNameField; 
    
    //Comment text field 
    @FindBy(how = How.XPATH, using = "//*[@id='input_1_5']")
   	public WebElement commentField; 
    
    //Submit button 
    @FindBy(how = How.XPATH, using = "//*[@id='gform_submit_button_1']")
   	public WebElement submitButton; 
    
    //validation error 
    @FindBy(how = How.XPATH, using = "//div[@class='validation_error']")
   	public WebElement errorMsg; 
    
    
    
}
