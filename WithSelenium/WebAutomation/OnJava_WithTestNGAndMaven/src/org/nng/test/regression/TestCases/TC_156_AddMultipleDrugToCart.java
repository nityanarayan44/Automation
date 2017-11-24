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

public class TC_156_AddMultipleDrugToCart  extends GetBrowserInstance
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
	String vansahRequirement = "20";
	String vansahTestCaseID = "156";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_156_AddMultipleDrugToCart";
	String testStep = "";

	//String residentName ="TESTPOINT, Eight";
	String residentName ="";
	String drugName = "";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}


	@Test(priority = 1)
	public void addMultipleDrugToCart() 
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);

		try
		{
			
			//Login into Application
			testStep = "User Perform Login as Registered Nurse";
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


				//-- click on Packed Tab;
				testStep = "User Clicks on Non-Packed Tab";
				homePage.clickOn_NonPackedTab(driver);;
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				//---- Click on resident --
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

				//Save current resident Name
				residentName = residentPage.getResidentName(driver);
				Thread.sleep(4000);
				drugName = residentPage.getNonPacked_DrugName(driver);

				testStep = "User verifies and click on cart button to add medication to the Cart";
				residentPage.addMedicationToCart(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				testStep = "User verifies the Add to Cart message";
				if(residentPage.addToCart_NotificationLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
					Assert.fail(testStep + "--Failed!! ");		
				}
				
				testStep = "User clicks again on add to cart button and verifies the already existing confirmation popup";
				residentPage.addMedicationToCart(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				testStep = "User verifies that the existing medication popup should be displayed";
				if(residentPage.cart_ExistingMedicationPOPupLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
					Assert.fail(testStep + "--Failed!! ");
				}
				
				testStep = "User clicks ok to add medication to cart";
				residentPage.cart_PopUpConfirm(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				testStep = "User verifies the Add to Cart message";
				if(residentPage.addToCart_NotificationLocated(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
					Assert.fail(testStep + "--Failed!! ");		
				}
				

				testStep = "User confirms the Increased Count number at the top right of the webpage";
				residentPage.verifyCartCount(driver, "2");
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
			}//end of open dose round logic
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "There is no Open Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				Assert.fail("There is no open Dose Round Avaiable");
			}
		}// end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}//End of method
	
	@Test(dependsOnMethods = "addMultipleDrugToCart", alwaysRun = true)
	public void cleanCart(){
		try
		{
			testStep = "User Navigates to homePage";
			homePage.clickOn_HomeBtn(driver);

			testStep = "User click on cart button";
			residentPage.clickOn_Cart(driver);

			testStep = "User cleans the cart from all medication";
			if(residentPage.cart_presenceOFMedicationLocated(driver)){
				residentPage.removeAllMedication_FromCart(driver);
			}
			
		}//end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			//			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
			//					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// end of method
	
	
	
	
}
