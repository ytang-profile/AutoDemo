package com.sdlc.automation.util;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Driver {
	
	WebDriver driver;
	String screenshotPath;
	
	public WebDriver initDriver(WebDriver browserDriver, String browserType) throws Exception {
		driver = browserDriver;
		setUpdriver(browserType);
			
		return driver;
	}
	
	private void setUpdriver(String browser) throws Exception {
        switch (browser.toLowerCase()) {
        case "ie":
               DesiredCapabilities iecapab = DesiredCapabilities.internetExplorer();
               iecapab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
               // driver = new
               // InternetExplorer32Selenium().getTunedWebDriver(completeWebDriverPath,
               // 10);
               //driver = new RemoteWebDriver(new URL(TestAutomationII.sessionURL), iecapab);
               driver = new RemoteWebDriver(new URL(Parameter.URL), iecapab);
               break;
        case "chrome":
        	   System.setProperty("webdriver.chrome.driver", Parameter.directory + "/lib/chromedriver.exe");
               ChromeOptions chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("--start-maximized");
               chromeOptions.addArguments("--ignore-certificate-errors");
               chromeOptions.addArguments("--disable-popup-blocking");
               // chromeOptions.addArguments("--restore-last-session");
               DesiredCapabilities capabilities = DesiredCapabilities.chrome();
               capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
               
               // driver = new
               // ChromeSelenium().getTunedWebDriver(completeWebDriverPath, 10,
               // capabilities);
               // driver = new
               // ChromeSelenium().getTunedWebDriver(completeWebDriverPath, 10);
               // driver = new
               // ChromeSelenium().getTunedWebDriver(C:\Users\lidbukx\Desktop\scrap\TestChrome\li\chromedriver.exe,
               // 10);
              //driver = new RemoteWebDriver(new URL(TestAutomationII.sessionURL), capabilities);
              
               driver = new ChromeDriver(capabilities);
               driver.get(Parameter.URL);
               driver.manage().window().maximize();
               break;
        case "phantomjs":
               // driver = new
               // PhantomJSSelenium().getTunedWebDriver(completeWebDriverPath, 10);

               // DesiredCapabilities caps = new DesiredCapabilities();
               // String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE"
               // };
               // caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
               // phantomArgs);
               // driver = new
               // PhantomJSSelenium().getTunedWebDriver(completeWebDriverPath, 10,
               // caps);

               driver = new RemoteWebDriver(new URL(Parameter.URL), DesiredCapabilities.phantomjs());
               break;
        case "firefox":

               DesiredCapabilities fireFoxcapab = DesiredCapabilities.firefox();
               fireFoxcapab.setAcceptInsecureCerts(true);
               driver = new RemoteWebDriver(new URL(Parameter.URL),fireFoxcapab);
               
               //driver = new RemoteWebDriver(new URL(Parameter.URL), firefoxCapabs);
               break;
        }
        driver.manage().deleteAllCookies();

 }
 

}
