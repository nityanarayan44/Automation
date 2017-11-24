package org.nng.test.pageObjects;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.WebDriver;

public class BestPack_FacilityOrders 
{
	Keywords key = new Keywords();

	// ################ ---- Element Locators ----------- ##########
	String clickOn_FacilityOrders = "//img[contains(@src,'FacilityOrders')]";
	String clickOn_OnlineOrders = "//img[contains(@src,'OnlineOrders')]";
	String sort_ColumnOrdered = "//a[@class='k-link' and (text()='Ordered')]";
	String type_MedChange = "//button[contains(text(),'Med Change')]";
	String type_other = "//button[contains(text(),'Other')]";
	String type_Facility = "//button[contains(text(),'Facility')]";
	String type_MonthlyEyeDrop = "(//button[contains(text(),'Monthly Eye Drop')])[2]";
	String searchOnline = "//button[contains(@ng-click,'searchOnlineOrders')]";
	String status_All = "//button[contains(@ng-class,'Status') and contains(text(),'All')]";
	
	// ################ ----Page Object Logics ----------- ##########

	//this function will click on facility Orders
	public void clickOn_FacilityOrders(WebDriver driver){
		key.click(driver, "xpath", clickOn_FacilityOrders);
	}

	//This function will click on Online Orders
	public void clickOn_OnlineOrders(WebDriver driver){
		key.click(driver, "xpath", clickOn_OnlineOrders);
	}


	//This function will click on said Facility Orders
	public void clickOn_FacilityOnlineOrders(WebDriver driver, String FacilityName){
		key.click(driver, "xpath", "//a[contains(text(),'"+FacilityName+"')]");
	}

	//This function will click to sort order, first click is ascending
	public void sortColumn_Ordered(WebDriver driver){
		key.click(driver, "xpath", sort_ColumnOrdered);
	}

	//This function will verify the presence of medication in Table
	public boolean verifyMedication(WebDriver driver, String medicationName){
		System.out.println("medicationName while verification-->" + "//span[contains(text(),'"+medicationName+"')]");
		if(key.checkElementDisplay(driver, "xpath", "//span[contains(text(),'"+medicationName+"')]")){
			return true;
		}else{
			return false;
		}
	}

	//This function will click On medChange
	public void clickOn_MedChange(WebDriver driver){
		key.click(driver, "xpath", type_MedChange);
	}

	//this function will click On Search Button
	public void clickOn_SearchOnlineOrders(WebDriver driver){
		key.click(driver, "xpath", searchOnline);
	}

	//This function will click On type medChange
	public void clickOnType_Other(WebDriver driver){
		key.click(driver, "xpath", type_other);
	}

	//this function will click on type Facility
	public void clickOnType_Facility(WebDriver driver){
		key.click(driver, "xpath", type_Facility);
	}

	//this function will click on type Monthly Eye Drop
	public void clickOnType_MonthlyEyeDrop(WebDriver driver){
		key.click(driver, "xpath", type_MonthlyEyeDrop);
	}
	
	//This function will click on All button
	public void clickOnStatus_All(WebDriver driver){
		key.click(driver, "xpath", status_All);
	}

}//End of class
