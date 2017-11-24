// All the homepage and medication round operations

package org.nng.test.pageObjects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.nng.test.Configurations.Constants;
import org.nng.test.utills.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	Keywords key = new Keywords();

	// ################ ---- Element Locators ----------- ##########

	// ------------Login Page --------------
	String userLocator = "//input[@id='bmUserName']";
	String passLocator = "//input[@id='bmPassword']";
	String submitBtnLocator = "//button[@class='block btn btn-success full-width m-b']";

	// ------------ Home Page --------------
	//Menu Icons
		String homebtn 				= "//img[@alt='BESTdose']";
		String medication_Rounds	= "//img[@alt='Medication Rounds']";
		String administrativeAssist = "//img[contains(@alt,'Administrative Assistant')]";
		String medicationChart 		= "//img[contains(@src,'MedicationChart')]";
		String systemMaintenance	= "//img[contains(@src,'SystemMaintenance')]";
		String doctorBook			= "//img[contains(@alt, 'Doctor Book')]";
		String doctorBookLink		= "//a[contains(@ng-click, 'ctrl.navigateToDoctorBook')]";
		String facalityOrder		= "//img[contains(@src, 'FacilityOrders')]";
		
	//Options
		String Facility 	= "//select[@id='bestdosefacilitydll']";
		String Section 		= "//select[@id='bestdosesectiondll']";
		String settings_Menu= "//li[@id='usermenu']/a/i";
		String settings_UserManagement = ".//*[@id='usermenu']/ul/li/a[contains(@ng-click, 'usersManagement')]";
		String settings_Logout 	= "//a[contains(@ng-click,'logout')]";
	

	// ------------ Main Dose Round Page --------------
	String tabsOnMainDoseRound = "//div[@id='doseResSearch']/div[2]/div[2]/a";
	String tab_All		= "//a[text()[contains(.,'All')]]";
	String tab_Packed 	= "//a[text()='Packed']";
	String tab_NonPacked= "//a[text()='Non Packed']";
	String tab_Insulin 	= "//a[text()='Insulin']";
	String tab_S8 		= "//a[text()='S8']";
	String tab_Variable = "//a[text()='Variable']";
	String resident_List= "//div[@id='residentDoseList']";
	String residentName = "(//h3[contains(@ng-bind,'ResidentName')])[1]";
	String datePicker 	= "//input[@id='datesearch']";
	String missedSign 	= "//td[contains(@ng-if,'MissedSig')]";
	String srchBox 		= "residentSearch";

	// ------------ Dose Round Page --------------
	String medication_PageTitle = "//div[@id='doseRoundPanel']/div[1]/div[2]/label";
	String todaySelection 		= "//div[contains(@class,'btn-group')]/a[contains(@class,'btn-primary') and contains(@ng-bind,'todayLabel')]";
	String btn_Tomorrow 		= "//a[contains(@ng-bind,'tomorrowLabel')]";
	String btn_OutOfDoseRound 	= "//a[contains(@ng-click,'outOfDoseRound')]";
	String main_OpenDoseRound 	= "(//div[@id='doseRoundMain']//a[contains(@class,'btn-primary') or contains(@class,'btn-warning') and contains(@ng-click,'doseRound')])[1]";
	String main_CloseDoseRound 	= "(//div[@id='doseRoundMain']//a[contains(@class,'btn-danger') and contains(@ng-click,'doseRound')])[1]";
	String special_OpenDoseRound= "(//div[@id='doseRoundSpecial']//a[contains(@class,'btn-primary') and contains(@ng-click,'doseRound')])[1]";

	//only blue open in main dose rounds
	//String main_OpenDoseRound = "(//div[@id='doseRoundMain']//a[contains(@class,'btn-primary') and contains(@ng-click,'doseRound')])[1]";
	//Any blue rounds
	//String  main_OpenDoseRound = "(//a[contains(@class,'btn-primary') and contains(@ng-click,'doseRound')])[1]";

	// Loading
	String loading = "//*[@id='page-wrapper']//div[@class='k-loading-image']";

	// ################ ----Page Object Logics ----------- ##########

	//###--Perform Appliction Login--###
	public void performLogin(WebDriver driver, String userName, String userPassword){
		key.gotToUrl(driver, Constants.application_URL);
		key.EnterText(driver, "xpath", userLocator, userName);
		key.EnterText(driver, "xpath", passLocator, userPassword);
		key.click(driver, "xpath", submitBtnLocator);	
	}


	//----------Select Section-------
	String FacilityName = "TestPoint Nursing Home";
	public void selectSection(WebDriver driver, String SectionName) throws Exception{
		//Check if there is a Facility Selector 
		if(verify_presenceOfFacilityLocated(driver)){
			key.selectFromDropDown(driver, "xpath", Facility, "Text", FacilityName);
			Thread.sleep(3000);
		}
		key.selectFromDropDown(driver, "xpath", Section, "Text", SectionName);
	}


	// Verify the presence of Facility
	public boolean verify_presenceOfFacilityLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", Facility)){
			return true;
		}else{
			return false;
		}
	}
	
	//Click on Usermanagement under setting menu
	public void clickOn_UserManagement(WebDriver driver){
		key.click(driver, "xpath", this.settings_Menu);
		key.click(driver, "xpath", this.settings_UserManagement);
		return;
	}
	
	//Click on Doctor book under setting menu
	public void clickOn_DoctorBook(WebDriver driver){
		key.click(driver, "xpath", this.doctorBook);
		return;
	}
	
	// Click on facility Order
	public void clickOn_FacilityOrder(WebDriver driver) {
		key.click(driver, "xpath", this.facalityOrder);
		return;
	}
	
	//Click on SystemMaintenance under setting menu
	public void clickOn_SystemMaintenance(WebDriver driver){
		key.click(driver, "xpath", this.systemMaintenance);
		return;
	}
	
	//Click on home button
	public void clickOn_HomeBtn(WebDriver driver){
		key.click(driver, "xpath", homebtn);
	}

	//Click on Special Dose round button
	public void clickOn_SpecialDoseRound(WebDriver driver){
		key.click(driver, "xpath", special_OpenDoseRound);
	}

	//Click on Out of Dose round button
	public void clickOn_OutOfDoseRound(WebDriver driver){
		key.click(driver, "xpath", btn_OutOfDoseRound);
		//key.checkElementDisplay(driver, "xpath", tabsOnMainDoseRound);
	}


	//----------click on Medication Round-------
	public void clickOn_MedicationRound(WebDriver driver){
		key.click(driver, "xpath", medication_Rounds);
		//key.checkElementDisplay(driver, "xpath", medication_PageTitle);
	}

	// Clikc on tomorrow button
	public void clickOn_Tomorrow(WebDriver driver){
		key.click(driver, "xpath", btn_Tomorrow);
		//key.checkElementDisplay(driver, "xpath", medication_PageTitle);
	}

	//----------click on OpenDose Round-------
	public void clickOn_OpenDoseRound(WebDriver driver){
		key.click(driver, "xpath", main_OpenDoseRound);
		key.checkElementDisplay(driver, "xpath", tabsOnMainDoseRound);
	}

	//----------click on closeDose Round-------
	public void clickOn_MainCloseDoseRound(WebDriver driver){
		key.click(driver, "xpath", main_CloseDoseRound);
		key.checkElementDisplay(driver, "xpath", tabsOnMainDoseRound);
	}


	//----------Verify if Today is Selected -------
	public boolean verify_IfTodayIsSelected(WebDriver driver){
		String selectedButton = key.getText(driver, "xpath", todaySelection);	
		if(selectedButton.contains("Today")){
			return true;
		}else{
			return false;
		}
	}

	// ------- Presence of All Tabs ----------
	public boolean verify_presenceOfTabs(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", tab_All)
				&& key.checkElementDisplay(driver, "xpath", tab_Packed)
				&& key.checkElementDisplay(driver, "xpath", tab_NonPacked)
				&& key.checkElementDisplay(driver, "xpath", tab_Insulin)
				&& key.checkElementDisplay(driver, "xpath", tab_S8)
				&& key.checkElementDisplay(driver, "xpath", tab_Variable)
				){
			return true;
		}else{
			return false;	
		}
	}

	// Verify the presence of Open dose round
	public boolean verify_presenceOfOpenDoseRound(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", main_OpenDoseRound)){
			return true;
		}else{
			return false;
		}
	}


	// Verify the presence of close dose round in main
	public boolean verify_presenceOfMainCloseDoseRound(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", main_CloseDoseRound)){
			return true;
		}else{
			return false;
		}
	}

	// Verify the presence of special dose round
	public boolean verify_presenceOfSpecialDoseRound(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", special_OpenDoseRound)){
			return true;
		}else{
			return false;
		}
	}

	// Verify the presence of resident lists
	public boolean verify_PresenceOfResidentList(WebDriver driver){	
		if(key.checkElementDisplay(driver, "xpath", resident_List)){
			return true;
		}else{
			return false;
		}
	}

	// Click on Variable Tab
	public void clickOn_AllTab(WebDriver driver){
		key.click(driver, "xpath", tab_All);
	}

	// Click on Packed Tab
	public void clickOn_PackedTab(WebDriver driver){
		key.click(driver, "xpath", tab_Packed);
	}

	// Click on Non- packed Tab
	public void clickOn_NonPackedTab(WebDriver driver){
		key.click(driver, "xpath", tab_NonPacked);
	}

	// Click on Insulin Tab
	public void clickOn_InsulinTab(WebDriver driver){
		key.click(driver, "xpath", tab_Insulin);
	}

	// Click on S8 Tab
	public void clickOn_S8Tab(WebDriver driver){
		key.click(driver, "xpath", tab_S8);
	}

	//Click on Variable Tab
	public void clickOn_VariableTab(WebDriver driver){
		key.click(driver, "xpath", tab_Variable);
	}

	//Fetch Resident Name
	public String get_ResidentNameFromList(WebDriver driver){
		String rName = key.getText(driver, "xpath", residentName);
		return rName;
	}

	// Application Logout
	public void app_Logout(WebDriver driver){
		key.click(driver, "xpath", settings_Menu);
		key.click(driver, "xpath", settings_Logout);
		//If there is something in the cart
		if(key.checkElementDisplay(driver, "xpath", "//h3[@id='confirmationModal']")){
			key.click(driver, "xpath", "//button[contains(@ng-click,'okAction')]");
		}
	}

	//Date and search
	public void enterDateAndSearch(WebDriver driver, String date){
		key.clearText(driver, "xpath", datePicker);
		key.EnterText(driver, "xpath", datePicker, date);
		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.RETURN);
	}


	// Return date of 4 Days ahaead of current date
	public String getFutureDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String future_Date = dtf.format(localDate.plusDays(4));
		System.out.println("Future Date used in TestCase" + dtf.format(localDate.plusDays(2)));
		return future_Date;
	}

	//Return date of 4 Days behind of current date
	public String getPastDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String future_Date = dtf.format(localDate.minusDays(4));
		System.out.println("Past Date used in TestCase" + dtf.format(localDate.plusDays(2)));
		return future_Date;
	}

	//Return Cuurent Time in HHMM format
	public String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		String crntTme =  sdf.format(cal.getTime());
		System.out.println("Current Test Time-->" + crntTme);
		return crntTme;
	}

	//Return Current system Date
	public String getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String current_Date = dtf.format(localDate);
		//System.out.println("Current Date used in TestCase" + dtf.format(localDate));
		return current_Date;
	}

	// Will search resident using search box
	public void searchResident(WebDriver driver, String residentName){
		key.EnterText(driver, "id", srchBox, residentName);
	}

	// verify presende of missed Signature in resident's pane
	public boolean verify_PresenceOfMissedSignatureLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", missedSign)){
			return true;
		}else{
			return false;
		}	
	}

	/*This function is specific for BHS to check if the Loader is visible on webpage
	 * Use this function to wait untill the Loader disappear from the Page
	 * */
	String loader = "//div[contains(@class,'loading')]";
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
				if(wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader))))
				{
					return true;	
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}// End of method

	//Click on Admin Assistant
	public void clickOn_AdminAssist(WebDriver driver){
		key.click(driver, "xpath", administrativeAssist);
		//driver.findElement(By.xpath(administrativeAssist));
	}

	//Click on MedicationChart
	public void clickOn_MedicationChart(WebDriver driver){
		key.click(driver, "xpath", medicationChart);
	}

}
