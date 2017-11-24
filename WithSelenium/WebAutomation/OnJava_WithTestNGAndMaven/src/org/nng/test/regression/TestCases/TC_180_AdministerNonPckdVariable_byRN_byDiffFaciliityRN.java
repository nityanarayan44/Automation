package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.HomePage;
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

public class TC_180_AdministerNonPckdVariable_byRN_byDiffFaciliityRN extends GetBrowserInstance
{

	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();
	ReportsPage reportPage =  new ReportsPage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "8";
	String vansahTestCaseID = "180";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_180_AdministerNonPckdVariable_byRN_byDiffFaciliityRN";
	String testStep = "";

	String residentName ="TESTPOINT, Seven";
	//String residentName ="";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void administerNonPckdVariable_byRN_byDiffFaciliityRN() 
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
			//ClickOnMedicationRound
			testStep = "User Clicks on Medication Round";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Check if there is openDose round available and then proceed
			if(homePage.verify_presenceOfOpenDoseRound(driver))
			{
				//--- Click on Open Dose Round ---
				testStep = "User Clicks on openDoseRound";
				CounterName = "MainDoseRound-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				homePage.clickOn_OpenDoseRound(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//-- click on Variable Tab;
				testStep = "User Clicks on Variable Tab";
				homePage.clickOn_VariableTab(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//---- Click on resident --
				testStep = "User click on resident";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				//residentPage.clickOn_Resident(driver);
				key.click(driver, "xpath", "//h3[text()='"+residentName+"']");
				//key.click(driver, "xpath", "(//h3[contains(@ng-bind,'ResidentName')])[last()-1]");
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				//Save current resident Name
				residentName = residentPage.getResidentName(driver);
				Thread.sleep(5000);
				
				testStep="User verifies presence of Variable drug in Non-Packed Section";
				if(residentPage.presence0fNonPacked_VariableDrugLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

					testStep="User enters Prescribed variable Drug";
					residentPage.enter_PrescribedVariableDrug(driver, "2");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					testStep="User enters Given variable Drug";
					residentPage.enter_GivenVariableDrug(driver, "2");;
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
				}// end of insulin condition
				else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "There is no Variable medicine available for the test :( Unable to procceed. ", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
					Assert.fail("There is no Variable medicine avaiable");
				}

				
				testStep="User Click on Admin checkbox to administer variable Drug";
				residentPage.clickOn_NonPackedVariableDrug(driver);;
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				//Enter steps for auth Pin
				testStep = "User verifies the authentication popup";
				if(residentPage.presence0f_PinAuthenticationPopUpLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					
					testStep = "User enters valid RN pin from different facility  and click 'verify' for authorization";
					residentPage.enterPin(driver, Constants.RN_PIN_FromDifferentFacility);
					residentPage.clickOn_verifyPin(driver);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
					testStep = "User validates the Incorrect pin message";
					if(residentPage.verify_PinError(driver)){
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					}else{
						ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
						vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
						Assert.fail(testStep + "--Failed!!");
					}
				
				}//end of authentication popup Logic
				else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
					Assert.fail(testStep + "--Failed!!");
				}				

			}//end of open dose round logic
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "There is no Open Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
				Assert.fail("There is no open Doase Round Avaiable");
			}
		}// end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// end of method

}//End of Class
