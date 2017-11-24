package org.nng.test.regression.TestCases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.nng.automation.utils.*;
import org.nng.utils.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Case2_GoogleSearch_WithTestData {


	/*
	 * ==========================================================
	 * Global instances
	 * ==========================================================
	 */
		//--- #Class Objects [Includes PageObject Also]
			Driver driver 	= null;
			Action action 	= null;
			Excel excel		= null;
			
		//--- #Variable for this test
			String testCaseName		= "GoogleSearch_And_List_The_FirstPage_Result_Using_TestData_ExcelFile";
			String projectName 		= "Project1";
			String projectId 		= "prj100001";
			String testStepdesc 	= "";
			String browserName		= "CHROME";
			String driverPath		= "C:\\DRIVERS\\chromedriver_win32_new\\chromedriver.exe";
			String screenShotPath	= "";
			String TestData_SheetName= "Sample1";
			ArrayList<String> data = new ArrayList<String>();

	/*
	 * ==========================================================
	 * Functions for TestNG Configurations
	 * ==========================================================
	 */
		//--- BeforeClass: Initiating Objects	
			@BeforeClass
			public void Conf1() throws Exception{
				// Initiation
					this.driver = new Driver();
					this.action = new Action();
					this.excel 	= new Excel("src\\org\\nng\\test\\dataFiles\\TestData.xlsx");
				// WebDriver initiation
					this.driver.getWebDriver(this.browserName, this.driverPath);// Initiating webDriver
					this.driver.maximizeBrowser();						// Maximizing the Browser
			}
		//--- AfterClass: Quitting WebDriver	
			@AfterClass
			public void conf2() throws Exception{
				this.driver.quitDriver();
				javax.swing.JOptionPane.showMessageDialog(null, "TestCase Executed", "Done", JOptionPane.INFORMATION_MESSAGE);
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
					this.data = excel.getRowData(this.TestData_SheetName, 1);
					//this.action.setElementValue(this.driver.webDriver, "name", "q", this.data.get(1) + Keys.ENTER);
					this.action.setElementValue(this.driver.webDriver, "name", "q", this.excel.getColumnData("Sample1", "PASSWORD").get(1) + Keys.ENTER);
					
			} catch (Exception err) {
				// Take screenShot in Case of Failure.
				//ScreenShotCapture.captureScreen(driver, this.testCaseName);
				Assert.fail(this.testStepdesc + " Failed!! ", err);
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
					Thread.sleep(1000);
					
				// Capturing all the result.
					this.testStepdesc = "Capturing all the search result Text";
					String totalSearch = this.driver.webDriver.findElement(By.xpath("//*[@id='ires']/div/div")).getText();
					System.out.printf("Search Result Text :\n\n\n %s \n\n\n", totalSearch);
					
			} catch (Exception err) {
				// Capture the screenshot
				//ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				Assert.fail(this.testStepdesc + " Failed!!", err);
			}
		}

		
// #BOTTOM	
} /* EOClass */