package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.ResidentDetailPage;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_12_VerifyDifferentMedication  extends GetBrowserInstance
{
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "19";
	String vansahTestCaseID = "12";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_12_VerifyDifferentMedication";
	String testStep = "";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void verifyMedications_InMainDoseRound()
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);
		try
		{
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

				//Thread.sleep(3000);
				//---- Click on resident --
				testStep = "User click on resident";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_Resident(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				//---- verify admin checkbox --
				testStep = "Verify presence of 'Enabled' Admin Checkbox";
				if(residentPage.presence0f_AdminCheckboxLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}

				//----verify confirm button --
				testStep = "Verify presence of Confirm Button";
				if(residentPage.presence0f_ConfirmButtonLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}
				
				String roundName = "Main Dose Round";
				String title = "";
				
				// --- Click on PRN Button
				testStep = "User clicks on PRN Button";
				CounterName = "ResidentDetail-PRN-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_PRN(driver);;
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
			
				//Verify Page Title for PRN
				testStep = "User verify title on PRN page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("PRN") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}
				
				Thread.sleep(1000);
				
				// --- Click on OBS Button
				testStep = "User clicks on OBS Button";
				CounterName = "ResidentDetail-OBS-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_OBS(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				//Verify Page Title for OBS
				testStep = "User verify title on OBS page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("OBS") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}

				Thread.sleep(1000);
				// --- Click on NIM Button
				testStep = "User clicks on NIM Button";
				CounterName = "ResidentDetail-NIM-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_NIM(driver);;
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//Verify Page Title for NIM
				testStep = "User verify title on NIM page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("NIM") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}
				
				Thread.sleep(1000);
				// --- Click on Emergency Stock Button
				testStep = "User clicks on Emergency Stock Button";
				CounterName = "ResidentDetail-EmergencyStock-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_EmergencyStock(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//Verify Page Title for Emergency Stock
				testStep = "User verify title on Emergency Stock page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("Emgcy Stock") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}
				

			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "There is no Open Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				Assert.fail("There is no open Doase Round Avaiable");
			}
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}
	}
	@Test(priority = 2)
	public void verifyMedications_InSpecialDoseRound()
	{
		
		homePage.clickOn_HomeBtn(driver);
		try
		{
			Thread.sleep(3000);
			//ClickOnMedicationRound
			testStep = "User Clicks on MedicationRound";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			if(homePage.verify_presenceOfSpecialDoseRound(driver))
			{
				//--- Click on Special Dose Round ---
				testStep = "User Clicks on specialDoseRound";
				CounterName = "SpecialDoseRound-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				homePage.clickOn_SpecialDoseRound(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				//Thread.sleep(3000);
				//---- Click on resident --
				testStep = "User click on resident and verify medication availability";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_Resident(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				//---- verify admin checkbox --
				testStep = "Verify presence of 'Enabled' Admin Checkbox";
				if(residentPage.presence0f_AdminCheckboxLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}

				//----verify confirm button --
				testStep = "Verify presence of Confirm Button";
				if(residentPage.presence0f_ConfirmButtonLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}
				
				String roundName = "Special Dose Round";
				String title = "";
				
				// --- Click on PRN Button
				testStep = "User clicks on PRN Button";
				CounterName = "ResidentDetail-PRN-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_PRN(driver);;
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
			
				//Verify Page Title for PRN
				testStep = "User verify title on PRN page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("PRN") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}

				Thread.sleep(1000);
				// --- Click on OBS Button
				testStep = "User clicks on OBS Button";
				CounterName = "ResidentDetail-OBS-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_OBS(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				//Verify Page Title for OBS
				testStep = "User verify title on OBS page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("OBS") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}

				Thread.sleep(1000);
				// --- Click on NIM Button
				testStep = "User clicks on NIM Button";
				CounterName = "ResidentDetail-NIM-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_NIM(driver);;
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//Verify Page Title for NIM
				testStep = "User verify title on NIM page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("NIM") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}
				
				Thread.sleep(2000);
				// --- Click on Emergency Stock Button
				testStep = "User clicks on Emergency Stock Button";
				CounterName = "ResidentDetail-EmergencyStock-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_EmergencyStock(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//Verify Page Title for Emergency Stock
				testStep = "User verify title on Emergency Stock page in: " + roundName;
				title = residentPage.getResident_PageTitle(driver);
				System.out.println(title + "---BEFORE if");
				if(title.contains("Emgcy Stock") && title.contains(roundName)){
					System.out.println(title + "---verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);					
				}
			}
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "There is no special Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				Assert.fail("There is no Special Doase Round Avaiable");
			}
			
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}
		
	}// end of method

}// end of class
