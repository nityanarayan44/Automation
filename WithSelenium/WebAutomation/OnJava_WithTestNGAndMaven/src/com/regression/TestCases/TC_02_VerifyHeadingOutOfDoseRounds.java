package com.regression.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.ResidentDetailPage;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_02_VerifyHeadingOutOfDoseRounds extends GetBrowserInstance
{
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "7";
	String vansahTestCaseID = "2";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_02_VerifyHeadingOutOfDoseRounds";
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


			//verify if resident list is available in All Tab
			testStep = "Verify Presence of residents lists in All Tab";
			if(homePage.verify_PresenceOfResidentList(driver))
			{
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				//---- Click on resident --
				testStep = "User click on resident and verify medication availability";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_Resident(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				Thread.sleep(2000);
				//--------------------
				String roundName = "Out Of Dose Round";
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

				testStep = "Verify presence of Confirm Button in PRN Page";
				if(residentPage.presence0f_ConfirmButtonLocated(driver)){
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

				//To enable save button visibility
				key.click(driver, "xpath", "(//span[@title='Increase value'])[1]");
				key.click(driver, "xpath", "(//span[@title='Increase value'])[2]");

				testStep = "Verify presence of Save Button in OBS Page";
				if(residentPage.presence0f_SaveButtonLocated(driver)){
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

				testStep = "Verify presence of Confirm Button in NIM Page";
				if(residentPage.presence0f_ConfirmButtonLocated(driver)){
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


				testStep = "Verify presence of Confirm Button in Emergency Stock Page";
				if(residentPage.presence0f_ConfirmButtonLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}
				//--------------------

				// --- Click on Progress Button
				testStep = "User clicks on Progress-Note Button and Verify popup elements ";
				residentPage.clickOn_ResiProgNote(driver);
				if(residentPage.verifyNoteTitle(driver))
				{	
					//verify save and Cancel Button
					residentPage.addNote(driver, "This is Dummy"); //to enable save
					if(residentPage.presence0f_SaveButtonLocated(driver) &&
							residentPage.presence0f_CancelButtonLocated(driver)){
						System.out.println("ProgressNote verified");
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					}else{
						ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);	
					}

					residentPage.clickOn_CancelBtn(driver);

				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				}
				
				
				//click on HandOver button
				testStep = "User clicks on Handover Note Button and Verify popup elements";
				residentPage.clickOn_HandoverNote(driver);
				if(residentPage.presence0f_SaveButtonLocated(driver) &&
						residentPage.presence0f_CancelButtonLocated(driver)){
					residentPage.clickOn_CancelBtn(driver);
					System.out.println("handover verified");
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);	
				}

			}// presence of all resident condition
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
			}
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}//End of Method
}// end of class
