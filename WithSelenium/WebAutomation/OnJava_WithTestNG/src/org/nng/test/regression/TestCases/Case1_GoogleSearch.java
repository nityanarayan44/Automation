/**
 * @author Ashutosh Mishra
 * @Modified 24 Nov 2017
 */

package org.nng.test.regression.TestCases;

import org.nng.automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Case1_GoogleSearch {

	/*
	 * ==========================================================
	 * Global instances
	 * ==========================================================
	 */
		//--- #Class Objects [Includes PageObject Also]
			Driver driver = new Driver();
			Action action = new Action();
			
		//--- #Variable for this test
			String testCaseName		= "GoogleSearch_And_List_The_FirstPage_Result";
			String projectName 		= "Project1";
			String projectId 		= "prj100001";
			String testStepdesc 	= "";
			String driverPath		= "C:\\DRIVERS\\chromedriver_win32_new\\chromedriver.exe";
			String screenShotPath	= "";

	/*
	 * ==========================================================
	 * Functions for TestNG Configurations
	 * ==========================================================
	 */
		//--- BeforeClass: Initiating WebDriver	
			@BeforeClass
			public void Conf1() throws Exception{
				this.driver.getWebDriver("CHROME", this.driverPath);// Initiating webDriver
				this.driver.maximizeBrowser();						// Maximizing the Browser
			}
		//--- AfterClass: Quitting WebDriver	
			@AfterClass
			public void conf2() throws Exception{
				this.driver.quitDriver();
			}
	/*
	 * ==========================================================
	 * TESTs: Functions
	 * ==========================================================
	 */

			
		@Test(priority = 1, enabled = true)
		public void testGoogleSearch() {
			
			//TODO: Set and Send the project Info to server
			try {
				// Opening Google
					this.testStepdesc = "Opening https://www.google.co.in";
					this.driver.open("https://www.google.co.in");
				
				// Entering a keyword to search
					this.testStepdesc = "Entering a keyword to search in google";
					this.action.setElementValue(this.driver.webDriver, "name", "q", "This is Earth"+Keys.ENTER);
				
			} catch (Exception err) {
				// Take screenShot in Case of Failure.
				//ScreenShotCapture.captureScreen(driver, this.testCaseName);
				Assert.fail(this.testStepdesc + "--Failed!! ", err);
			}
		}

		/*
		 * Depended function, after priority-1
		 * --------------------------------------
		 */
		@Test(dependsOnMethods = "testGoogleSearch")
		public void collectTheSearchResult() throws Exception {
			try{
				// Wait for few
					Thread.sleep(5000);
					
				// Capturing all the result.
					this.testStepdesc = "Capturing all the search result";
					//int totalSearch = this.action.findElementWithExplicitWait(this.driver.webDriver, "xpath", "//*[@id='ires']/div/", 15);
					int totalSearch = this.driver.webDriver.findElements(By.xpath("//*[@id='ires']/div/div")).size();
					System.out.printf("Total Search Result Length: %d \n", totalSearch);
					
			} catch (Exception err) {
				// Capture the screenshot
				//ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				Assert.fail(this.testStepdesc + "--Failed!!", err);	
			}
		}

// #BOTTOM	
} /* EOClass */
