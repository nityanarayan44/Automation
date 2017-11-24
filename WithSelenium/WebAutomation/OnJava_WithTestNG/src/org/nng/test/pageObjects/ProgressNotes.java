package org.nng.test.pageObjects;

import java.util.List;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressNotes 
{

	Keywords key = new Keywords();

	// ################ ---- Element Locators ----------- ##########
	String progressNotes = "//img[@alt='Progress Notes']";
	String srchBox = "residentSearch";
	String fromDate = "from";
	String toDate = "to";
	String searchBtn = "//input[@value ='Search']";
	String all_progressNotes = "//span[contains(@ng-bind,'ProgressNote')]";
	String btn_AddNote = "//div/input[contains(@ng-click,'addNote')]";


	// ################ ----Page Object Logics ----------- ##########

	//Click on Progress Notes button
	public void clickOn_progressBtn(WebDriver driver){
		key.click(driver, "xpath", progressNotes);
	}

	// Will search resident using search box
	public void searchResidentInProgressNotes(WebDriver driver, String residentName){
		key.EnterText(driver, "id", srchBox, residentName);
	}

	//Enter From Date
	public void enterFromDate(WebDriver driver, String date){
		key.clearText(driver, "id", fromDate);
		key.EnterText(driver, "id", fromDate, date);
		//driver.findElement(By.xpath(datePicker)).sendKeys(Keys.RETURN);
	}

	//Enter To Date
	public void enterToDate(WebDriver driver, String date){
		key.clearText(driver, "id", toDate);
		key.EnterText(driver, "id", toDate, date);
	}

	//Click on Search button
	public void clickOn_searchBtn(WebDriver driver){
		key.click(driver, "xpath", searchBtn);
	}


	// Verify if the Lists of Progress Notes are present
	public boolean presenceOf_progressNotesLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", all_progressNotes)){
			return true;
		} else{
			return false;
		}	
	}

	/* This function will verify the drug name in the progress note entry.
	 * it will fetch all the entries in the progress note and compare it with the
	 * given drug Name.
	 * */
	public boolean verify_EntryInProgressNote(WebDriver driver, String drugName){
		List<WebElement> allNotes = key.fetch_AllElements(driver, all_progressNotes);
		for(WebElement note: allNotes ){
			String nt = note.getText();
			//System.out.println("note ---> " + nt);
			//System.out.println("DrugName -->" + drugName);
			if(nt.contains(drugName)){
				//System.out.println("true");
				return true;
			}	
		}
		return false;
	}

	//Click to Add Note button
	public void clickOn_AddNote(WebDriver driver){
		key.click(driver, "xpath", btn_AddNote);
	}



}// end of class
