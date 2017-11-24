/**
 * @author Ashutosh Mishra
 * @Modified 24 Nov 2017
 */

package org.nng.test.Sample.TestCases;

// Log
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.nng.automation.utils.*;
import org.nng.utils.*;
import org.nng.test.Configurations.Constants;
import org.nng.test.Sample.pageObjects.*;
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
			Files files = null;
			Logger log = Logger.getLogger(Case1_GoogleSearch.class);
			
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
				// Logging
					String log4jConfPath = "log4j.properties";
					PropertyConfigurator.configure(log4jConfPath);
					log.info("Initiating the Class");
				// Files
					files = new Files(Constants.testOutput + "GoogleImageSearchResult.txt");
				// WebDriver
					this.driver.getWebDriver("CHROME", this.driverPath);// Initiating webDriver
					this.driver.maximizeBrowser();						// Maximizing the Browser
			}
		//--- AfterClass: Quitting WebDriver	
			@AfterClass
			public void conf2() throws Exception{
				log.info("Dumping the Class");
				this.driver.quitDriver();
			}
	/*
	 * ==========================================================
	 * TESTs: Functions
	 * ==========================================================
	 */

		@Test
		public void f1() throws Exception {
			log.warn("Initiating Test..........");
			// Open google Search
				this.driver.webDriver = this.google.openGoogleSearch(this.driver.webDriver);
			// Search a keyword under Image category
				this.driver.webDriver = this.google.searchImage(this.driver.webDriver, "This is java");
			// Get total image count for this keyword search.
				System.out.println("Total Count: " + this.google.getTotalImageCount(this.driver.webDriver));
				
			// Take all the Image Sources and write them to test-output
				log.info("Writing Output file under test-output");
				for(String src : this.google.getallImageSourceList(this.driver.webDriver)) {
					if(files != null)
						files.writeFile(src+"\n\n");
					else
						System.out.println(src);
				}
				log.info("Closing file object");
				files.closeFile();
			//END
			return;
		}
		
// #BOTTOM	
} /* EOClass */
