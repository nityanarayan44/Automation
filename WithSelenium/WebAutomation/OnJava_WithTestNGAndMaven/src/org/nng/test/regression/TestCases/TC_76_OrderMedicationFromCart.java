package org.nng.test.regression.TestCases;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.BestPack_FacilityOrders;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.OrderingPage;
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

public class TC_76_OrderMedicationFromCart extends GetBrowserInstance
{

	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();
	ReportsPage reportPage =  new ReportsPage();
	OrderingPage orderPage = new OrderingPage();
	BestPack_FacilityOrders Facility = new BestPack_FacilityOrders();
	
	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "20";
	String vansahTestCaseID = "76";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_76_OrderMedicationFromCart";
	String testStep = "";

	//String residentName ="TESTPOINT, Eight";
	String residentName ="";
	String drugName = "";
	String facilityName = "TestPoint Nursing Home";
	
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}


	@Test(priority = 1)
	public void orderMedicationFromCart() 
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

			homePage.waitForPageLoader(driver);
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

				homePage.verify_presenceOfTabs(driver);
				
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
				key.click(driver, "xpath", "(//h3[contains(@ng-bind,'ResidentName')])[1]");
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				homePage.waitForPageLoader(driver);
				//Save current resident Name
				residentName = residentPage.getResidentName(driver);
				drugName = residentPage.getNonPacked_DrugName(driver);
				

				testStep = "User verifies and click on cart button, to add medication to the Cart";
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

				testStep = "User clicks on Cart button at top right to Open cart";
				residentPage.clickOn_Cart(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

				homePage.waitForPageLoader(driver);
				testStep = "User verifies the Medication in the Cart";
				if(residentPage.verifyMedication_InCart(driver, drugName)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
					Assert.fail(testStep + "--Failed!! ");	
				}

				testStep = "User clicks on Order button";
				residentPage.clickOn_Order(driver);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


				testStep = "User verifies the order submit notifications";
				if(residentPage.verify_OrderSubmitNotification(driver)){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					homePage.waitForPageLoader(driver);
				}else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
					Assert.fail(testStep + "--Failed!! ");	
				}
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


	@Test(priority = 2,dependsOnMethods = "orderMedicationFromCart")
	public void verifyRecentOrderNotification()
	{

		try
		{
			testStep = "User Navigates to homePage";
			homePage.clickOn_HomeBtn(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//homePage.waitForPageLoader(driver);
			
			testStep = "User clicks on Ordering button";
			CounterName = "Ordering-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			orderPage.clickOn_OrderingBtn(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			
			testStep = "User clicks on NonPacked-PRN button";
			orderPage.clickOn_NpPrn(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			testStep = "User Selects Section & Resident from DropDown";
			orderPage.select_SectionFromDropdown(driver, "All");
			orderPage.select_ResidentFromDropdown(driver, residentName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User Checks Regular and unchecks PRN & Exclude EyeDrops";
			//orderPage.clickOn_RegularCheckbox(driver);
			orderPage.clickOn_PRNCheckbox(driver);
			orderPage.clickOn_ExcludeEDCheckbox(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User clicks on button to search";
			orderPage.btn_Search(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User verifies the recent search Notification label for the medication";
			if(orderPage.presenceof_RecentOrderNotificationLocated(driver, residentName)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
				Assert.fail(testStep + "--Failed!! ");
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

	@Test(priority = 3,dependsOnMethods = "verifyRecentOrderNotification", alwaysRun = true)
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
			
			testStep = "Perform Logout";
			homePage.app_Logout(driver);
		}//end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			//			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
			//					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// end of method
	
	@Test(priority = 4, dependsOnMethods = {"orderMedicationFromCart", "cleanCart"})
	public void verifyInBestPack()
	{
		try
		{
			testStep = "User performs Login as pharmacy Manager";
			homePage.performLogin(driver, Constants.USER_NAME_PHM, Constants.PASSWORD_PHM);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User clicks to Navigates to Facility Orders";
			Facility.clickOn_FacilityOrders(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User clicks to navigate to Online Orders";
			CounterName = "BestPack_OnlineOrders_PageLoad";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			Facility.clickOn_OnlineOrders(driver);
			key.checkElementDisplay(driver, "xpath", "//tbody/tr");
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User selects the required Facility";
			Facility.clickOn_FacilityOnlineOrders(driver, facilityName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//wait for table to Load
			key.checkElementDisplay(driver, "xpath", "//tr/td");
			
			testStep = "User verifies the presence of orderd medication in the table";
			Facility.sortColumn_Ordered(driver);
			Facility.sortColumn_Ordered(driver);// Sort in descending order
			homePage.waitForPageLoader(driver);
			if(Facility.verifyMedication(driver, drugName)){
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
				Assert.fail(testStep + "--Failed!! ");
			}
		}// end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
		
	}// End of method
	
	
	
}// end of class
