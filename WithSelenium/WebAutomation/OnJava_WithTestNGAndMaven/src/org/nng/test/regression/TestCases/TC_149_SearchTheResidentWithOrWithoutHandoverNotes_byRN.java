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

public class TC_149_SearchTheResidentWithOrWithoutHandoverNotes_byRN extends GetBrowserInstance {

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
		String vansahTestCaseID = "149";
		String vansahBuild 		= Constants.build;
		String vansahRelease 	= Constants.release;
		String bhs_Environment 	= Constants.environment;
		String BHSLog_bit 		= Constants.log_Bit;
		String vansahTestcaseName = "TC_149_SearchTheResidentWithOrWithoutHandoverNotes_byRN";
		String testStep = "";
		//--- #Other variables/instances
		//String residentName ="TESTPOINT, Eight";
		String residentName 	= "";
		String drugName 		= "";
		String note 			= "This is a automated dummy note text...1 2 3 N N G";
		String currentDate		= (new DateAndTime()).getCurrentDateAsD_M_Y();
		String fromDate			= (new DateAndTime()).getPreviousDateByDays(4);
		String toDate			= (new DateAndTime()).getCurrentDateAsD_M_Y();
		String fromDateGreaterThanTo = (new DateAndTime()).getFutureDateByDays(2);
	
	//==[ FUNCTIONS ]=======================
		@BeforeTest
		public void getBrowserInstance(){
			driver = getDriver();
		}
		
		@Test(priority = 1)
		public void searchTheResidentWithOrWithoutHandoverNotes_byRN() {
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
			@Test(dependsOnMethods = "searchTheResidentWithOrWithoutHandoverNotes_byRN")
			public void verifyHandOverNoteAccordingToDates()
			{
				try{
					//Untick the check box
					//Check for the checkbox status then Click on checkBox to untick the checkbox
						testStep = "User Unticks the without notes checkbox";
						if (reportPage.getCurrentCheckBoxStatus(driver) == true) {
							reportPage.clickOn_noteFilterCheckBox(driver);
						}else {
							throw new Exception("Check box already unticked, which is unexpected");
						}
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					//--- Wait for few millis
						Thread.sleep(2000);
					
					// Verify all the 4 elements of handover notes
					// Date, CreatedBy, Note, Delete_Icons.
						testStep = "Verify the handover note deatils element";
						reportPage.expendAndVerifyHandoverNoteElement(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Verify the resident without having handover note
						testStep = "Verify the resident without handover note";
						reportPage.expendAndVerifyResidentWithoutHandoverNote(driver);
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
