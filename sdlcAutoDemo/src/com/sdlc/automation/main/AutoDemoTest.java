package com.sdlc.automation.main;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sdlc.automation.test.TC1KeywordSearchTest;

public class AutoDemoTest {
	
	@Test(priority = 0) // LOGIN
	public void tC1KeywordSearch() throws Exception {
		TC1KeywordSearchTest script = new TC1KeywordSearchTest();
		script.HomePageSearchKeyword();
		
	}
	
	@Test(priority = 1) // LOGIN
	public void tC2ContactUsForm() throws Exception {

		
	}
	
	@Test(priority = 2) // LOGIN
	public void tC3KeywordSearchError() throws Exception {

		
	}

}
