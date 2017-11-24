package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.BestPack_SystemMaintenance;
import org.nng.test.pageObjects.DoctorBookPage;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.UserManagement;
import org.nng.test.utills.DateAndTime;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_94_AddNoteFromDoctorBook_byRN extends GetBrowserInstance {

	/*
	 * ================================================================================
	 * --- [Global instances] ------------
	 * ================================================================================
	 */
		// #WebDriver object
		WebDriver driver 	= null;
			
		// #Class Instantiation
		Keywords keywords 				= new Keywords();		// Class object For webElement operations
		HomePage homePage 				= new HomePage();		// POM Class
		DoctorBookPage docBookPage		= new DoctorBookPage();	// POM Class
		
		// #Vansah instances
		String CounterName		= "";
		StreamTest vansah 		= new StreamTest();
		String monitorCode 		= Constants.sitemon_Monitor;
		String vansahPackage 	= Constants.vansahPackage;
		String vansahRequirement= "8";
		String vansahTestCaseID = "94";
		String vansahBuild 		= Constants.build;
		String vansahRelease 	= Constants.release;
		String bhs_Environment 	= Constants.environment;
		String BHSLog_bit 		= Constants.log_Bit;
		String vansahTestcaseName = "TC_94_AddNoteFromDoctorBook_byRN";
		String testStep = "";
		
		//--- #Other variables/instances
		String noteText		= "";
	/*
	 * ================================================================================
	 * --- [Functions, as test] ------------
	 * ================================================================================
	 */
		
		//----------------------
		// #Driver initiation
		//----------------------
			@BeforeTest
			public void getBrowserInstance(){
				this.driver = getDriver();
			}
		
		//----------------------
		// #Test: Begin
		//----------------------
			@Test(priority = 1)
			public void addNoteFromDoctorBook_byRN() {
				//Setting agent for this test in Vansah
				vansah.setProperty("sAgentName", Constants.vansahAgentName);
				this.noteText = "This is automated text "+ (new DateAndTime()).getCurrentDateAsD_M_Y() +"-"+ System.currentTimeMillis();
				
				try {
						// Performing Login into Application
							testStep = "User Perform Login as RN";
							homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
							
						// Select Doctor book from main menu
							testStep = "Select Doctor book from main menu";
							CounterName = "DoctorBook-Page-Load";
							vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
							homePage.clickOn_DoctorBook(driver);
							vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							this.docBookPage.waitForPageLoader(driver);
					
						// Click on Add note button
							testStep = "Click on Add note button";
							this.docBookPage.clickOn_addNoteButton(driver);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							this.docBookPage.waitForPageLoader(driver);
							
						// Enter the doctor note and click on save button
							testStep = "Enter the doctor note and click on save button";
							this.docBookPage.set_noteText(driver, this.noteText);
							this.docBookPage.clickOn_saveNoteText(driver);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
							
						// Wait for few millis
							this.docBookPage.waitForPageLoader(driver);
						
							
						/*-- [From here, we are using dependent test method] --*/
							
				} 
				catch(Exception e) {
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(	vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,  "fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
					Assert.fail(testStep + "--Failed!! ", e);
				}
			}
		
		//-------------------------------------------------------------------------
		// #Test, Depends on start test [next test to be followed after addNewUser]
		//-------------------------------------------------------------------------
			@Test(dependsOnMethods = "addNoteFromDoctorBook_byRN")
			public void verifyHandOverNoteAccordingToDates() throws Exception{
				try{
					// Verify the added note
						testStep = "Verify the added note text";
						if(this.docBookPage.verify_allListedNoteTextForADoctor(driver, this.noteText) == false) {
							Assert.fail(testStep + "--Failed!!");
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
