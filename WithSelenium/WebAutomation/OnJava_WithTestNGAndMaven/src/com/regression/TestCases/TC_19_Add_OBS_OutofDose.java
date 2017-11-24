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

public class TC_19_Add_OBS_OutofDose extends GetBrowserInstance
{

	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();
	ReportsPage reportPage =  new ReportsPage();
	ProgressNotes progressPage = new ProgressNotes();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "12";
	String vansahTestCaseID = "19";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_19_Add_OBS_OutofDose";
	String testStep = "";

	//String residentName ="TESTPOINT, Eight";
	String residentName ="";
	String drugName = "";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void add_OBS_OutofDose() 
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);

		try
		{
			//Login into Application
			testStep = "User Perform Login as RN";
			homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Select Section
			String SectionName = Constants.sectionName2;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			Thread.sleep(3000);
			//homePage.waitForPageLoader(driver);

			//ClickOnMedicationRound
			testStep = "User Clicks on Medication Round";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User Clicks on 'Out of Dose' Round";
			CounterName = "OutOfDoseRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_OutOfDoseRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(2000);
			
			
			testStep = "User click on resident";
			CounterName = "ResidentDetail-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			//residentPage.clickOn_Resident(driver);
			//key.click(driver, "xpath", "//h3[text()='"+residentName+"']");
			key.click(driver, "xpath", "(//h3[contains(@ng-bind,'ResidentName')])[2]");
			residentPage.presence0f_MedicationsLocated(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(5000);
			//Save current resident Name
			residentName = residentPage.getResidentName(driver);

			// --- Click on Observation Button
			testStep = "User clicks on OBS Button";
			CounterName = "ResidentDetail-OBS-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			residentPage.clickOn_OBS(driver);
			residentPage.presence0f_MedicationsLocated(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User Verifies presence of following Observations: BGL, Pulse,Blood,"
					+ " Pressure, Weight, Bowel, Patch Site, INR, Temperature ";
			residentPage.verify_PresenceOf_OBSValues(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User Enters Observations Values for every Type ";
			residentPage.recordOBS_forResident(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(1000);
			testStep = "User clicks to save OBS values";
			residentPage.clickOn_btnSave(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(1000);
			testStep = "User Verifies The added Record";
			key.checkElementDisplay(driver, "xpath", "//span[contains(@ng-bind,'Value')]");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
		}// end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}

	}//End of method
	
	
	
}//End of class 
