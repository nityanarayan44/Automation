package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.ProgressNotes;
import org.nng.test.pageObjects.ReportsPage;
import org.nng.test.pageObjects.ResidentDetailPage;
import org.nng.test.utills.DateAndTime;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_151_SearchHandoverNotesByChangingTheDates_byRN extends GetBrowserInstance {

	/*
	 * Gloabal instances
	 * ==========================================================
	 */
		//--- #WebDriver
		WebDriver driver;
			
		//--- #Class Instantiation
		Keywords key 					= new Keywords();
		StreamTest vansah 				= new StreamTest();
		HomePage homePage 				= new HomePage();
		ReportsPage reportPage 			= new ReportsPage();
		ProgressNotes progressPage 		= new ProgressNotes();
		ResidentDetailPage residentPage = new ResidentDetailPage();
		
		//--- #Vansah instances
		String CounterName;
		String monitorCode 		= Constants.sitemon_Monitor;
		String vansahPackage 	= Constants.vansahPackage;
		String vansahRequirement= "8";
		String vansahTestCaseID = "151";
		String vansahBuild 		= Constants.build;
		String vansahRelease 	= Constants.release;
		String bhs_Environment 	= Constants.environment;
		String BHSLog_bit 		= Constants.log_Bit;
		String vansahTestcaseName = "TC_151_SearchHandoverNotesByChangingTheDates_byRN";
		String testStep = "";
		//--- #Other variables/instances
		//String residentName ="TESTPOINT, Eight";
		String residentName 	= "";
		String drugName 		= "";
		String note 			= "This is a automated dummy note text...1 2 3 N N G";
		String currentDate		= (new DateAndTime()).getCurrentDateAsD_M_Y();
		String fromDate			= (new DateAndTime()).getPreviousDateByDays(2);
		String toDate			= (new DateAndTime()).getCurrentDateAsD_M_Y();
		String fromDateGreaterThanTo = (new DateAndTime()).getFutureDateByDays(2);
	
	//==[ FUNCTIONS ]=======================
		@BeforeTest
		public void getBrowserInstance(){
			driver = getDriver();
		}
		
		@Test(priority = 1)
		public void addHandoverNoteFromHandOverMenu_byRN() {
			vansah.setProperty("sAgentName", Constants.vansahAgentName);

			try {
					// Performing Login into Application
						testStep = "User Perform Login as RN";
						homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
					// Performing Selection over Section
						String SectionName = Constants.sectionName2;
						testStep = "User Select Section: "+SectionName+" ";
						homePage.selectSection(driver, SectionName);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Wait for sometimes, incase
						Thread.sleep(2000);
						
					//--- Click on Report menu icon
						testStep = "User clicks on Reports";
						CounterName = "Reports-Page-Load";
						vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
						reportPage.clickOn_Reports(driver);
						vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Wait for sometimes, incase
						Thread.sleep(2000);
						
					//--- Click on HandOver menu icon
						testStep = "User clicks on HandOver menu under Reports";
						CounterName = "HandOver-Page-Load";
						vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
						reportPage.clickOn_HandOver(driver);
						vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					//--- Wait for few millis
						Thread.sleep(2000);
						
					// status of 'without notes' check box
						testStep = "Check, whether 'Without Note' check box is checked by default.";
						if ( reportPage.getCurrentCheckBoxStatus(driver) != true ) {
							throw new Exception("Without note Check box is not checked by default.");
						}
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					//--- Wait for few millis
						Thread.sleep(2000);	
					
					//Click on checkBox
						testStep = "User Unticks the 'Without Notes' checkbox";
						reportPage.clickOn_noteFilterCheckBox(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
					//--- Wait for few millis
						Thread.sleep(2000);
					
					/*-- [From here, we are using dependent test method] --*/
						
			} 
			catch(Exception e) {
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(	vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,  "fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
				vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
				Assert.fail(testStep + "--Failed!! ", e);
			}
		}
		
	/*
	 * Depended function, after priority-1
	 * -------------------------------------------------------
	 * Verify the data-entry in Overhead Note according dates
	 * -------------------------------------------------------
	 */
			@Test(dependsOnMethods = "addHandoverNoteFromHandOverMenu_byRN")
			public void verifyHandOverNoteAccordingToDates()
			{
				try{
					// Set the From and To date and Click on Search button
						testStep = "Set the From and To date and Click on Search button.";
						reportPage.enterHandOverFromDate(driver, this.fromDate);
						reportPage.enterHandOverToDate(driver, this.toDate);
						reportPage.clickOn_searchButtonUnderHandOver(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
						//Wait for few seconds and then verify
							Thread.sleep(2000);
							// Now verify the note for this resident
							testStep = "Now verify the date of the notes with the provided FROM and TO dates";
							if( reportPage.expendAndVerifyAccordingToDates_EntryInHandOverNote(driver, this.fromDate, this.toDate) != true ) {
								throw new Exception("Date range failed.");
							}
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
							
					// Set the Current From and To date and Click on Search button
						testStep = "Set the From and To date as current date and Click on Search button.";
						reportPage.enterHandOverFromDate(driver, this.currentDate);
						reportPage.enterHandOverToDate(driver, this.currentDate);
						reportPage.clickOn_searchButtonUnderHandOver(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
						//Wait for few seconds and then verify
							Thread.sleep(2000);
							// Now verify the note for this resident
							testStep = "Now verify the date of the notes with the provided FROM and TO dates";
							if( reportPage.expendAndVerifyAccordingToDates_EntryInHandOverNote(driver, this.currentDate, this.currentDate) != true ) {
								throw new Exception("Date range failed.");
							}
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Set the From(Greater than To) and To date and Click on Search button
						testStep = "Set the From date greater than To date and Click on Search button.";
						reportPage.enterHandOverFromDate(driver, this.fromDateGreaterThanTo);
						reportPage.enterHandOverToDate(driver, this.toDate);
						reportPage.clickOn_searchButtonUnderHandOver(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
						//Wait for few seconds and then verify
							Thread.sleep(2000);
							// Now verify the note for this resident
							testStep = "Now verify the date of the notes with the provided FROM and TO dates";
							if( reportPage.verifyPopupPresenceWhenFromDateIsGreaterThanToDate(driver) != true ) {
								throw new Exception("From date is greater than To Date, and popup is missing.");
							}
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Step Done.
						
				}// end of try
				catch (Exception e) {
					e.printStackTrace();
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
					Assert.fail(testStep + "--Failed!!");
				}
			}
		
// #BOTTOM	
} /* EOClass */
