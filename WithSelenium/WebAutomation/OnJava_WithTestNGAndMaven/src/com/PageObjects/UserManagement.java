package com.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utills.Keywords;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SuppressWarnings("unused")
public class UserManagement {
	
	// Global objects or reference variables
	//---------------------------------------------------------------------------------
		Keywords keywords 			= new Keywords();	// Class object For webElement operations
		String options_UserRoles[] 	= null;
		String options_Salutation[] = null;
		String[] fields 			= { "userID", 
										"userPassword", 
										"userName", 
										"userJobTitle", 
										"userContactNo",
										"userEmail",
										"userRole", 
										"userFeatures", 
										"userReports",
										"userFacilities"
									};
		String activeStatusName		= "Active";
		String inactiveStatusName	= "InActive";
		String suspendedStatusName	= "Suspended";
	/*
	 * ================================================================================
	 * --- [Locators value for User Management page] ------------
	 * ================================================================================
	 */
		String field_userSearchBox			= ".//input[@id='userSearch']";
		String btn_searchFilter_ActiveUser 	= ".//input[@id='userStatusFilterActive']";
		String btn_searchFilter_AllUser		= ".//input[@id='userStatusFilterAll']";
		String btn_addUser					= ".//*[@id='page-wrapper']//button[contains(@ng-click,'newUser')]";
		String popup_newUser 				= ".//*[@id='userEditModal']";
		String updateUserStatusBtn			= ".//button[contains(@ng-disabled, 'isUserSelected')]";
		String updateUserStatusActiveBtn	= ".//*[contains(@ng-click, \"updateUsersStatus('Active')\")]";
		String updateUserStatusInActiveBtn	= ".//*[contains(@ng-click, \"updateUsersStatus('InActive')\")]";
		String updateUserStatusSuspendedBtn	= ".//*[contains(@ng-click, \"updateUsersStatus('Suspended')\")]";
		String btn_unlockUser				= ".//button[contains(@ng-click, 'unlockUsersAccount()')]";
		
		// Currently listed users locators
		String all_listedUserName			= ".//*[@id='page-wrapper']//table/tbody//td[1]";
		String all_listedUserLoginId		= ".//*[@id='page-wrapper']//table/tbody//td[2]";
		String all_listedUserRole			= ".//*[@id='page-wrapper']//table/tbody//td[3]";
		String all_listedUserStatus			= ".//*[@id='page-wrapper']//table/tbody//td[4]";
		String all_listedUserSelectCkBox	= ".//*[@id='page-wrapper']//table/tbody//td[5]";
		
		//Loadfing div
		String loadingDiv = "//*[@id='page-wrapper']//div[@class='k-loading-image']";
		String loader = "//*[contains(@class,'k-loading-image')]";
		
		//----------------------------------
		// New User Dialog element locators
		//----------------------------------
				String popup_btn_createUser				= ".//*[@id='userEditModal']//button[contains(@ng-click, 'confirmAction')]";
				String popup_btn_cancel					= ".//*[@id='userEditModal']//button[contains(@ng-click, 'cancelAction')]";
				String popup_btn_next					= ".//*[@id='userEditModal']//button[contains(@ng-click, 'nextStage')]";
				String popup_btn_back					= ".//*[@id='userEditModal']//button[contains(@ng-click, 'backStage')]";
				
			// [1] User details fields
				String popup_field_userId 				= ".//*[@id='userid']";
				String popup_field_userRole				= ".//*[contains(@ng-change, 'userRoleChange')]"; // ele.selectedIndex = choose_from_options_length
				String userRoleAvailableOptions[]		= {"Administration", "Agency AIN", "Agency Registered Nurse", "AIN", "Clinical Pharmacist", "Doctor", "Enrolled Nurse", "Management", "Registered Nurse"};
				String popup_field_userJobTitle			= ".//*[@id='jobtitle']";
				String popup_field_userPassword			= ".//*[@id='userpassword']";
				String popup_field_userPasswordRetype	= ".//*[@id='retypepassword']";
				String popup_field_userSalutation		= ".//*[contains(@ng-model, 'newUser.Salutation')]"; // ele.selectedIndex = choose_from_options_length
				String popup_field_userFirstName 		= ".//*[@id='firstName']";
				String popup_field_userLastName 		= ".//*[@id='lastName']";
				String popup_field_userEmail 			= ".//*[@id='useremail']";
				String popup_field_userContactNo 		= ".//*[@id='contact']";
				
