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

public class TC_11_OpenDoseVerification extends GetBrowserInstance
{
	//WebDriver driver = getDriver();
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "19";
	String vansahTestCaseID = "11";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_11_OpenDoseVerification";
	String testStep = "";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void openDoseVerification()
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


			//------- Verify if Today is selected as default -------
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

		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);

		}

	}//Close of first method

	@Test(dependsOnMethods = "openDoseVerification")
	public void verifyAllResidentsAvailability()
	{

		try{
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
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "There is no Open Dose round available for the test :( Unable to procceed. ", BHSLog_bit);
				Assert.fail("There is no open Doase Round Avaiable");
			}//Closing of Open dose logic
		}
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}
	}// Closing of method


	@Test(dependsOnMethods = "verifyAllResidentsAvailability")
	public void verifySearch()
	{
		try{

			testStep = "Click on All Tab";
			homePage.clickOn_AllTab(driver);
			Thread.sleep(1000);
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

		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);
		}

	}//end of method

	@Test(dependsOnMethods = "verifySearch")
	public void verifySortByName()
	{
		try
		{
			String sortByNameBtn = "//input[@value='Resident.ResidentName']";
			String listOfResident = "//h3[contains(@ng-bind,'ResidentName')]";
			testStep = "click on Sort By Name";
			key.click(driver, "xpath", sortByNameBtn);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);


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

	
	
	@Test(dependsOnMethods = "verifySortByName")
	public void verifySortByRoom()
	{
		try
		{
			String sortByRoomBtn = "//input[@value='Resident.RoomBedNumberForSorting']";
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
				roomListFromPlatform.add(Integer.parseInt(room.getText()));
			}
			List<Integer> tmp = new ArrayList<Integer>(roomListFromPlatform);
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
	}

}//Class close
