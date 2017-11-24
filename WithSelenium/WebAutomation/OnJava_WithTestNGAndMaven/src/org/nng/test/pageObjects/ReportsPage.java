// All the Page Objects related to Reports Page

package org.nng.test.pageObjects;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ReportsPage 
{

	Keywords key = new Keywords();

	// ################ ---- Element Locators ----------- ##########
		String reports 			= "//img[@alt='Reports']";
		String adminstration 	= "//img[contains(@src,'AdminReport')]";
		String startDate 		= "dtStartDate";
		String endDate 			= "dtEndDate";
		String regular 			= "//input[contains(@ng-model,'includesRegular')]";
		String emergency 		= "//input[contains(@ng-model,'includesEmergency')]";
		String prn 				= "//input[contains(@ng-model,'includesPrn')]";
		String btnGenerate 		= "//button[text()='Generate']";
		String nurseInitiated 	= "//input[contains(@ng-model,'includesNim')]";
		String selectResident 	= "ddlNonEmptyResident";
		String missedAdministration = "//img[contains(@src,'MissedAdministration')]";
		
	// ------------ HandOver Menu Icon [Home > Reports > HandOver ] ---------------------------
		String reports_handoverMenuIcon 	= ".//img[contains(@src,'/images/HandOver.png')]";
		String handOver_NoteFilter_checkBox = ".//input[@name='Order' and contains(@ng-click, 'filterResult')]";
		String residentSearchTextBox		= "search";
		String dateFrom						= "from";
		String dateTo						= "to";
		String searchButton					= ".//button[contains(@ng-click, 'ctrl.onSearchClick')]";
		String residentList					= ".//tbody[contains(@role, 'rowgroup')]/tr//span[contains(@ng-bind, 'dataItem.ResidentName')]";
		String arrows						= ".//tbody[contains(@role, 'rowgroup')]/tr/td[contains(@class, 'k-hierarchy-cell')]/a";
		String popup_dateRangeError			= ".//html/body//div[contains(@class,'k-notification-wrap')]";
		String popup_dateRangeErrorMsg		= "Error loading report";
		
		String handoverNoteSection			= ".//*[@id='handoverDetailGrid']";
		String all_HandOverNoteDates		= ".//*[@id='handoverDetailGrid']//table/tbody//span[contains(@ng-bind, 'DisplayDate')]";
		String all_handoverNote_CreatedBy	= ".//*[@id='handoverDetailGrid']//table/tbody//span[contains(@ng-bind, 'CreatedByName')]";
		String all_HandOverNoteText			= ".//*[@id='handoverDetailGrid']//table/tbody/tr/td[3]";
		String all_handOverNote_deleteIcon	= ".//*[@id='handoverDetailGrid']//table/tbody//div/span[contains(@ng-click, 'deleteHandover')]";
		
		String all_availableResidentNames	= ".//*[@id='handoverGrid']//table/tbody//td/span[contains(@ng-bind, 'ResidentName')]";
		// First Resident on the resident list
		String firstResidentName_UnderHandOver			= ".//*[@id='handoverGrid']//table/tbody/tr[1]/td[3]";
		String FirstResidentAddNoteButton_UnderHandOver	= ".//*[@id='handoverGrid']//table/tbody/tr[1]/td[6]/button[contains(@ng-click, 'add')]";
	
	
	// ################ ---- Page Object Logics ----------- ##########

	//Click on reports 
	public void clickOn_Reports(WebDriver driver){
		key.click(driver, "xpath", reports);
	}

	//Click on administration 
	public void clickOn_Adminstration(WebDriver driver){
		key.click(driver, "xpath", adminstration);
	}

	//Click on missed Administration 
	public void clickOn_missedAdminstration(WebDriver driver){
		key.click(driver, "xpath", missedAdministration);
	}


	//Enter Start Date
	public void enterStartDate(WebDriver driver, String date){
		key.clearText(driver, "id", startDate);
		key.EnterText(driver, "id", startDate, date);
		//driver.findElement(By.xpath(datePicker)).sendKeys(Keys.RETURN);
	}

	//Enter End Date
	public void enterEndDate(WebDriver driver, String date){
		key.clearText(driver, "id", endDate);
		key.EnterText(driver, "id", endDate, date);
	}

	public void selectResident(WebDriver driver, String ResidentName){
		key.selectFromDropDown(driver, "id", selectResident, "Text", ResidentName);
	}

	//Click on regular checkbox 
	public void clickOn_RegularCheckbox(WebDriver driver){
		key.click(driver, "xpath", regular);
	}

	//Click on nurseInitiated checkbox 
	public void clickOn_nurseInitiatedCheckbox(WebDriver driver){
		key.click(driver, "xpath", nurseInitiated);
	}

	//Click on emergency checkbox 
	public void clickOn_EmergencyCheckbox(WebDriver driver){
		key.click(driver, "xpath", emergency);
	}

	//Click on PRN checkbox 
	public void clickOn_PRNCheckbox(WebDriver driver){
		key.click(driver, "xpath", prn);
	}

	//Click on nurseInitiated checkbox 
	public void clickOn_generateBtn(WebDriver driver){
		key.click(driver, "xpath", btnGenerate);
	}

	/*
	 * ================================================================================
	 * --- HANDOVER PAGE FUNCTIONs ------------
	 * ================================================================================
	 */
		// Click on HandOver menu icon reports 
		public void clickOn_HandOver(WebDriver driver){
			key.click(driver, "xpath", this.reports_handoverMenuIcon);
		}
		
		// Click on HandOver menu icon reports 
		public void searchForResident(WebDriver driver, String residentName) throws Exception{
			key.clearText(driver, "id", this.residentSearchTextBox);
			key.click(driver, "id", this.residentSearchTextBox);
			key.EnterText(driver, "id", this.residentSearchTextBox, residentName);
		}
		
		// Expand arrow for current resident list
		public void expandEachResident(WebDriver driver) throws Exception {
			// Expending resident list...
				List<WebElement> allArrow = key.fetch_AllElements(driver, this.arrows);
				for(WebElement arrow: allArrow ){ arrow.click(); Thread.sleep(2000); }
		}
		
		// Click on search button under handover notes
		public void clickOn_searchButtonUnderHandOver(WebDriver driver){
			key.click(driver, "xpath", this.searchButton);
		}
		
		// get the current status of the 'Without Note' check box.
		public boolean getCurrentCheckBoxStatus(WebDriver driver) {
			String status = key.getElementAttrib(driver, "xpath", this.handOver_NoteFilter_checkBox, "checked");
			return ( (status.toLowerCase()).equals("true") )? true : false;
		}
		
		// Click on 'Without note' checkBox
		public void clickOn_noteFilterCheckBox(WebDriver driver){
			key.click(driver, "xpath", this.handOver_NoteFilter_checkBox);
		}
		
		//getResidentName_UnderHandOverResidentList
		public String getFirstResidentName_UnderHandOverResidentList(WebDriver driver){
			return key.getText(driver, "xpath", this.firstResidentName_UnderHandOver);
		}
		
		//clickOn_addButtonUnderHandOverResidentList
		public void clickOn_addButtonUnderHandOverResidentList(WebDriver driver){
			key.click(driver, "xpath", this.FirstResidentAddNoteButton_UnderHandOver);
		}
		
		//Enter From Date under HandOver Note page
		public void enterHandOverFromDate(WebDriver driver, String date){
			key.clearText(driver, "id", this.dateFrom);
			key.EnterText(driver, "id", this.dateFrom, date);
			//driver.findElement(By.xpath(datePicker)).sendKeys(Keys.RETURN);
		}

		//Enter To Date under HandOver Note page
		public void enterHandOverToDate(WebDriver driver, String date){
			key.clearText(driver, "id", this.dateTo);
			key.EnterText(driver, "id", this.dateTo, date);
		}
		
		// verify resident presence without having handover note when 'without note' checkbox is checked.
		public boolean expendAndVerifyResidentWithoutHandoverNote(WebDriver driver) throws Exception { 
			// Getting list of Residents Name [for having notes and without having notes]
				List<String> allResidentsWithHandoverNote = this.getCurrentResidentList(driver);
				this.clickOn_noteFilterCheckBox(driver);
				List<String> allNames = this.getCurrentResidentList(driver);
			System.out.println(allResidentsWithHandoverNote);
			System.out.println(allNames);
			
			// Compare both list and then filter out the names who is not in the handover note resident list.
				for(String name : allNames) {
					if(allResidentsWithHandoverNote.contains(name) == false) {
						// Search for this candidate
							this.searchForResident(driver, name);
						// Expand the current list
							this.expandEachResident(driver);
						// check for the note detail elements, that should not be present.
							if (this.verifyHandOverNoteSection(driver) == false) {
								throw new Exception("HandOver note section is present, which is not expected.");
							}
					}
				}
				
			return true;
		}
		
		// Verify Single resident handover detail
		// checks for handover note detail section presence
		public boolean verifyHandOverNoteSection(WebDriver driver) {
			boolean status = false;
			// Finding the handover detail section status
				try {
					status = (driver.findElement(By.xpath(this.handoverNoteSection)).isDisplayed()) ;
					status = true;
				} catch(Exception e) {
					status = true;
				}
			// Return the result
			return status;
		}

		// Get the current listed residents [if 'without note' check box is checked]
		public ArrayList<String> getCurrentResidentList(WebDriver driver) throws Exception {
			// getting names
				ArrayList<String> names = new ArrayList<String>();
				List<WebElement> allList = key.fetch_AllElements(driver, this.all_availableResidentNames);
				for(WebElement name: allList ){ names.add(name.getText().toString()); }
			
			//return list
				return names;
		}
		
		// verify the handover all 4 element
		public boolean expendAndVerifyHandoverNoteElement(WebDriver driver) throws Exception {
			boolean status = false;
			int size=0;
			List<WebElement> allArrow = key.fetch_AllElements(driver, this.arrows);
			size = allArrow.size();
			
			// Expending resident list...
			this.expandEachResident(driver);

			// Collecting all date elements
				List<WebElement> allDates = key.fetch_AllElements(driver, this.all_HandOverNoteDates);
			// Collecting all created by elements
				List<WebElement> allCreatedBy = key.fetch_AllElements(driver, this.all_handoverNote_CreatedBy);
			// Collecting all note text elements
				List<WebElement> allHandoverNotes = key.fetch_AllElements(driver, this.all_HandOverNoteText);
			// Collecting all delete icon elements
				List<WebElement> allDeleteIcons = key.fetch_AllElements(driver, this.all_handOverNote_deleteIcon);
			
			// checks whether all 4 different list of elements has equal size.
				if (size == allDates.size() && size == allCreatedBy.size() && size == allHandoverNotes.size() && size == allDeleteIcons.size()) {
					status = true;
				}
			
			// return the result
			return status;
		}
		// Expending the search result and verifying the added note.
		public boolean expendAndVerify_EntryInHandOverNote(WebDriver driver, String text) throws InterruptedException{
			// Expending resident list...
			List<WebElement> allArrow = key.fetch_AllElements(driver, this.arrows);
			for(WebElement arrow: allArrow ){ arrow.click(); Thread.sleep(2000); }
	
			//Wait
			Thread.sleep(1000);
	
			// Matching the text...
			List<WebElement> noteText = key.fetch_AllElements(driver, this.all_HandOverNoteText);
			for(WebElement note : noteText ){ String str = note.getText(); if(str.contains(text)) { return true; } }
			return false;
		}
		
		// Expending the search result and verifying the dates for the result notes with respect to provided date range.
		public boolean expendAndVerifyAccordingToDates_EntryInHandOverNote(WebDriver driver, String from, String to) throws InterruptedException, Exception {
			// Expending resident...
			List<WebElement> allArrow = key.fetch_AllElements(driver, this.arrows);
			for(WebElement arrow: allArrow ){ arrow.click(); Thread.sleep(2000); }
	
			//Wait
			Thread.sleep(1000);
	
			// Verifying the note dates with the given date range...
			List<WebElement> noteDates = key.fetch_AllElements(driver, this.all_HandOverNoteDates);
			for(WebElement date : noteDates ){ String dateStr = date.getText(); if(this.isWithinRange(dateStr, from, to) == false ) { return false; } }
			return true;
		}
		
		// Verify if, the From date is greater than To date.
		public boolean verifyPopupPresenceWhenFromDateIsGreaterThanToDate(WebDriver driver) {
			if ( ((key.getText(driver, "xpath", this.popup_dateRangeError)).toLowerCase()).contains((this.popup_dateRangeErrorMsg).toLowerCase()) ) {
				return true;
			}
			return false;
		}
		
		// Checks whether the given date falls within the given date range
		public boolean isWithinRange(String date, String from, String to) throws Exception{
			// Result to be recorded
				boolean status = false;
			
			// Extraction of d, m, y from the given date
				int d = Integer.parseInt( ((date.substring(0, date.indexOf(" "))).split("/"))[0] );
				int m = Integer.parseInt( ((date.substring(0, date.indexOf(" "))).split("/"))[1] );
				int y = Integer.parseInt( ((date.substring(0, date.indexOf(" "))).split("/"))[2] );
			
			// verifying the date range with respect to given date
				// Year within from and To
				if(y <= Integer.parseInt((to.split("/"))[2]) && y >= Integer.parseInt((from.split("/"))[2])) {
					// month within from and To
					if(m <= Integer.parseInt((to.split("/"))[1]) && m >= Integer.parseInt((from.split("/"))[1])) {
						// Date within from and To
						if(d <= Integer.parseInt((to.split("/"))[0]) && d >= Integer.parseInt((from.split("/"))[0])) {
							status = true;
						}
					}
				}	
			//System.out.println("D="+d+", M="+m+", Y="+y);
			//System.out.println("FROM D="+Integer.parseInt((from.split("/"))[0]) +", M="+Integer.parseInt((from.split("/"))[1]) +", Y="+Integer.parseInt((from.split("/"))[2]));
			//System.out.println("TO   D="+Integer.parseInt((to.split("/"))[0]) +", M="+Integer.parseInt((to.split("/"))[1]) +", Y="+ Integer.parseInt((to.split("/"))[2]));
			System.out.println(">>> Date Range validation for the current note text: " + status);
			
			// return the result
			return status;
		}
	

}