			// [2] User features fields [checkboxes]
				String popup_btn_allFeatures			= ".//*[@id='userfeatures']/table//input[contains(@ng-model, 'allFeatures')]";
				String popup_all_featureOptions			= ".//*[@id='userfeatures']/table//input[contains(@ng-model, 'Selected')]";
				
			// [3] Report options for User
				String popup_btn_allReports				= ".//*[@id='userreport']/table//input[contains(@ng-model, 'allReports')]";
				String popup_all_reportOptions			= ".//*[@id='userreport']/table//input[contains(@ng-model, 'Selected')]";
				
			// [4] Facility options for user
				String popup_btn_allFacility			= ".//*[@id='userfacilities']/table//input[contains(@ng-model, 'allFacilities')]";
				String popup_all_facilityOptions		= ".//*[@id='userfacilities']/table//input[contains(@ng-model, 'Selected')]";
	/*
	 * ================================================================================
	 * --- [Functions for User Management page] ------------
	 * ================================================================================
	 */
		// Wait, if any loading is happening
		public boolean waitForPageLoader(WebDriver driver)
		{
			int timer1 = 2; 
			int timer2 = 40;
			WebDriverWait wait1 = new WebDriverWait(driver, timer1);	
			WebDriverWait wait2 = new WebDriverWait(driver, timer2);	
			//wait for visibility
			try{
				if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loader))) != null){
					//wait for invisibility
					if(wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader)))) { return true; } else{ return false; }
				}else{
					return false;
				}
			}catch(Exception e){
				return false;
			}
		}// End of method

		// Apply Search filter to show all users.
		public void applySearchFilter_All(WebDriver driver) throws Exception {
			keywords.click(driver, "xpath", this.btn_searchFilter_AllUser);
			return;
		}

		// Apply Search filter to show only active users.
		public void applySearchFilter_Active(WebDriver driver) throws Exception {
			keywords.click(driver, "xpath", this.btn_searchFilter_ActiveUser);
			return;
		}
		
		// search for an user
		public void searchUser(WebDriver driver, String userName) throws Exception {
			keywords.clearText(driver, "xpath", this.field_userSearchBox);
			keywords.EnterText(driver, "xpath", this.field_userSearchBox, userName);
			return;
		}
		
		// Get the first user id.
		public String getFirstUserId(WebDriver driver) throws Exception {
			 return keywords.getText(driver, "xpath", this.all_listedUserLoginId);
		}
		
		// Get the first user id.
		public String getFirstUserStatus(WebDriver driver) throws Exception {
			 return keywords.getText(driver, "xpath", this.all_listedUserStatus);
		}
		
		// select first user and choose the status
		public void selectFirstUserAndChangeStatus(WebDriver driver, String changeStatusTo) throws Exception {
			// Select the first listed Resident
				List<WebElement> allUserSelectCheckEle = keywords.fetch_AllElements(driver, this.all_listedUserSelectCkBox);
				for(WebElement chkBox : allUserSelectCheckEle ){ chkBox.click(); break; }
			// Click on Update status button and choos a status
				keywords.click(driver, "xpath", this.updateUserStatusBtn);
				if(changeStatusTo.toLowerCase().equals(this.activeStatusName.toLowerCase())) {
					keywords.click(driver, "xpath", this.updateUserStatusActiveBtn);
				}else if(changeStatusTo.toLowerCase().equals(this.inactiveStatusName.toLowerCase()) ) {
					keywords.click(driver, "xpath", this.updateUserStatusInActiveBtn);
				}else if(changeStatusTo.toLowerCase().equals(this.suspendedStatusName.toLowerCase())) {
					keywords.click(driver, "xpath", this.updateUserStatusSuspendedBtn);
				}
			// Changes Status done.
				//System.out.println("Status changes has been done.");
			return;
		}
		
		// Unlock an user.
		public void unlockUser(WebDriver driver) throws Exception {
			// Select the first listed Resident
				List<WebElement> allUserSelectCheckEle = keywords.fetch_AllElements(driver, this.all_listedUserSelectCkBox);
				for(WebElement chkBox : allUserSelectCheckEle ){ chkBox.click(); break; }
			// Click on Update status button and choos a status
				keywords.click(driver, "xpath", this.btn_unlockUser);
			// Changes Status done.
				//System.out.println("Status changes has been done.");
			return;
		}
		
		// Click on AddUser button.
		public void clickOnAddUserButton(WebDriver driver) throws Exception {
			keywords.click(driver, "xpath", this.btn_addUser);
			return;
		}
		
		// Click on AddUser's cancel button.
		public void clickOnCancelButton(WebDriver driver) throws Exception {
			keywords.click(driver, "xpath", this.popup_btn_cancel);
			return;
		}
		
		// Fill the new users details
		public void step1_fillNewUserDetails(WebDriver driver, HashMap<String, String> userDetails) throws Exception {
			// Check for the provided details [size should be 9, because there are 10 parameters] [excluding password ]
			// Filling the data
				//userID
				keywords.clearText(driver, "xpath", this.popup_field_userId);
				String userId = userDetails.get("userID");
				if( userId.contains(".") == true ) {
					keywords.EnterText(driver, "xpath", this.popup_field_userId, userId.substring(0, userId.indexOf(".")));
				}else {
					keywords.EnterText(driver, "xpath", this.popup_field_userId, userId);
				}
				
				//User FirstName
				keywords.clearText(driver, "xpath", this.popup_field_userFirstName);
				keywords.EnterText(driver, "xpath", this.popup_field_userFirstName, ((userDetails.get("userName")).split(" "))[1] );
				//User LastName
				keywords.clearText(driver, "xpath", this.popup_field_userLastName);
				keywords.EnterText(driver, "xpath", this.popup_field_userLastName, ((userDetails.get("userName")).split(" "))[2] );
				//User Email
				keywords.clearText(driver, "xpath", this.popup_field_userEmail);
				// userDetails.get("userEmail")
				keywords.EnterText(driver, "xpath", this.popup_field_userEmail, userDetails.get("userEmail") );
				//User Contact No
				keywords.clearText(driver, "xpath", this.popup_field_userContactNo);
				keywords.EnterText(driver, "xpath", this.popup_field_userContactNo, (userDetails.get("userContactNo")).trim() );
				// User password
				keywords.clearText(driver, "xpath", this.popup_field_userPassword);
				keywords.EnterText(driver, "xpath", this.popup_field_userPassword, userDetails.get("userPassword"));
				// Password retype
				keywords.clearText(driver, "xpath", this.popup_field_userPasswordRetype);
				keywords.EnterText(driver, "xpath", this.popup_field_userPasswordRetype, userDetails.get("userPassword"));
				// User job Title
				keywords.clearText(driver, "xpath", this.popup_field_userJobTitle);
				keywords.EnterText(driver, "xpath", this.popup_field_userJobTitle, userDetails.get("userJobTitle"));
				
				// Handle the options according the provided data
				keywords.selectFromDropDown(driver, "xpath", this.popup_field_userRole, "Text", (userDetails.get("userRole")) );
				keywords.selectFromDropDown(driver, "xpath", this.popup_field_userSalutation, "Text", ((userDetails.get("userName")).split(" "))[0]);
				
//					// Setting user role.
//						//System.out.println("Role= " + (userDetails.get("userRole")).substring(0, userDetails.get("userRole").indexOf(".")) );
//						int userRoleIndex = -1;
//						userRoleIndex = Integer.parseInt( (userDetails.get("userRole")).substring(0, userDetails.get("userRole").indexOf(".")) );
//						WebElement roleElement = driver.findElement(By.xpath(this.popup_field_userRole));
//						JavascriptExecutor jseForRole = (JavascriptExecutor) driver;
//						if(userRoleIndex != -1) // if provided role found witing role options
//							jseForRole.executeScript("arguments[0].selectedIndex = arguments[1];", roleElement, userRoleIndex);
//						else  // if provided role not found witing role options
//							jseForRole.executeScript("arguments[0].selectedIndex = 0;", roleElement);
//						
//					// Setting user salutation
//						int userSalutationIndex = this.getSalutationIndex(driver, ((userDetails.get("userName")).split(" "))[0] );
//						WebElement salutationElement = driver.findElement(By.xpath(this.popup_field_userSalutation));
//						JavascriptExecutor jseForSalutation = (JavascriptExecutor) driver;
//						if(userRoleIndex != -1) // if provided role found witing role options
//							jseForSalutation.executeScript("arguments[0].selectedIndex = arguments[1];", salutationElement, userSalutationIndex);
//						else  // if provided role not found witing role options
//							jseForSalutation.executeScript("arguments[0].selectedIndex = 0;", salutationElement);
				
			// clicking to next button
				keywords.click(driver, "xpath", this.popup_btn_next);
			return;
		}
		
		// step-2 fillNewUserDetails
		public void step2_fillNewUserDetails(WebDriver driver, HashMap<String, String> userDetails) throws Exception { 
			// if you want to add all the features then
			//keywords.click(driver, "xpath", this.popup_btn_allFeatures);
			//and press next
			keywords.click(driver, "xpath", this.popup_btn_next);
		}
		
		// step-3 fillNewUserDetails
		public void step3_fillNewUserDetails(WebDriver driver, HashMap<String, String> userDetails) throws Exception { 
			// if you want to add all the reports then
			//keywords.click(driver, "xpath", this.popup_btn_allReports);
			//and press create user
			//keywords.click(driver, "xpath", this.popup_btn_next);
			keywords.click(driver, "xpath", this.popup_btn_createUser);
		}
		
		// step-2 fillNewUserDetails
		public void step4_fillNewUserDetails(WebDriver driver, HashMap<String, String> userDetails) throws Exception { 
			// if you want to add all the facility then
			//keywords.click(driver, "xpath", this.popup_btn_allFacility);
			//and press next
			keywords.click(driver, "xpath", this.popup_btn_createUser);
		}
		
		public int getSalutationIndex(WebDriver driver, String salutation) {
			int index = -1;
			index = (salutation.toLowerCase().equalsIgnoreCase("mr.")) ? 1 : 
						( (salutation.toLowerCase().equalsIgnoreCase("mrs.")) ? 2 : 
							( (salutation.toLowerCase().equalsIgnoreCase("miss.")) ? 3 : 
								( (salutation.toLowerCase().equalsIgnoreCase("ms.")) ? 4 : 0 ) ) );
			//System.out.println(">>> All Salutation... " + index);
			return index;
		}
		
		// Extract the list data and set it into HashMap and return
		public HashMap<String, String> extractUserData(List<String> data) {
			HashMap<String, String> hmData = new HashMap<String, String>();
			//putting key for the provided list
			//System.out.println("Adding keys...");
			for(int index=0; index<data.size(); index++) { 
				hmData.put(this.fields[index], data.get(index)); 
				//System.out.println( "KEY: "+this.fields[index]+" === VAL: "+data.get(index));
			}
			return hmData;
		}
		
}
