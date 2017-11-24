package org.nng.test.pageObjects;

import java.util.List;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorBookPage {

	/*
	 * ================================================================================
	 * --- [Global instances] ------------
	 * ================================================================================
	 */
		Keywords keywords 	= new Keywords();	// Class object For webElement operations
		
		//Xpaths
			String loader = "//div[contains(@class,'loading')]";
			
			String field_selectDoctor 	= ".//*[contains(@ng-model, 'ctrl.doctorId')]";
			String field_setDate		= ".//*[@id='completedNotes']"; //Format [dd/mm/yyyy]
			String btn_addNote 			= ".//*[contains(@ng-click, 'ctrl.openNote')]";
	
		// Add Note Popup
			String field_noteTextArea	= ".//*[@name='doctorNotes' and contains(@ng-model, 'ctrl.note')]";
			String btn_saveNoteText		= ".//*[@id='newNoteModal']//button[contains(@ng-click, 'ctrl.saveNote')]";
			String btn_cancelNoteText	= ".//*[@id='newNoteModal']//button[contains(@ng-click, 'ctrl.cancel')]";
			
		// Listed Notes
			String all_notesRow			= ".//*[@id='activeNotesGrid']//table//tr";
			String all_notesText		= ".//*[@id='activeNotesGrid']//table//tr/td[2]";
			String all_editNoteLink		= ".//*[@id='activeNotesGrid']//table//tr/i[@ng-click, 'ctrl.openNote(dataItem)']";
			String all_deleteNoteLink	= ".//*[@id='activeNotesGrid']//table//tr/i[@ng-click, 'ctrl.deleteItem(dataItem)']";
	/*
	 * ================================================================================
	 * --- [Functions, as test] ------------
	 * ================================================================================
	 */
		public void set_noteText(WebDriver driver, String noteText) throws Exception {
			keywords.clearText(driver, "xpath", this.field_noteTextArea);
			keywords.EnterText(driver, "xpath", this.field_noteTextArea, noteText);
			return;
		}
		public void clickOn_saveNoteText(WebDriver driver) {
			keywords.click(driver, "xpath", this.btn_saveNoteText);
			return;
		}
		public void search_setDateForCompletedNote(WebDriver driver, String date) throws Exception {
			keywords.clearText(driver, "xpath", this.field_setDate);
			keywords.EnterText(driver, "xpath", this.field_setDate, date);
			keywords.EnterText(driver, "xpath", this.field_setDate, Keys.ENTER.toString());
			return;
		}
		public void clickOn_addNoteButton(WebDriver driver) throws Exception {
			keywords.click(driver, "xpath", this.btn_addNote);
			return;
		}
		public boolean verify_allListedNoteTextForADoctor(WebDriver driver, String addedNote) throws Exception {
			// Matching the text...
				List<WebElement> noteText = keywords.fetch_AllElements(driver, this.all_notesText);
				for(WebElement note : noteText ) { 
					String str = note.getText().toString();
					if(str.contains(addedNote)) { 
						return true; 
					} 
				}
			return false;
		}
		
		public void delete_allListedNoteTextForADoctor() throws Exception {
			return;
		}
		
		//=================================================
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

		
/* BOTTOM */
}/*END OF CLASS*/
