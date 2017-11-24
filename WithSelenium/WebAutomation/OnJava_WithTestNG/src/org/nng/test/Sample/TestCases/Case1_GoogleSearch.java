/**
 * @author Ashutosh Mishra
 * @Modified 24 Nov 2017
 */

package org.nng.test.Sample.TestCases;

import org.nng.automation.utils.*;
import org.nng.test.Sample.pageObjects.*;
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
			Google google = new Google();
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

		@Test
		public void f1() throws Exception {
			// Open google Search
				this.driver.webDriver = this.google.openGoogleSearch(this.driver.webDriver);
			// Search a keyword under Image category
				this.driver.webDriver = this.google.searchImage(this.driver.webDriver, "This is java");
			// Get total image count for this keyword search.
				System.out.println("Total Count: " + this.google.getTotalImageCount(this.driver.webDriver));
			//END
			return;
		}
		
// #BOTTOM	
} /* EOClass */
