package org.nng.test.regression.TestCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.BestPack_SystemMaintenance;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.pageObjects.ProgressNotes;
import org.nng.test.pageObjects.UserManagement;
import org.nng.test.utills.Excel;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_130_UnlockedAnUserAccountStatus_byFM extends GetBrowserInstance {

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
		
		// #Vansah instances
		String CounterName		= "";
		StreamTest vansah 		= new StreamTest();
		String monitorCode 		= Constants.sitemon_Monitor;
		String vansahPackage 	= Constants.vansahPackage;
		String vansahRequirement= "8";
		String vansahTestCaseID = "130";
		String vansahBuild 		= Constants.build;
		String vansahRelease 	= Constants.release;
		String bhs_Environment 	= Constants.environment;
		String BHSLog_bit 		= Constants.log_Bit;
		String vansahTestcaseName = "TC_130_UnlockedAnUserAccountStatus_byFM";
		String testStep = "";
		
		//--- #Other variables/instances
		String activeStatusName		= "Active";
		String inactiveStatusName	= "InActive";
		String suspendedStatusName	= "Suspended";
		String userid 				= Constants.USER_NAME_RND_1;
		String userStatus			= "";
		String changeStatusTo		= "";
	
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
		
		//--------------------------
		// #Test: Locking an User.
		//--------------------------
			@Test(priority = 1)
			public void lockAnUser_byFM() {
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
							
						// Search user under system administration and verify the changes
							testStep = "Search user under system administration";
						// List all user
							usermgt.applySearchFilter_All(driver);
							usermgt.searchUser(driver, this.userid);
							
						// Select the resident, whose update has to be updated
							testStep = "Select the resident, and Select the status from drop down";
							this.userStatus = usermgt.getFirstUserStatus(driver);
							this.changeStatusTo = "Suspended";
							usermgt.selectFirstUserAndChangeStatus(driver, this.changeStatusTo);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
						
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
		// #Test, Unlocking an User.
		//-------------------------------------------------------------------------
			@Test(priority = 2, dependsOnMethods = "lockAnUser_byFM")
			public void unlockAnUser_byFM() {
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
							
						// Search user under system administration and verify the changes
							testStep = "Search user under system administration";
						// List all user
							usermgt.applySearchFilter_All(driver);
							usermgt.searchUser(driver, this.userid);
							
						// Select the resident, whose update has to be updated
							testStep = "Select the resident, and Select the status from drop down";
							usermgt.unlockUser(driver);
							vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
						
						// Wait for few millis
							homePage.waitForPageLoader(driver);
						
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
		// #Test, Verifying the changes.
		//-------------------------------------------------------------------------
			@Test(priority = 3, dependsOnMethods = "unlockAnUser_byFM")
			public void verifyChanges() throws Exception{
				try{
					// Login to BESTPack
						testStep = "User performs Login as pharmacy Manager";
						homePage.performLogin(driver, Constants.USER_NAME_PHM, Constants.PASSWORD_PHM);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					// Wait for few millis
						homePage.waitForPageLoader(driver);
						
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
						testStep = "Search user under system administrationr, and verify the changes";
						sysMnt.enterUserId(driver, this.userid);
						sysMnt.clickOnSearchButton(driver);
						
					// Wait for few millis
						homePage.waitForPageLoader(driver);
						
					// verify the changes
						testStep = "verify the changes";
						String actualUserStatus = sysMnt.getTextAccordingHeaderName(driver, "status");
						System.out.println("Current User ID		: " + this.userid);
						System.out.println("Current User Status : " + actualUserStatus);
						Assert.assertEquals(actualUserStatus, this.activeStatusName);
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
