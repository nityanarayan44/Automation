package com.regression.TestCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.BestPack_SystemMaintenance;
import com.PageObjects.HomePage;
import com.PageObjects.ProgressNotes;
import com.PageObjects.UserManagement;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.Excel;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_128_AddNewUser_byFM extends GetBrowserInstance {

	/*
	 * ================================================================================
	 * --- [Global instances] ------------
	 * ================================================================================
	 */
		// #WebDriver object
		WebDriver driver 	= null;
			
		// #Class Instantiation
		Keywords keywords 				= new Keywords();		// Class object For webElement operations
		HomePage homePage 				= new HomePage();		// POM Class
		UserManagement usermgt			= new UserManagement();	// POM Class
		BestPack_SystemMaintenance sysMnt= new BestPack_SystemMaintenance(); //POM Class
		Excel excel						= null; // Exccel file utility
		String excelFile				= "";
		
		// #Vansah instances
		String CounterName		= "";
		StreamTest vansah 		= new StreamTest();
		String monitorCode 		= Constants.sitemon_Monitor;
		String vansahPackage 	= Constants.vansahPackage;
		String vansahRequirement= "8";
		String vansahTestCaseID = "128";
		String vansahBuild 		= Constants.build;
		String vansahRelease 	= Constants.release;
		String bhs_Environment 	= Constants.environment;
		String BHSLog_bit 		= Constants.log_Bit;
		String vansahTestcaseName = "TC_128_AddNewUser_byFM";
		String testStep = "";
		
		//--- #Other variables/instances
		String TestData_SheetName = "TC_128_addNewUserData";
		HashMap<String, String> userDetailsData = new HashMap<String, String>();
		List<String> userData 	= new ArrayList<String>();
		String userid 			= "";
		
	/*
	 * ================================================================================
	 * --- [Functions, as test] ------------
	 * ================================================================================
	 */

		
		//----------------------
		// #Driver initiation
		//----------------------
			@BeforeTest
			public void getBrowserInstance(){
				this.driver = getDriver();
			}
		
		//----------------------
		// #Test: Begin
		//----------------------
			@Test(priority = 1)
			public void addNewUser_byFM() {
				
				//Setting agent for this test in Vansah
				vansah.setProperty("sAgentName", Constants.vansahAgentName);
				try {
						
						// Performing Login into Application
							testStep = "User Perform Login as FM";
							homePage.performLogin(driver, Constants.USER_NAME_FM, Constants.PASSWORD_FM);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						//Wait for few millis.
							homePage.waitForPageLoader(driver);
							
						// Performing Selection of user management from setting
							testStep = "select user management option from settings";
							CounterName = "UserManagement-Page-Load";
							vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
							homePage.clickOn_UserManagement(driver);
							vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
							
						// Click on Add user button to add new user.
							testStep = "User clicks on add user button";
							usermgt.clickOnAddUserButton(this.driver);
							System.out.println("clicked on add user button");
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
							
						// Extracting the data from excel and setting it to hashmap
							excel = new Excel(Constants.excelFileForNewUserData);
							userData = excel.getRowData(this.TestData_SheetName, 1);
							//Verifying the received data from excel
							//for(String a : userData) { System.out.print(a + ", "); System.out.println("");}
							
							if( userData.get(0).contains(".") ) {
								this.userid = userData.get(0).substring(0, userData.get(0).indexOf("."));
							}else {
								this.userid = userData.get(0);
							}
							//Verify the extracted user id.
							//System.out.println("USER ID>>>> " + this.userid);
							this.userDetailsData = usermgt.extractUserData(userData);
							
						// Once retrieved the user id, increase it.
							//System.out.println("Id increased: " + (Integer.parseInt(this.userid)+1));
							excel.setDataToCell(0, 1, 0, (Integer.parseInt(this.userid)+1)+"" );
							
						// Fill the details in user details section and click next
							testStep = "Fill the details in user details section and click next";
							usermgt.step1_fillNewUserDetails(driver, this.userDetailsData);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
						// Wait for few millis
							homePage.waitForPageLoader(driver);
						
						// Choose the feature options
							testStep = "Select the feature and click next";
							usermgt.step2_fillNewUserDetails(driver, this.userDetailsData);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
						
						// Choose the report options
							testStep = "Select different reports if needed and click to create user";
							usermgt.step3_fillNewUserDetails(driver, this.userDetailsData);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
							
						// Check if user is added or not
						
						// Performing logout
							testStep = "User performs Logout";
							homePage.app_Logout(driver);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						/*-- [From here, we are using dependent test method] --*/
							
				} 
				catch(Exception e) {
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(	vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,  "fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
					Assert.fail(testStep + "--Failed!! ", e);
				}
			}
		
		//-------------------------------------------------------------------------
		// #Test, Depends on start test [next test to be followed after addNewUser]
		//-------------------------------------------------------------------------
			@Test(dependsOnMethods = "addNewUser_byFM")
			public void verifyHandOverNoteAccordingToDates()
			{
				try{
					// Login to BESTPack
						testStep = "User performs Login as pharmacy Manager";
						homePage.performLogin(driver, Constants.USER_NAME_PHM, Constants.PASSWORD_PHM);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Wait for few millis
						homePage.waitForPageLoader(driver);
				
					// Select user under system administration
					// Go inside the system maintenance menu
						homePage.clickOn_SystemMaintenance(driver);
						
					// Wait for few millis
						homePage.waitForPageLoader(driver);
				
					// Select user menu under system
						testStep = "Select user menu under system maintenance";
						sysMnt.clickOn_userSearchMenu(driver);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Wait for few millis
						homePage.waitForPageLoader(driver);
				
					// Search user under system administration and verify the changes
						testStep = "Search user under system administrationr";
						sysMnt.enterUserId(driver, this.userid);
						sysMnt.clickOnSearchButton(driver);
						
					// verify the changes
						testStep = "verify the changes";
						String searchResult_userId = sysMnt.getTextAccordingHeaderName(driver, "user id");
						//System.out.println("\n RECIEVED USER ID: " + searchResult_userId + " \n");
						Assert.assertEquals(searchResult_userId, this.userid);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					// Step Done.
						
				}// end of try
				catch (Exception e) {
					e.printStackTrace();
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
					vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! at Following TestStep "+testStep+"is the stack trace: ", 2);
					Assert.fail(testStep + "--Failed!!");
				}
			}
		
// #BOTTOM	
} /* EOClass */
