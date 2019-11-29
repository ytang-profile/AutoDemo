package com.sdlc.automation.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sdlc.automation.pageObjects.Careers;
import com.sdlc.automation.pageObjects.JobListing;
import com.sdlc.automation.pageObjects.Menu;
import com.sdlc.automation.util.Driver;
import com.sdlc.automation.util.ExcelUtils;
import com.sdlc.automation.util.Parameter;
import com.sdlc.automation.util.WebElementObjTool;


public class TC3KeywordSearchTestError {
	
	WebDriver driver;
	WebElementObjTool webObj;
	int tcRow;
	
	@BeforeMethod
	public void setup() throws Exception{
		
		Driver starter = new Driver();
		driver = starter.initDriver(driver, Parameter.browserType);
		webObj = new WebElementObjTool(driver);
		tcRow = 3;
	}
	
	@Test
	public void HomePageSearchKeyword() {
		try {
		//1) Homepage click on search icon
		Menu menu = new Menu(driver);
		webObj.clickOnElement(menu.cookieRejButton);
		webObj.clickOnElement(menu.menuSearchIcon);
		
		//get keyword 
		ExcelUtils.openExcelFile(Parameter.datafilePath, "Sheet1");
		String keyword = ExcelUtils.getCellData(tcRow, 3);
		//System.out.println(keyword);
		
		//2) Enter keyword  
		webObj.enterTextArea(menu.searchTextBox, keyword);
		
		//3)click on search submit button 
		webObj.clickOnElement(menu.searchSubButton);
		
		//4)get list of results 
		//Verify the results display more than 80
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(menu.resultList.get(0)));
		webObj.highlightElement(menu.resultNum);
		
		String[] resultText = menu.resultNum.getText().split(" ");
		String totalNum = resultText[resultText.length-1];
		System.out.print(totalNum);
		Assert.assertEquals(totalNum,"80", "Result Number is incorrect");
		
		//5) Write result 
		ExcelUtils.setCellData("Passed", tcRow, Parameter.resultColNum);
			
		} catch (Exception e) {	
			
			// TODO Auto-generated catch block
			ExcelUtils.setCellData("Failed", tcRow, Parameter.resultColNum);
			e.printStackTrace();
			Assert.fail();
			
		} catch (AssertionError ae) {
			
			ExcelUtils.setCellData("Failed", tcRow, Parameter.resultColNum);
			ae.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterClass
	public void cleanUp() {
		try {
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
