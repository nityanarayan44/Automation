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

public class TC_164_SearchVerify_NormalPriority  extends GetBrowserInstance
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
	String vansahTestCaseID = "164";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_164_SearchVerify_NormalPriority";
	String testStep = "";
	//String textDummy = "This is dummy text from Automation Script 45";

	//String residentName ="TESTPOINT, Eight";
	String residentName ="";
	String drugName = "";
	String facilityName = "TestPoint Nursing Home";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}


	@Test(priority = 1)
	public void searchVerify_NormalPriority() 
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

			testStep = "User clicks on History button";
			orderPage.clickOn_History(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			homePage.waitForPageLoader(driver);

			testStep = "User selects Sections and Resident from the dropdown";
			orderPage.select_SectionFromDropdown_History(driver, "All");
			homePage.waitForPageLoader(driver);
			orderPage.select_ResidentFromDropdown_History(driver, "All");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


			testStep = "User Set Priority as Normal";
			//orderPage.clickOn_Priority(driver, "Normal");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			testStep = "User set status as All";
			orderPage.clickOn_Status(driver, "All");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


			testStep = "User selects Type as All and enters starts date and end Date as current date";
			orderPage.select_Type_History(driver, "All");
			//reportPage.enterStartDate(driver, homePage.getCurrentDate());
			reportPage.enterEndDate(driver, homePage.getCurrentDate());
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			testStep = "User clicks on Search Button";
			orderPage.btn_searchHistory(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			homePage.waitForPageLoader(driver);

//			testStep = "User verifies the date in the search results should be inline with the current date";
//			if(orderPage.verifydate_InOrderdColumn(driver, homePage.getCurrentDate())){
//				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
//						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
//			}else{
//				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
//				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
//						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);		
//				Assert.fail(testStep + "--Failed!! ");	
//			}


			testStep = "User verfies that the Status doesn't contains Urgent";
			if(orderPage.verifyStatus_InStatusColumn(driver, " ", "Urgent")){
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


}
