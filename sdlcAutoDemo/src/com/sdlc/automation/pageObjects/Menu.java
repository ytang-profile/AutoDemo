package com.sdlc.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	WebDriver driver;
	public Menu(WebDriver drv) {
		driver = drv;
		PageFactory.initElements(driver, this);
	}
	
	//cookie reject button 
    @FindBy(how = How.XPATH, using = "//*[@id=\"cookie_action_close_header_reject\"]")
	public WebElement cookieRejButton; 
    
	//Career menu
    @FindBy(how = How.XPATH, using = "//li[contains(@id, 'menu-item')]//span[contains(text(),'Careers')]")
	public WebElement menuCareer; 
    
    //Contact us menu
    @FindBy(how = How.XPATH, using = "//li[contains(@id, 'menu-item')]//span[contains(text(),'Contact Us')]")
	public WebElement menuContactUs; 
    
    //Search icon menu
    @FindBy(how = How.XPATH, using = "//ul[@id='menu-top-navigation']/li[8]/a/..")
	public WebElement menuSearchIcon; 
    
    //Search box
    @FindBy(how = How.XPATH, using = "(//input[@name='s' and contains(@placeholder,'Search')])[1]")
	public WebElement searchTextBox; 
    
    //search submit button 
    @FindBy(how = How.XPATH, using = "(//input[contains(@class,'searchsubmit')])[1]")
	public WebElement searchSubButton; 
    
    //search results list 
    @FindBy(how = How.XPATH, using = "//div[@id='posts-container']/div/article")
   	public List<WebElement> resultList; 
    
    //search result number 
    @FindBy(how = How.XPATH, using = "//p[@class='res-count']")
   	public WebElement resultNum; 
    
}
