package com.regression.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.ProgressNotes;
import com.PageObjects.ReportsPage;
import com.PageObjects.ResidentDetailPage;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_64_AddHandoverNoteFromHandOverMenu_byRN extends GetBrowserInstance {

	/*
	 * Gloabal instances
	 * ==========================================================
	 */
	//--- #WebDriver
	WebDriver driver;

	//--- #Class Instantiation
	Keywords key 		= new Keywords();
	StreamTest vansah 	= new StreamTest();
	HomePage homePage 	= new HomePage();
	ReportsPage reportPage 			= new ReportsPage();
	ProgressNotes progressPage 		= new ProgressNotes();
	ResidentDetailPage residentPage = new ResidentDetailPage();

	//--- #Vansah instances
	String CounterName;
	String monitorCode 		= Constants.sitemon_Monitor;
	String vansahPackage 	= Constants.vansahPackage;
	String vansahRequirement= "8";
	String vansahTestCaseID = "64";
	String vansahBuild 		= Constants.build;
	String vansahRelease 	= Constants.release;
	String bhs_Environment 	= Constants.environment;
	String BHSLog_bit 		= Constants.log_Bit;
	String vansahTestcaseName = "TC_64_AddHandoverNoteFromHandOverMenu_byRN";
	String testStep = "";
	//--- #Other variables/instances
	//String residentName ="TESTPOINT, Eight";
	String residentName = "";
	String drugName 	= "";
	String note 		= "This is a automated dummy note text...1 2 3 N N G";


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
			Thread.sleep(3000);

			//--- Click on Report menu icon
			testStep = "User clicks on Reports";
			CounterName = "Reports-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			reportPage.clickOn_Reports(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			// Wait for sometimes, incase
			Thread.sleep(3000);

			//--- Click on HandOver menu icon
			testStep = "User clicks on HandOver menu under Reports";
			CounterName = "HandOver-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			reportPage.clickOn_HandOver(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Wait for few millis
			Thread.sleep(5000);

			//Save current resident Name
			residentName = reportPage.getFirstResidentName_UnderHandOverResidentList(driver);

			//Click on add button next to the resident name
			testStep = "Click on add button next to the resident name";
			reportPage.clickOn_addButtonUnderHandOverResidentList(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Enter the notes and click on save button
			testStep = "User Enters the notes and click on save button";
			residentPage.add_HandOverNote(driver, this.note);
			residentPage.save_HandOverNote(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

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
	 * --------------------------------------
	 * Verify the data-entry in Overhead Note
	 */
	@Test(dependsOnMethods = "addHandoverNoteFromHandOverMenu_byRN")
	public void verifyHandOverNote()
	{
		try{
			//--- Navigating to home or start page
			testStep = "User Navigates to homePage";
			homePage.clickOn_HomeBtn(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Click on Report menu icon
			testStep = "User clicks on Reports";
			CounterName = "Reports-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			reportPage.clickOn_Reports(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Click on HandOver menu icon
			testStep = "User clicks on HandOver menu under Reports";
			CounterName = "HandOver-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			reportPage.clickOn_HandOver(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Wait for few millis
			Thread.sleep(3000);

			// Search a resident name
			testStep = "User Searching for a resident for which Handover note was added.";
			reportPage.searchForResident(driver, this.residentName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			Thread.sleep(2000);

			// Now verify the note for this resident
			testStep = "Now verify the note for this resident";
			reportPage.expendAndVerify_EntryInHandOverNote(driver, this.note);
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
