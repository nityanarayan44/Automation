package com.regression.TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class TC_160_VerifySearch_MedicationChartPage extends GetBrowserInstance
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
	String vansahTestCaseID = "160";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_160_VerifySearch_MedicationChartPage";
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
	public void verifySearch_MedicationChartPage() 
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
			
			
			
			testStep = "User clicks on Administrative Assistant";
			homePage.clickOn_AdminAssist(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//homePage.waitForPageLoader(driver);
			
			testStep = "User clicks on Medication Chart";
			homePage.clickOn_MedicationChart(driver);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//verify if resident list is available in All Tab
			testStep = "User Verifies the Presence of residents lists";
			if(homePage.verify_PresenceOfResidentList(driver)){

				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
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
	
	@Test(priority = 2, dependsOnMethods = {"verifySearch_MedicationChartPage"})
	public void verifySearch()
	{
	
		try
		{
		
			String searchBox = "residentSearch";
			String resNameAfterSearch = "(//h3[contains(@ng-bind,'ResidentName')])[1]";

			//get resident name
			String resName = homePage.get_ResidentNameFromList(driver);
			//input in search Box
			testStep = "Enter Resident name in Search Box";
			key.EnterText(driver, "id", searchBox, resName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Verify Search Logic
			testStep = "Verify Search Result";
			String resName2 = key.getText(driver, "xpath", resNameAfterSearch);
			System.out.println(resName + "------" +resName2);
			if(resName.equals(resName2)){
				System.out.println(testStep + "-- Passed");
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);	
			}

			//Remove Search Results
			key.clearText(driver, "id", searchBox);
			
		}// end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// end of method
	
	@Test(priority = 3, dependsOnMethods = {"verifySearch"})
	public void verifySortOrder()
	{
	
		try
		{
		
			//-----------------Verify SortBy Name-------------------------------//
			String sortByNameBtn = "//input[@value='ResidentName']";
			String listOfResident = "//h3[contains(@ng-bind,'ResidentName')]";
			
			testStep = "click on Sort By Name";
			key.click(driver, "xpath", sortByNameBtn);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


			// Logic to check sort By Name
			testStep = "verify if the residentList is sorted 'By Name' ";
			List<WebElement> fetchNameElementFromPlatform = key.fetch_AllElements(driver, listOfResident);
			List<String> nameListFromPlatform = new ArrayList<String>();

			for(WebElement name: fetchNameElementFromPlatform ){		
				nameListFromPlatform.add(name.getText());
			}
			List<String> tmp = new ArrayList<String>(nameListFromPlatform);
			Collections.sort(tmp);
			boolean sorted = tmp.equals(nameListFromPlatform);
			System.out.println("name from platform-->" + nameListFromPlatform);
			System.out.println("sorted name-->" + tmp);

			if(sorted){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}
			
			
			
			
			//-----------------Verify SortBy Room-------------------------------//		
			String sortByRoomBtn = "//input[@value='RoomBedNumberForSorting']";
			String listOfResidentRooms = "//span[contains(@ng-bind,'RoomBedNumber')]";

			testStep = "click on Sort By Room";
			key.click(driver, "xpath", sortByRoomBtn);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			// Logic to check sort By Room
			testStep = "verify if the residentLists is sorted 'By Room' ";
			List<WebElement> fetchRoomElementFromPlatform = key.fetch_AllElements(driver, listOfResidentRooms);

			List<Integer> roomListFromPlatform= new ArrayList<Integer>();

			for(WebElement room: fetchRoomElementFromPlatform ){		
				roomListFromPlatform.add(Integer.parseInt(room.getText())); // get rooms and add into list
			}
			List<Integer> tmp1 = new ArrayList<Integer>(roomListFromPlatform);
			Collections.sort(tmp1);
			boolean sortedRoom = tmp1.equals(roomListFromPlatform);
			System.out.println("room from platform-->" + roomListFromPlatform);
			System.out.println("sorted rooms-->" + tmp1);

			if(sortedRoom){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
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
