package org.nng.test.pageObjects;

import java.util.List;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderingPage 
{

	Keywords key = new Keywords();

	// ################ ---- Element Locators ----------- ##########
	//Ordering menu
	String ordering = "//img[@alt='Ordering']";
	String np_Prn = "//img[contains(@alt,'Non Packed and PRN')]";
	String medicationChange = "//img[contains(@alt,'Medication Change')]";
	String other = "//img[contains(@alt,'Other')]";
	String facility = "//img[contains(@alt,'Facility')]";
	String monthlyEyeDrop = "//img[contains(@alt,'Monthly Eye Drop')]";
	String orderHistory = "//img[contains(@src,'OrderHistory')]";

	// Ordering - NonPackd & PRN
	String select_Section = "ddlSection";
	String select_Resident = "ddlResident";
	String checkBox_Regualr = "//input[contains(@ng-model,'isRegular')]";
	String checkBox_PRN ="//input[contains(@ng-model,'isPrn')]";
	String checkBox_ExcludeED = "//input[contains(@ng-model,'excludeEyeDrops')]";
	String search_Resident = "//button[contains(@ng-click,'searchResident')]";

	String firstresidentName = "(//span[contains(@ng-bind,'ResidentName')])[1]";
	String firstDrugName = "(//span[contains(@ng-bind,'Description')])[1]";
	String increaseValue_Ordering = "(//span[@title='Increase value'])[1]";
	String checkFirstOrder = "(//input[contains(@ng-model,'Order')])[1]";
	String medication_EyeDrp  = "//span[contains(text(),'EYE-DRP')]";

	String descritpion = "(//textarea[@name='Description'])[1]";
	String attachment = "(//button[contains(@ng-click,'addFacilityRequest')])[1]";
	String clickOn_Done = "//button[contains(@ng-click,'doneAction')]";
	String clickSection = "//span[contains(text(),'select')]";
	String checkFirstUrgentCheckbox = "(//input[contains(@ng-model,'IsUrgent')])[1]";

	//History
	String select_SectionHist = "//select[contains(@ng-model,'SectionId')]";
	String select_ResidentHist = "//select[contains(@ng-model,'ResidentId')]";
	String clickOnPriority_All = "//button[contains(@ng-class,'priority') and contains(text(),'Normal')]";
	String clickOnStatus_All = "//button[contains(@ng-class,'status') and contains(text(),'All')]";
	String select_TypeHist = "ddlType";
	String search_History = "//button[contains(@ng-click,'searchOnline')]";


	// ################ ----Page Object Logics ----------- ##########

	//This function will click on ordering button
	public void clickOn_OrderingBtn(WebDriver driver){
		key.click(driver, "xpath", ordering);
	}

	//This function will click on ordering button
	public void clickOn_NpPrn(WebDriver driver){
		key.click(driver, "xpath", np_Prn);
	}

	// Select Section
	public void select_SectionFromDropdown(WebDriver driver, String Section){
		key.selectFromDropDown(driver, "id", select_Section, "Text", Section);
	}

	//Select resident from Dropdown
	public void select_ResidentFromDropdown(WebDriver driver, String ResidentName){
		key.selectFromDropDown(driver, "id", select_Resident, "Text", ResidentName);
	}

	//This function will click on PRN
	public void clickOn_PRNCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkBox_PRN);
	}

	//This function will click on Regular
	public void clickOn_RegularCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkBox_Regualr);
	}

	//This function will click on Execlude eye drops
	public void clickOn_ExcludeEDCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkBox_ExcludeED);
	}

	// this function will click on button to Search
	public void btn_Search(WebDriver driver){
		key.click(driver, "xpath", search_Resident);
	}

	//This function will verify the recent order notification for the said medicine
	//span[contains(text(),'METHYL SALICYLATE APF, 100mL LINM (METHYL SAL (GOLD CROSS))')]//parent::td//following-sibling::td/span[contains(@ng-show,'Recent')]
	public boolean presenceof_RecentOrderNotificationLocated(WebDriver driver, String valueReq){
		String value = "//span[contains(text(),'"+valueReq+"')]//parent::td//following-sibling::td/span[contains(@ng-show,'Recent') and not(contains(@class,'ng-hide'))]";
		System.out.println("Recent Notification --> "+value);
		if(key.checkElementDisplay(driver, "xpath", value)){
			return true;
		}else{
			return false;
		}	
	}

	// Fetch residentName
	public String getResidentName_Ordering(WebDriver driver){
		return key.getText(driver, "xpath", firstresidentName);	
	}

	//fetch first drug Name
	public String getdrugName_Ordering(WebDriver driver){
		return key.getText(driver, "xpath", firstDrugName);	
	}

	//Increase qty require value to 6
	public void enter_QtyRequired(WebDriver driver){
		for(int i=0;i<=5;i++){
			key.click(driver, "xpath", increaseValue_Ordering);
		}
	}

	// this function will click on first order check box
	public void clickOn_FirstCheckboxOrder(WebDriver driver){
		key.click(driver, "xpath", checkFirstOrder);
	}

	public boolean presenceOfEyeDropLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", medication_EyeDrp)){
			return true;
		}else{
			return false;
		}
	}

	//This function will click on med change
	public void clickOn_MedChange(WebDriver driver){
		key.click(driver, "xpath", medicationChange);
	}

	//This will enter description in textbox
	public void enter_Description(WebDriver driver, String text){
		key.EnterText(driver, "xpath", descritpion, text);
	}

	//This function will upload file into the attachement
	public void upload_file(WebDriver driver, String Path){
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Path);
	}

	//This function click on Attach button
	public void clickOn_AttachmentButton(WebDriver driver){
		key.click(driver, "xpath", attachment);
	}

	//This function click on Done popUp
	public void popup_ClickOnDone(WebDriver driver){
		key.click(driver, "xpath", clickOn_Done);
	}

	//CLick on Other menu
	public void clickOn_Other(WebDriver driver){
		key.click(driver, "xpath", other);
	}

	//click on Facility menu
	public void clickOn_Facility(WebDriver driver){
		key.click(driver, "xpath", facility);
	}

	//click on Select Option
	public void selectSection(WebDriver driver, String option){
		String xpath = "//li[contains(text(),'"+option+"')]";
		key.click(driver, "xpath", clickSection);
		key.click(driver, "xpath", xpath);
	}

	//This function will click on urgent checkbox
	public void clickOn_UrgentCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkFirstUrgentCheckbox);
	}

	//This function will click on monthly EyeDrop
	public void clickOn_MonthlyEyeDrop(WebDriver driver){
		key.click(driver, "xpath", monthlyEyeDrop);
	}

	//click on History menu
	public void clickOn_History(WebDriver driver){
		key.click(driver, "xpath", orderHistory);
	}

	//Select resident in History Page
	public void select_ResidentFromDropdown_History(WebDriver driver, String ResidentName){
		key.selectFromDropDown(driver, "xpath", select_ResidentHist, "Text", ResidentName);
	}

	//Select Section in History Page
	public void select_SectionFromDropdown_History(WebDriver driver, String sectionName){
		//key.click(driver, "xpath", select_SectionHist);
		key.selectFromDropDown(driver, "xpath", select_SectionHist, "Text", sectionName);
	}

	// This function will click on said priority
	public void clickOn_Priority(WebDriver driver, String priority){
		String xpath = "//button[contains(@ng-class,'priority') and contains(text(),'"+priority+"')]";
		key.click(driver, "xpath", xpath);

	}

	//This function will click on said status
	public void clickOn_Status(WebDriver driver, String status){
		String xpath = "//button[contains(@ng-class,'status') and contains(text(),'"+status+"')]";
		key.click(driver, "xpath", xpath);
	}

	//Select resident in History Page
	public void select_Type_History(WebDriver driver, String typeName){
		key.selectFromDropDown(driver, "id", select_TypeHist, "Text", typeName);
	}

	//User clicks on Search Button under history page
	public void btn_searchHistory(WebDriver driver){
		key.click(driver, "xpath", search_History);
	}

	//This function will take the Said date and check in ordered column if the date is present or not
	public boolean verifydate_InOrderdColumn(WebDriver driver, String currentDate){
		boolean value = false;
		String xpath = "//td[6]/div[2]"; // Ordered Column dates
		List<WebElement> alldates = key.fetch_AllElements(driver, xpath);

		for(WebElement date: alldates )
		{
			String txt = date.getText();
			System.out.println("Dates from Orderd Column History Page---> " + txt);
			if(txt.contains(currentDate)){
				//System.out.println("true");
				System.out.println("Comparison Passed!! Following Date: "+ currentDate +" is present");
				value =  true;
			}else{
				System.out.println("Failed!! Following Date: "+ txt +
						" doesn't matched with the current Date i.e-->" + currentDate);
				value =  false;
				break;
			}
		}// end of for loop
		return value;
	} 
	
	//This function will take the Said date and check in ordered column if the date is present or not
		public boolean verifyStatus_InStatusColumn(WebDriver driver, String shouldPresent, String shouldNotPresent){
			boolean value = false;
			String xpath = "//td[8]"; // Ordered Column dates
			List<WebElement> statuses = key.fetch_AllElements(driver, xpath);
			System.out.println();
			//check each status
			for(WebElement state: statuses )
			{
				String txt = state.getText();
				System.out.println("state from Orderd Column History Page---> " + txt);
				//verify should present and should Not present
				if(txt.contains(shouldPresent) && !(txt.contains(shouldNotPresent))){
					//System.out.println("true");
					System.out.println("Comparison Passed!! Following status: "+ shouldPresent +" is present");
					value =  true;
				}else{
					System.out.println("Failed!! Following Status: "+ txt +
							" doesn't matched with the shouldPresent --> '" + shouldPresent + 
							"' and should'nt present--> " + shouldNotPresent);
					value =  false;
					break;
				}
			}
			return value;
		} 



}//End of class
