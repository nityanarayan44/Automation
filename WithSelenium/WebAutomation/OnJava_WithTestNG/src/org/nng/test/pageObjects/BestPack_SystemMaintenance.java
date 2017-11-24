package org.nng.test.pageObjects;

import java.util.List;

import org.nng.test.utills.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestPack_SystemMaintenance {

	// Global objects or reference variables
	//---------------------------------------------------------------------------------
		Keywords keywords 			= new Keywords();	// Class object For webElement operations
		
	/*
	 * ================================================================================
	 * --- [Locators value for User Management page] ------------
	 * ================================================================================
	 */
		// Loader
			String loader = "//div[contains(@class,'loading')]";
			
		//Menu Icons
			String searchUserMenuIcon			= ".//img[contains(@src, 'SearchUser')]";
			
		//Operations
			String btn_newUser 					= "";
			String btn_updateUserStatus			= "";
			String btn_resetPIN					= "";
			String btn_resetPassword			= "";
			String btn_unlockAccount			= "";
		
		//Search User fields
			String field_userIdInput 			= ".//input[@name='userId' and contains(@ng-model, 'ctrl.userIdTyped')]";
			String btn_searchUser				= ".//*[@id='btnSearch' and contains(@ng-click, 'ctrl.search')]";
			
		// Result after search
			String all_userListHeader			= ".//div[contains(@class, 'k-grid-header')]//tr[@role='row']/th";
			String all_userListContent			= ".//div[contains(@class, 'k-grid-content')]//tr[@role='row' and contains(@class, 'ng-scope')]/td"; /* 8th cell is status */
			
	/*
	 * ================================================================================
	 * --- [Functions for User Management page] ------------
	 * ================================================================================
	 */
			// Go to user search menu
				public void clickOn_userSearchMenu(WebDriver driver) throws Exception {
					keywords.click(driver, "xpath", this.searchUserMenuIcon);
					return;
				}
			
			// pass the userId to input field
				public void enterUserId(WebDriver driver, String userId) throws Exception { 
					keywords.EnterText(driver, "xpath", this.field_userIdInput, userId);
					return;
				}
			// Click on search button 
				public void clickOnSearchButton(WebDriver driver) throws Exception {
					keywords.click(driver, "xpath", this.btn_searchUser);
					return;
				}
			
			
			// Return the index based on header value for a row.
				public int getIndexFromRow(WebDriver driver, String headerValue) throws Exception {
					int index = -1, i=0;
					List<WebElement> allHeaders = keywords.fetch_AllElements(driver, this.all_userListHeader);
					for(WebElement header : allHeaders ){
						i++;
						if((header.getText().toLowerCase()).contains(headerValue.toLowerCase())) {
							index = i;
							break;
						}
					}
					return index;
				}
				
			// get the text according to provided header name.
				public String getTextAccordingHeaderName(WebDriver driver, String headerName) throws Exception {
					int index = this.getIndexFromRow(driver, headerName);
					return keywords.getText(driver, "xpath", this.all_userListContent+"["+index+"]");
				}
			
				
			//==========================================================================
				// Wait, if any loading is happening
				public boolean waitForPageLoader(WebDriver driver) throws Exception {
					int timer1 = 2, timer2 = 40;
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
				
/*BOTTOM*/
} /*END OF CLASS*/
