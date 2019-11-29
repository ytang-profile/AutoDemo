package com.sdlc.automation.util;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementObjTool {
	WebDriver driver;
	
	public WebElementObjTool(WebDriver drv) {
		driver = drv;
	}

	public void enterTextArea(WebElement textarea, String text) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(textarea));
		highlightElement(textarea);
		textarea.clear();
		textarea.sendKeys(text);
		sleep(3);
	}

	
	public void clickOnElement(WebElement tab) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(tab));
		highlightElement(tab);
		tab.click();
		sleep(3);
	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void highlightElement(WebElement element) throws Exception{
		
		String org_style = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
		sleep(1);
		js.executeScript("arguments[0].setAttribute('style', '"+ org_style +"');", element);
	}
	public void switchToNewOpenWindow() {
		try {
			String mainWindow=driver.getWindowHandle();
			 System.out.println(mainWindow);
			Set<String> set =driver.getWindowHandles();
			Iterator<String> itr= set.iterator();
			
			while(itr.hasNext()){
				 String childWindow=itr.next();
				 System.out.println(childWindow);
				    // Compare whether the main windows is not equal to child window. If not equal, we will close.
				 if(!mainWindow.equals(childWindow)){
				 driver.switchTo().window(childWindow);
				 //System.out.println(driver.switchTo().window(childWindow).getTitle());
				 //driver.close();
				 }
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
