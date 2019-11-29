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
import com.sdlc.automation.pageObjects.ContactUs;
import com.sdlc.automation.pageObjects.JobListing;
import com.sdlc.automation.pageObjects.Menu;
import com.sdlc.automation.util.Driver;
import com.sdlc.automation.util.ExcelUtils;
import com.sdlc.automation.util.Parameter;
import com.sdlc.automation.util.WebElementObjTool;


public class TC2ContactUsFormTest {
	
	WebDriver driver;
	WebElementObjTool webObj;
	int tcRow;

	@BeforeMethod
	public void setup() throws Exception{
		
		Driver starter = new Driver();
		driver = starter.initDriver(driver, Parameter.browserType);
		webObj = new WebElementObjTool(driver);
		tcRow = 2;
	}
	
	@Test
	public void FillOutContactUsForm() {
		try {
			
			
		//1) Homepage click on Contact Us
		Menu menu = new Menu(driver);
		webObj.clickOnElement(menu.cookieRejButton);
		webObj.clickOnElement(menu.menuContactUs);
		
		//get test data 
		ExcelUtils.openExcelFile(Parameter.datafilePath, "Sheet1");
		String firstName = ExcelUtils.getCellData(tcRow, 3);
		String compName = ExcelUtils.getCellData(tcRow, 5);
		String comment = ExcelUtils.getCellData(tcRow, 6);
		String lastName = ExcelUtils.getCellData(tcRow, 4);
		
		//2)Fill first last name
		ContactUs contactPage = new ContactUs(driver);
		webObj.enterTextArea(contactPage.fNameField, firstName);
		webObj.enterTextArea(contactPage.lNameField, lastName);
		
		//System.out.println(keyword);
		
		//3) Fill out company name
		webObj.enterTextArea(contactPage.compNameField, compName);
		
		//4) Fill out comments 
		webObj.enterTextArea(contactPage.commentField, comment);
		
		//5)click on Submit button 
		webObj.clickOnElement(contactPage.submitButton);
		WebElementObjTool.sleep(5);
		
		//6)Verify error message displays 
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(contactPage.errorMsg));
		webObj.highlightElement(contactPage.errorMsg);
		
		Assert.assertTrue(contactPage.errorMsg.isDisplayed(),"Error validation is not displayed");
		
		
		//7) Write result 
		ExcelUtils.setCellData(Parameter.passedFlg, tcRow, Parameter.resultColNum);
			
		} catch (Exception e) {	
			
			// TODO Auto-generated catch block
			ExcelUtils.setCellData(Parameter.failedFlg, tcRow, Parameter.resultColNum);
			e.printStackTrace();
			Assert.fail();
			
		} catch (AssertionError ae) {
			
			ExcelUtils.setCellData(Parameter.failedFlg, tcRow, Parameter.resultColNum);
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
