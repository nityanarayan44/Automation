package com.regression.TestCases;

import java.util.ArrayList;
import java.util.Collections;
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

public class TC_03_VeriffyOutofDoseRound extends GetBrowserInstance
{
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "7";
	String vansahTestCaseID = "3";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_03_VeriffyOutofDoseRound";
	String testStep = "";
	
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void verifyResidents_OutofDose()
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
			
			
			testStep = "Verify if today is selected as system default";
			if(homePage.verify_IfTodayIsSelected(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
				Assert.fail("Today is not selected as Default");
			}
			
			testStep = "User Clicks on 'Out of Dose' Round";
			CounterName = "OutOfDoseRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_OutOfDoseRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(2000);
			//-----
			//----- Verify All Tabs ------			
			testStep = "Verify Presence of all the tabs in Main Dose Round Page";
			if(homePage.verify_presenceOfTabs(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
			}

			//verify if resident list is available in All Tab
			testStep = "Verify Presence of residents lists in All Tab";
			if(homePage.verify_PresenceOfResidentList(driver)){

				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
			}

			//Verify if resident list is available in Packed Tab
			testStep = "Verify Presence of residents lists in Packed Tab";
			homePage.clickOn_PackedTab(driver);
			if(homePage.verify_PresenceOfResidentList(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}

			//Verify if resident list is available in nonPacked Tab
			testStep = "Verify Presence of residents lists in NonPacked Tab";
			homePage.clickOn_NonPackedTab(driver);
			if(homePage.verify_PresenceOfResidentList(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}

			//Verify if resident list is available in Insulin Tab
			testStep = "Verify Presence of residents lists in Insulin Tab";
			homePage.clickOn_InsulinTab(driver);
			if(homePage.verify_PresenceOfResidentList(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}

			//Verify if resident list is available in S8 Tab
			testStep = "Verify Presence of residents lists in S8 Tab";
			homePage.clickOn_S8Tab(driver);
			if(homePage.verify_PresenceOfResidentList(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}

			//Verify if resident list is available in Variable Tab
			testStep = "Verify Presence of residents lists in Variable Tab";
			homePage.clickOn_VariableTab(driver);
			if(homePage.verify_PresenceOfResidentList(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
			}
			//-----
			
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);

		}
	
	}// end of method
	
	
	@Test(priority = 2)
	public void verifySearch_OutofDose()
	{
		try{

			testStep = "Click on All Tab";
			homePage.clickOn_AllTab(driver);
			Thread.sleep(1000);
			//String searchBox = "residentSearch";
			String searchBox = "//input[@id='residentsearch']";
			
			String resNameAfterSearch = "(//h3[contains(@ng-bind,'ResidentName')])[1]";

			//get resident name
			String resName = homePage.get_ResidentNameFromList(driver);
			//input in search Box
			testStep = "Enter Resident name in Search Box";
			key.EnterText(driver, "xpath", searchBox, resName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Verify Search Logic
			testStep = "Verify Search Result";
			String resName2 = key.getText(driver, "xpath", resNameAfterSearch);
			System.out.println(resName + "------" +resName2);
			if(resName.equals(resName2)){

				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);	
			}

			//Remove Search Results
			key.clearText(driver, "xpath", searchBox);

		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}

	}//end of method

	@Test(priority = 3)
	public void verifySortByName_OutofDose()
	{
		try
		{
			String sortByNameBtn = "//input[@value='Resident.ResidentName']";
			String listOfResident = "//h3[contains(@ng-bind,'ResidentName')]";
			
			testStep = "click on Sort By Name";
			key.click(driver, "xpath", sortByNameBtn);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			Thread.sleep(1000);
			// Logic to check sort By nAME
			testStep = "verify if the residentList is sorted 'By Name' ";
			List<WebElement> fetchNameElementFromPlatform = key.fetch_AllElements(driver, listOfResident);

			List<String> nameListFromPlatform= new ArrayList<String>();

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

		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}
	}// end of method


	@Test(priority = 4)
	public void verifySortByRoom_OutofDose()
	{
		try
		{
			String sortByRoomBtn = "//input[@value='Resident.RoomBedNumberForSorting']";
			String listOfResidentRooms = "//span[contains(@ng-bind,'RoomBedNumber')]";

			testStep = "click on Sort By Room";
			key.click(driver, "xpath", sortByRoomBtn);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(1000);
			// Logic to check sort By Room
			testStep = "verify if the residentLists is sorted 'By Room' ";
			List<WebElement> fetchRoomElementFromPlatform = key.fetch_AllElements(driver, listOfResidentRooms);

			List<String> roomListFromPlatform= new ArrayList<String>();

			for(WebElement room: fetchRoomElementFromPlatform ){		
				roomListFromPlatform.add(room.getText());
			}
			List<String> tmp = new ArrayList<String>(roomListFromPlatform);
			Collections.sort(tmp);
			boolean sorted = tmp.equals(roomListFromPlatform);
			System.out.println("room from platform-->" + roomListFromPlatform);
			System.out.println("sorted rooms-->" + tmp);

			if(sorted){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :(", BHSLog_bit);
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
