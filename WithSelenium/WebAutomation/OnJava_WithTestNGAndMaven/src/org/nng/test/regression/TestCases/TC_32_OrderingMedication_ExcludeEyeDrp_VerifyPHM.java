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

public class TC_32_OrderingMedication_ExcludeEyeDrp_VerifyPHM extends GetBrowserInstance
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
	String vansahTestCaseID = "32";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_32_OrderingMedication_ExcludeEyeDrp_VerifyPHM";
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
	public void orderingMedication_ExcludeEyeDrp() 
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);

		try
		{
			
			//Login into Application
			testStep = "User Perform Login as Registered Nurse";
			homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			homePage.waitForPageLoader(driver);
			//Select Section
			String SectionName = Constants.sectionName;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			
			testStep = "User clicks on Ordering button";
			CounterName = "Ordering-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			orderPage.clickOn_OrderingBtn(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User clicks on NonPacked-PRN button";
			orderPage.clickOn_NpPrn(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			homePage.waitForPageLoader(driver);
			
			testStep = "User Selects Section, Resident from DropDown";
			orderPage.select_SectionFromDropdown(driver, "All");
			orderPage.select_ResidentFromDropdown(driver, "All");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User checks Regular, Exclude EyeDrops Checkboxes and unchecks PRN";
			//orderPage.clickOn_RegularCheckbox(driver);
			orderPage.clickOn_PRNCheckbox(driver);
			//orderPage.clickOn_ExcludeEDCheckbox(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User clicks on button to search";
			orderPage.btn_Search(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			
			//Fetech first resident and first Search
			residentName = orderPage.getResidentName_Ordering(driver);
			drugName = orderPage.getdrugName_Ordering(driver);
			
			testStep = "User verifies that the EyeDrops medication should be exluded in the searched list";
			if(orderPage.presenceOfEyeDropLocated(driver)){
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
				Assert.fail(testStep + "--Failed!! ");	
			}else{
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}
			
			
			testStep = "User enters Qty and selects the medication by ticking on checkbox";
			orderPage.enter_QtyRequired(driver);
			orderPage.clickOn_FirstCheckboxOrder(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User clicks to Order and verify successfull submit message";
			residentPage.clickOn_Order(driver);
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
			
			testStep = "User performs Logout";
			homePage.app_Logout(driver);
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

	@Test(priority = 2, dependsOnMethods = {"orderingMedication_ExcludeEyeDrp"})
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
			//key.checkElementDisplay(driver, "xpath", "//tr/td");
			homePage.waitForPageLoader(driver);
			
			testStep = "User verifies the presence of orderd medication in the table";
			Facility.sortColumn_Ordered(driver);
			Facility.sortColumn_Ordered(driver);// Sort in descending
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
	
	
	
}
