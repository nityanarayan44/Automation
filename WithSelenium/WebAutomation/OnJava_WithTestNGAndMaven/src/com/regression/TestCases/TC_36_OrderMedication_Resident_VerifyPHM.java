package com.regression.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.BestPack_FacilityOrders;
import com.PageObjects.HomePage;
import com.PageObjects.OrderingPage;
import com.PageObjects.ReportsPage;
import com.PageObjects.ResidentDetailPage;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_36_OrderMedication_Resident_VerifyPHM extends GetBrowserInstance
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
	String vansahTestCaseID = "36";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_36_OrderMedication_Resident_VerifyPHM";
	String testStep = "";
	String textDummy = "This is dummy text from Automation Script";

	//String residentName ="TESTPOINT, Eight";
	String filePath = System.getProperty("user.dir")+"\\src\\com\\test\\TestDataXLS\\Sample.pdf";
	String residentName ="";
	String drugName = "";
	String facilityName = "TestPoint Nursing Home";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}


	@Test(priority = 1)
	public void orderMedication_Resident() 
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
			
			testStep = "User Clicks on Medication Change";
			orderPage.clickOn_MedChange(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			
			testStep = "User Selects Section, Resident from DropDown";
			orderPage.select_SectionFromDropdown(driver, "All");
			orderPage.select_ResidentFromDropdown(driver, "All");
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			testStep = "User clicks on button to search";
			orderPage.btn_Search(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			residentName = orderPage.getResidentName_Ordering(driver);
			
			testStep = "User Enters Description for the resident";
			orderPage.enter_Description(driver, textDummy);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User selects OrderAll checkbox";
			orderPage.clickOn_FirstCheckboxOrder(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User click on Attachment button";
			orderPage.clickOn_AttachmentButton(driver);
			homePage.waitForPageLoader(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			testStep = "User Selects file and upload an sample PDF docuement";
			orderPage.upload_file(driver, filePath);
			homePage.waitForPageLoader(driver);
			orderPage.popup_ClickOnDone(driver);
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
	
	@Test(priority = 2, dependsOnMethods = {"orderMedication_Resident"})
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
			
			
			testStep ="User selects Med-change Option and click on Search button";
			Facility.clickOn_MedChange(driver);
			Facility.clickOn_SearchOnlineOrders(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			homePage.waitForPageLoader(driver);
			
			testStep = "User verifies the presence of orderd medication in the table";
			Facility.sortColumn_Ordered(driver);
			Facility.sortColumn_Ordered(driver);//Sort in descending
			homePage.waitForPageLoader(driver);
			if(Facility.verifyMedication(driver, textDummy)){
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
