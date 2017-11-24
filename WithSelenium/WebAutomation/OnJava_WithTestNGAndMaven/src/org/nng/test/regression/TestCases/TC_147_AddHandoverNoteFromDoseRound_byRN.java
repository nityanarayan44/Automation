package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.ProgressNotes;
import org.nng.test.pageObjects.ReportsPage;
import org.nng.test.pageObjects.ResidentDetailPage;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_147_AddHandoverNoteFromDoseRound_byRN extends GetBrowserInstance {

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
	String vansahTestCaseID = "147";
	String vansahBuild 		= Constants.build;
	String vansahRelease 	= Constants.release;
	String bhs_Environment 	= Constants.environment;
	String BHSLog_bit 		= Constants.log_Bit;
	String vansahTestcaseName = "TC_147_AddHandoverNoteFromDoseRound_byRN";
	String testStep = "";
	//--- #Other variables/instances
	//String residentName ="TESTPOINT, Eight";
	String residentName = "";
	String drugName 	= "";
	String note 		= "This is a automated dummy note text.1";


	//==[ FUNCTIONS ]=======================
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void addHandoverNoteFromDoseRound_byRN() {
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

			// Performing selection over menu icon.
			testStep 	= "User Clicks on Medication Round";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			// Performing selection on 'Main Dose Round', which would be at last of the list of time
			//--- Check if there is openDose round available and then proceed
			if(homePage.verify_presenceOfOpenDoseRound(driver)){
				//--- Click on Open Dose Round ---
				testStep 	= "User Clicks on openDoseRound";
				CounterName = "MainDoseRound-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				homePage.clickOn_OpenDoseRound(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				//---- Click on resident ---
				testStep 	= "User click on resident";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				//residentPage.clickOn_Resident(driver);
				//key.click(driver, "xpath", "//h3[text()='"+residentName+"']");
				key.click(driver, "xpath", "(//h3[contains(@ng-bind,'ResidentName')])[1]");
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				//--- Wait for few millis
				Thread.sleep(5000);

				//Save current resident Name
				residentName = residentPage.getResidentName(driver);

				//--- Clicking on "HandOver" Button and wait for few millis
				testStep 	= "User clicks on HandVoer button";
				residentPage.clickOn_HandOver(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				Thread.sleep(1000);

				//--- Enter the notes and click on save button
				testStep 	= "Enter the notes and click on save button";
				residentPage.add_HandOverNote(driver, this.note);
				residentPage.save_HandOverNote(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				/*-- [From here, we are using dependent test method] --*/


			}//end of open dose round logic
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"fail", "There is no Open Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
				Assert.fail("There is no open Doase Round Avaiable");
			}

		} 
		catch(Exception e) {
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(	vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment, "fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}

	/*
	 * Depended function, after priority-1
	 * --------------------------------------
	 * Verify the data-entry in Overhead Note
	 */
	@Test(dependsOnMethods = "addHandoverNoteFromDoseRound_byRN")
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
			CounterName = "Reports-HandOver-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			reportPage.clickOn_HandOver(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Wait for few millis
			Thread.sleep(3000);

			//--- Untick the without notes checkbox
			testStep = "Untick the without notes checkbox";
			//System.out.println(">>> Note Page....");
			reportPage.clickOn_noteFilterCheckBox(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//--- Wait for few millis, because dom is refreshing
			Thread.sleep(3000);

			// Search a resident name
			testStep = "User Search for a resident.";
			reportPage.searchForResident(driver, this.residentName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			Thread.sleep(2000);

			// Now verify the note for this resident
			testStep = "User expend the result and verify the added note.";
			reportPage.expendAndVerify_EntryInHandOverNote(driver, this.note);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			// Step Done.

		}// end of try
		catch (Exception e) {
			//e.printStackTrace();
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
			Assert.fail(testStep + "--Failed!!");	
		}
	}

	// #BOTTOM	
} /* EOClass */
