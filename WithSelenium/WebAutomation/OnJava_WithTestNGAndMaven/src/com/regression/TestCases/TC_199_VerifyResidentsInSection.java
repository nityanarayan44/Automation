package com.regression.TestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_199_VerifyResidentsInSection extends GetBrowserInstance
{
	//WebDriver driver = getDriver();
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "14";
	String vansahTestCaseID = "199";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_199_VerifyResidentsInSection";
	String testStep = "";
	
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test
	public void verifyResidents(){
		vansah.setProperty("sAgentName", Constants.vansahAgentName);

		try{
			//Login into Application
			testStep = "User Perform Login";
			homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Select Section
			String SectionName = Constants.sectionName;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			Thread.sleep(3000);
			//ClickOnMedicationRound
			testStep = "User Clicks on MedicationRound";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			testStep = "User Clicks on MainDoseRound";
			CounterName = "MainDoseRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_OpenDoseRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(2000);
			//Verify if all the resident have the same Section which is same as selectod Section
			testStep = "Verify if all the resident is of same section";
			String residentSections = "//span[contains(@ng-bind,'SectionName')]";
			String residentNames = "//h3[contains(@ng-bind,'ResidentName')]";
			
			//Fetch all residenst name and section
			List<WebElement> all_ResidentNames = key.fetch_AllElements(driver, residentNames);
			List<WebElement> all_ResidentSection = key.fetch_AllElements(driver, residentSections);
			
			//Verify each resident's sections with the section selected
			for(int i = 0; i<all_ResidentNames.size() ;i++){
					
				String rName = all_ResidentNames.get(i).getText();
				String rSection = all_ResidentSection.get(i).getText();
				if(SectionName.contains(rSection)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,bhs_Environment,
							"pass", "Resident Verification: Following resident - " + rName +" belongs to the section: "+ 
					rSection  +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,bhs_Environment,
							"fail", "Resident Verification: Following resident - " + rName +" doesn't belongs to the section: "+ 
					rSection  +" - Failed!", BHSLog_bit);	
					Assert.fail("Resident matching with same section verification Failed");
				}
			}
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);

		}


	}// end of method



}
