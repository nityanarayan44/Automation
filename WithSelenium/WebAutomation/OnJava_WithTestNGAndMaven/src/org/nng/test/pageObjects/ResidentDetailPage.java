// All the page object specific to resident details page

package org.nng.test.pageObjects;

import java.util.List;

import org.nng.test.utills.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResidentDetailPage 
{
	Keywords key = new Keywords();
	HomePage home = new HomePage();

	// ################ ---- Element Locators ----------- ##########
	String resident = "(//h3[contains(@ng-bind,'ResidentName')])[1]";
	//String allMedicationDetail = "//medication-dose-detail[@id='medicationDoseDetails']/div/div";

	String allMedicationDetail = "//div[@id='doseRoundSideMenu']/div[3]/a";

	String checkbox_Admin = "(//div[@class='text-center']/input[contains(@ng-model,'IsAdminister')])[1]";
	String checkbox_PackedMedicine = "//div[@id='packedRegularGrid']/div[2]//input[contains(@ng-model,'IsAdminister')]";
	String checkbox_NonPackedMedicine = "//div[@id='nonPackedMeds']//input[contains(@ng-model,'IsAdminister')]";
	String checkbox_PackedMedicineAIN = "//div[@id='packedRegularGrid']/div[2]//input[contains(@ng-model,'RnOverride')]";
	String checkbox_AdminInsulin = "(//*[@id='nonPackedInsulinMed']//input[contains(@ng-model,'IsAdminister')])";

	String dropdown_PackedReason = "//div[@id='packedRegularGrid']/div[2]//select";
	String dropdown_NonPackedReason = "//div[@id='nonPackedMeds']//select";

	String dropdown_PackedNumberGivenReason = "//div[@id='packedMed']//select[contains(@ng-if,'isRegisterdNurse ')]";
	String numberGiven ="//label[text()='Number Given']/following-sibling::input";

	String btn_Confirm = "//button[text()='Confirm']";
	String btn_Save = "//button[text()='Save']";
	String btn_Verify = "//button[text()='Verify']";
	String btn_Canecl = "//button[text()='Cancel']";
	String btn_DoseRound = "//a[contains(@ng-click,'doseMedDetail')]";
	String btn_PRN = "//a[contains(@ng-click,'prn')]";
	String btn_OBS = "//a[contains(@ng-click,'OBS')]";
	String btn_NIM = "//a[contains(@ng-click,'nim')]";
	String btn_Emergency_Sock = "//a[contains(@ng-click,'emergencyMeds')]";
	String btn_ProgressNote = "//div/a[contains(@ng-click,'addNote')]";
	String btn_Handover = "//a[contains(@ng-click,'addhandover')]";
	String resident_DetailPageTilte ="//label[contains(@ng-bind,'roundDescription')]";
	String residentName = "//span[contains(@ng-bind,'ResidentName')]";

	//Cart order
	String addToCart = "(//a[contains(@ng-click,'addMedToCart')])[1]";
	String addToCart_Notification = "//div[contains(text(),'Medication added to cart')]";
	String openCart = "//i[contains(@class,'shopping-cart')]";
	String cartCount = "//span[contains(@ng-bind,'cartCount')]";
	String popoup_ConfirmAddMedicationTitle = "//h3[contains(text(),'Existing Medication In Cart')]";
	
	//Cart order Page
	String cart_All_MedicationName = "//span[contains(@ng-bind,'Description')]";
	String cart_All_MedicationDelete = "//a[contains(@ng-click,'deleteCart')]";
	String popup_CartCancelConfirm = "//label[contains(text(),'Delete cart order')]";
	String popup_CartOkConfirm = "//button[contains(@ng-click,'okAction')]";
	String click_Order = "//button[contains(@ng-click,'orderFacility')]";
	String orderSubmit_Notification = "//div[contains(text(),'Order submitted successfully')]";
	String deletedFromCart_Notification = "//div[contains(text(),'deleted from Cart')]";
	
	//Progress Note 
	String noteArea = "//textarea[@id='note']";
	String noteTitle = "//h4[contains(@class,'title') and text()='Progress Note']";

	//Close rounds Objects
	String btn_paperSigned = "//button[text()='Paper Signed']";
	String btn_IncidentReportLogged = "//button[text()='Incident Report Logged']";
	String disabled_AdminChkBox = "(//input[contains(@ng-model,'IsAdminister') and @disabled = 'disabled'])[1]";

	//Out Of Dose rounds
	String doseTime = "//span[contains(@ng-bind,'DoseTime')]";
	String toggleDoseTime = "(//div[@class='accordion-toggle']/span/i)[1]";

	//Confirmation POPUP
	String popup_confirm = "//button[contains(@ng-click,'confirmAction')]";
	String popup_cancel = "//button[contains(@ng-click,'cancelAction')]";
	String popup_Title = "//label[text()='Confirmation']";

	//Pin Authentication
	String popup_PinAuthentication = "//div[@id='doseMedSecondAuthenticationModal']/div/label";
	String pinError = "//p[contains(@ng-show,'isPinError')]";

	//BGL Required
	String popup_BGLTitle = "//label[contains(text(),'BGL Reading Required')]";

	//Pulse Required
	String popup_PulseRequired = "//label[contains(text(),'Pulse Reading Required')]";
	String increaseValue = "(//span[@title='Increase value'])[1]";
	String btn_RecordPulse = "//button[contains(@ng-click,'recordPulse')]";
	String pulseDescription = "//span[contains(@ng-bind,'PulseDescription') and contains(text(),'bpm recorded')] ";

	//Medications
	String medicinePacked_DIGOXIN  = "(//div[@id='packedRegularGrid']//span[contains(text(),'DIGOXIN')]//following::Input[contains(@ng-model,'RnOverride')])[1]";
	String medicineUnPacked_DIGOXIN = "(//div[@id='nonPackedRegularMed']//span[contains(text(),'DIGOXIN')]//following::Input[contains(@ng-model,'IsAdminister')])[1]"; 
	//String medicineUnPacked_S8 = "(//td[contains(@class,'schedule8')]//following::span[contains(@ng-if,'isDualSignatureRequired')]//following::input[contains(@ng-model,'IsAdminister')])[1]";
	String medicineUnPacked_S8 = "(//div[@id='nonPackedRegularGrid']//following::td[contains(@class,'schedule8')]//following::input[contains(@ng-model,'IsAdminister')])[1]";
	String medicinePacked_S8 = "(//div[contains(@id,'packed')]//td[contains(@class,'schedule8')]//following::input[contains(@ng-model,'IsAdminister')])[1]";
	String medicationNonPacked_Variable = "(//div[@id='nonPackedVariableGrid']//td[contains(@class,'type-variable')]//following::Input[contains(@ng-model,'NpVariableAdministered')])[1]";
	String medicationPacked_Variable = "(//div[@id='packedVariableGrid']//td[contains(@class,'type-variable')]//following::Input[contains(@ng-model,'IsAdminister')])[1]";
	String medicationNonPacked_Variable_isPresent = "//div[@id='nonPackedVariableGrid']//td[contains(@class,'type-variable')]";

	//prescription and Given for Variable drug:
	String npVariablePrescribed = "//input[@id='npVariablePrescribed']";
	String npVariableGiven = "//input[@id='npVariableGiven']";
	String npVariablePrescribed_isDisabled = "//input[@id='npVariablePrescribed' and @disabled='disabled']";
	String npVariableGiven_isDisabled  = "//input[@id='npVariableGiven' and @disabled='disabled']";

	String pkdVariable = "//div[@id='packedVariableGrid']";

	//PRN Page
	String pkdPRN_QTYof_firstMedication = "(//div[@id='packedMedGrid']//input[contains(@name,'Qty')])[1]";
	String pkdPRN_clickAdminFirstMedicine = "(//div[@id='packedMedGrid']//input[contains(@ng-model,'IsAdminister')])[1]";

	String nonPkdPRN_QTYof_firstMedication = "(//div[@id='nonPackedRegularGrid']//input[contains(@name,'Qty')])[1]";
	String nonPkdPRN_clickAdminFirstMedicine = "(//div[@id='nonPackedRegularGrid']//input[contains(@ng-model,'IsAdminister')])[1]";

	String checkBoxPRN_Insulin = "//div[contains(@id,'nsulin')]//input[contains(@type,'checkbox')]";
	String prnQty_Insulin = "//div[contains(@id,'nsulin')]//input[contains(@name,'Qty')]";
	String nonPkdPRN_Qty_S8 = "(//div[@id='nonPackedRegularGrid']//td[contains(@class,'schedule8')]//following::input[contains(@name,'Qty')])[1]";
	String pkdPRN_Qty_S8 = "(//div[contains(@id,'packed')]//td[contains(@class,'schedule8')]//following::input[contains(@name,'Qty')])[1]";

	String notificationMsg = "//div[contains(@class,'notification')]";
	String drugName = "(//span[contains(@class,'drug-text')])[1]";
	String popupPRN_Confirm = "//div[@id='confirmDoseMeds']/div[3]/button[1]";
	String popupPRN_Cancel = "//div[@id='confirmDoseMeds']/div[3]/button[2]";
	String nonPacked_firstDrugName = "(//div[@id='nonPackedRegularGrid']//span[contains(@class,'drug-text')])[1]";

	String prnEffectivness_Y = "(//input[contains(@ng-click,checkEfective) and @type='radio'])[1]";

	//NIM Page
	String popupNIM_Confirm = "//*[@id='NimOrderConfirm']/div[3]/button[1]";
	String popupNIM_Cancel = "//*[@id='NimOrderConfirm']/div[3]/button[2]";
	String drugName_NIM = "(//span[contains(@ng-bind,'Medication')])[1]"; 

	//HandOver model Pop-up
	String popupHandoverNote_Txtarea= ".//*[@id='handoverModal']//textarea[@id='addHandover']";
	String popupHandoverNote_Save 	= ".//*[@id='handoverModal']//button[@type='submit' and @class='btn btn-primary btn-lg']";
	String popupHandoverNote_Cancel = ".//*[@id='handoverModal']//button[@class='btn btn-primary btn-lg' and contains(@ng-click,'cancel()')]";

	//Emergency Stock Page
	String emrgncyStk_Admin = "(//div[@class='text-center']/input[contains(@ng-model,'Administered')])[1]";
	String drugName_EStock = "(//drug-image/parent::td/following-sibling::td)[1]";

	//OBS
	String label_BGL = "//td[contains(text(),'BGL')]";
	String label_Pulse = "//td[contains(text(),'Pulse')]";
	String label_BP = "//td[contains(text(),'Blood')]";
	String label_Weight="//td[contains(text(),'Weight')]";
	String label_Bowel = "//td[contains(text(),'Bowel')]";
	String label_Patch = "//td[contains(text(),'Patch')]";
	String label_INR = "//td[contains(text(),'INR')]";
	String label_Temp = "//td[contains(text(),'Temp')]";


	// ################ ---- Page Object Logics ----------- ##########

	// click on resident
	public void clickOn_Resident(WebDriver driver){
		key.click(driver, "xpath", resident);
	}

	// Verify Availability of PaperSignedLocated buttons for close dose round
	public boolean presence0fbtn_PaperSignedLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", btn_paperSigned)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of IncidentReportLocated buttons
	public boolean presence0fbtn_IncidentReportLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", btn_IncidentReportLogged)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of disabled admin checkbox for close dose round
	public boolean presence0f_disabledAdmminCheckboxLocated(WebDriver driver){
		// cannot use checkElemnent display here, becuase it will check for clickablility
		if(driver.findElement(By.xpath(disabled_AdminChkBox)).isDisplayed()){
			return true;
		} else{
			return false;
		}
	}	


	// Verify Availability of medications
	public boolean presence0f_MedicationsLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", allMedicationDetail)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of Admin Checkbox
	public boolean presence0f_AdminCheckboxLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", checkbox_Admin)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of confirm Button
	public boolean presence0f_ConfirmButtonLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", btn_Confirm)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of Save Button
	public boolean presence0f_SaveButtonLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", btn_Save)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of Cancel Button
	public boolean presence0f_CancelButtonLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", btn_Canecl)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Cancel button
	public void clickOn_CancelBtn(WebDriver driver){
		key.click(driver, "xpath", btn_Canecl);
	}




	// Click on PRN button
	public void clickOn_PRN(WebDriver driver){
		key.click(driver, "xpath", btn_PRN);
	}

	// Get Page Title
	public String getResident_PageTitle(WebDriver driver){
		return key.getText(driver, "xpath", resident_DetailPageTilte);
	}


	// Click on OBS button
	public void clickOn_OBS(WebDriver driver){
		key.click(driver, "xpath", btn_OBS);
	}

	// Click on NIM button
	public void clickOn_NIM(WebDriver driver){
		key.click(driver, "xpath", btn_NIM);
	}


	// Click on Emergency Stock button
	public void clickOn_EmergencyStock(WebDriver driver){
		key.click(driver, "xpath", btn_Emergency_Sock);
	}

	// Click on progress note button
	public void clickOn_ResiProgNote(WebDriver driver){
		key.click(driver, "xpath", btn_ProgressNote);
	}

	// Enter progress Note
	public void addNote(WebDriver driver, String Note){
		key.EnterText(driver, "xpath", noteArea, Note);
	}

	// Verify Progress Note Title
	public boolean verifyNoteTitle(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", noteTitle)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Handover button
	public void clickOn_HandoverNote(WebDriver driver){
		key.click(driver, "xpath", btn_Handover);
	}

	// Verify Dose Time availability of a resident when out of dose round is selected
	public boolean verifyResiDoseTime(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", doseTime)){
			return true;
		} else{
			return false;
		}
	}

	// toggle dose Time button
	public void toggle_DoseTime(WebDriver driver){
		key.click(driver, "xpath", toggleDoseTime);
	}

	//Get residetn Name
	public String getResidentName(WebDriver driver){
		return key.getText(driver, "xpath", residentName);	
	}

	// click on Confirm Button
	public void clickOn_ConfirmBtn(WebDriver driver){
		key.click(driver, "xpath", btn_Confirm);
	}

	//verify presence of popup
	public boolean verify_PresenceOfConfirmationPopUp(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", popup_Title)
				&& key.checkElementDisplay(driver, "xPath", popup_confirm)
				&& key.checkElementDisplay(driver, "xPath", popup_cancel)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Confirm Button
	public void confirm_POPUP(WebDriver driver){
		key.click(driver, "xpath", popup_confirm);
	}

	// Click on Verify Button
	public void clickOn_verifyPin(WebDriver driver){
		key.click(driver, "xpath", btn_Verify);
	}


	// This function will check all the packed medicine
	public void administerPackedMedicine(WebDriver driver){
		List<WebElement> checkBoxList = key.fetch_AllElements(driver, checkbox_PackedMedicine);
		System.out.println("No. of checkboxes--> "+ checkBoxList.size());
		//Click all checkboxes
		for(int i =1; i<=checkBoxList.size(); i++)
		{
			key.click(driver, "xpath", "(//div[@id='packedRegularGrid']/div[2]//input[contains(@ng-model,'IsAdminister')])["+i+"]");
		}

	}

	// This function will check all the non-packed medicine
	public void administerNonPackedMedicine(WebDriver driver){
		List<WebElement> checkBoxList = key.fetch_AllElements(driver, checkbox_NonPackedMedicine);
		System.out.println("No. of checkboxes--> "+ checkBoxList.size());
		//Click all checkboxes
		for(int i =1; i<=checkBoxList.size(); i++)
		{
			key.click(driver, "xpath", "(//div[@id='nonPackedMeds']//input[contains(@ng-model,'IsAdminister')])["+i+"]");

			//check if there is a popup
			try
			{
				Thread.sleep(800);
				if(driver.findElement(By.xpath(popup_cancel)).isDisplayed()){
					key.click(driver, "xpath", popup_cancel);
				}
			}catch(Exception e){
				System.out.println("No-popup");
			}
		}
	}

	//Select reason in all the packed medicine
	public void selectReasonForPackedMedicine(WebDriver driver, String reason){
		List<WebElement> reasonList = key.fetch_AllElements(driver, dropdown_PackedReason);
		System.out.println("No. of reason dropdowns--> "+ reasonList.size());

		for(int i=1; i<=reasonList.size(); i++){
			key.selectFromDropDown(driver, "xpath", "(//div[@id='packedRegularGrid']/div[2]//select)["+i+"]", "text", reason);

		}
	}

	//Select reason in all the Non packed medicine
	public void selectReasonForNonPackedMedicine(WebDriver driver, String reason){
		List<WebElement> reasonList = key.fetch_AllElements(driver, dropdown_NonPackedReason);
		System.out.println("No. of reason dropdowns--> "+ reasonList.size());

		for(int i=1; i<=reasonList.size(); i++){
			key.selectFromDropDown(driver, "xpath", "(//div[@id='nonPackedMeds']//select)["+i+"]", "text", reason);

		}
	}

	// Verify Availability of number of given checkbox
	public boolean presence0f_NumberGivenBoxLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", numberGiven)){
			return true;
		} else{
			return false;
		}
	}

	//Select no. of Given Reason
	public void selectNumGivenReason(WebDriver driver, String reason){
		key.selectFromDropDown(driver, "xpath", dropdown_PackedNumberGivenReason, "text", reason);
	}



	// Verify Availability of number of given Reason
	public boolean presence0f_SelectNumberGivenReasonLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", dropdown_PackedNumberGivenReason)){
			return true;
		} else{
			return false;
		}
	}

	//Enter No. given as AIN
	public void enter_NumberGiven(WebDriver driver){
		// Get all the dosage
		List<WebElement> dosage = key.fetch_AllElements(driver, "//div[@id='packedRegularGrid']//span[contains(@ng-bind,'dataItem')]");
		//int num = dosage.size();
		int num = 0;
		// total the number of given in dosage
		for(int i =0; i<dosage.size();i++){
			System.out.println(dosage.get(i).getText());
			String value = String.valueOf((dosage.get(i).getText().split("\\.")[0])); // remove decimal
			num = num + Integer.parseInt(value);		
			System.out.println(num);
		}
		key.EnterText(driver, "xpath", numberGiven, Integer.toString(num));	
	}


	// This function will select all RN checkboxes and Administer it by entering pin
	public boolean administerPackedMedicine_AsAIN(WebDriver driver, String pin) throws InterruptedException{
		List<WebElement> checkBoxList = key.fetch_AllElements(driver, checkbox_PackedMedicineAIN);
		System.out.println("No. of checkboxes--> "+ checkBoxList.size());
		boolean value = false;
		for(int i =1; i<=checkBoxList.size(); i++)
		{
			Thread.sleep(900);
			key.click(driver, "xpath", "(//div[@id='packedRegularGrid']/div[2]//input[contains(@ng-model,'RnOverride')])["+i+"]");
			if(presence0f_PinAuthenticationPopUpLocated(driver))
			{
				enterPin(driver, pin);
				clickOn_verifyPin(driver);
				value = true;
			}else{
				value = false;
				break;
			}
		}
		return value;
	}

	// Verify the Presence of Authentication POPup Located
	public boolean presence0f_PinAuthenticationPopUpLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", popup_PinAuthentication)){
			return true;
		} else{
			return false;
		}
	}

	// This method should be used to enter pin in Application
	public void enterPin(WebDriver driver, String pin){		
		char[] ch=pin.toCharArray();  
		for(int i =0;i<ch.length;i++)
		{
			String xpath = "//button[text()='"+ ch[i] +"']";
			System.out.println("pin is" + xpath);
			key.click(driver, "xpath", xpath);
		}
	}

	// Verify the Presence of BGL popup
	public boolean presence0f_BGLPopUpLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", popup_BGLTitle)){
			return true;
		} else{
			return false;
		}
	}

	// click on Insulin medicine 
	public void clickOn_InsulinAdminCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkbox_AdminInsulin);
	}

	// Verify Availability of PaperSignedLocated buttons for close dose round
	public boolean presence0fMedicine_InsulinLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", checkbox_AdminInsulin)){
			return true;
		} else{
			return false;
		}
	}


	// Verify Availability of Digoxin medicine
	public boolean presence0fPackedMedicine_DIGOXINLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", medicinePacked_DIGOXIN)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Digoxine 
	public void clickOn_PackedAdminDIGOXIN(WebDriver driver){
		key.click(driver, "xpath", medicinePacked_DIGOXIN);
	}

	// Verify presence of pulse required popup
	public boolean presence0f_PulseRequiredPopUpLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", popup_PulseRequired)){
			return true;
		} else{
			return false;
		}
	}

	//Increase pulse require value
	public void enter_PulseRequired(WebDriver driver){
		for(int i=0;i<=5;i++){
			key.click(driver, "xpath", increaseValue);
		}
	}

	// Verify Availability of Digoxin medicine in nonPacked
	public boolean presence0fUnPackedMedicine_DIGOXINLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", medicineUnPacked_DIGOXIN)){
			return true;
		} else{
			return false;
		}
	}

	// click to record pulse
	public void clickOn_RecordPulse(WebDriver driver){
		driver.findElement(By.xpath(btn_DoseRound)).click();
		key.click(driver, "xpath", btn_RecordPulse);

	}

	// Verify Availability of Digoxin medicine in nonPacked
	public boolean presence0f_pulseDescriptionLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", pulseDescription)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Digoxine unpacked
	public void clickOn_NonPackedAdminDIGOXIN(WebDriver driver){
		key.click(driver, "xpath", medicineUnPacked_DIGOXIN);
	}

	// Verify presence of S8 Drug
	public boolean presence0fNonPackedMedicine_S8Located(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", medicineUnPacked_S8)){
			return true;
		} else{
			return false;
		}
	}

	//click to administer S8 drug
	public void clickOn_NonPackedAdminS8(WebDriver driver){
		key.click(driver, "xpath", medicineUnPacked_S8);
	}

	//verify Pin Error
	public boolean verify_PinError(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", pinError)){
			return true;
		} else{
			return false;
		}
	}

	// Verify presence of S8 Drug in Packed
	public boolean presence0fPackedMedicine_S8Located(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", medicinePacked_S8)){
			return true;
		} else{
			return false;
		}
	}

	//click to adminsiter S8 drug
	public void clickOn_PackedAdminS8(WebDriver driver){
		key.click(driver, "xpath", medicinePacked_S8);
	}


	// Verify Availability of Variable medicine 
	public boolean presence0fNonPacked_VariableDrugLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", medicationNonPacked_Variable_isPresent)){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of Variable medicine
	public boolean presence0fPacked_VariableDrugLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xPath", pkdVariable)){
			return true;
		} else{
			return false;
		}
	}

	//click to administer variable drug
	public void clickOn_NonPackedVariableDrug(WebDriver driver){
		key.click(driver, "xpath", medicationNonPacked_Variable);
	}

	//click to administer variable drug
	public void clickOn_PackedVariableDrug(WebDriver driver){
		key.click(driver, "xpath", medicationPacked_Variable);
	}

	//Enter prescribed Variable drug
	public void enter_PrescribedVariableDrug(WebDriver driver, String value){
		key.EnterText(driver, "xpath", npVariablePrescribed, value);
	}


	//Enter Given Variable Drug 
	public void enter_GivenVariableDrug(WebDriver driver, String value){
		key.EnterText(driver, "xpath", npVariableGiven, value);
	}

	// Verify Availability of disabled Prescribed box
	public boolean isPrescribedDisabled_VariableDrug(WebDriver driver){
		if(driver.findElement(By.xpath(npVariablePrescribed_isDisabled)).isDisplayed()){
			return true;
		} else{
			return false;
		}
	}

	// Verify Availability of disabled Given box
	public boolean isGivenDisabled_VariableDrug(WebDriver driver){
		if(driver.findElement(By.xpath(npVariableGiven_isDisabled)).isDisplayed()){
			return true;
		} else{
			return false;
		}
	}

	//This function will click on medication button
	public void addMedicationToCart(WebDriver driver){
		key.click(driver, "xpath", addToCart);
	}

	// This function will verify the add cart notification message
	public boolean addToCart_NotificationLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", addToCart_Notification)){
			return true;
		}else{
			return false;
		}
	}

	// This method will verify if there are medications in the cart
	public boolean cart_presenceOFMedicationLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", cart_All_MedicationDelete)){
			return true;
		}else{
			return false;
		}
	}

	//This function will be used to click on Cart Button
	public void clickOn_Cart(WebDriver driver){
		key.click(driver, "xpath", openCart);
	}

	//Verify the presence of medication in the cart from the list of medication
	public boolean verifyMedication_InCart(WebDriver driver, String medicationName){
		List<WebElement> allMedication = key.fetch_AllElements(driver, cart_All_MedicationName);
		for(WebElement medcn: allMedication ){
			String md = medcn.getText();
			System.out.println("medication from Cart Page---> " + md);
			System.out.println("medication fetched from resident Detail Page -->" + medicationName);
			if(md.contains(medicationName)){
				//System.out.println("true");
				return true;
			}
		}
		return false;
	}

	//This method will remove all medications from the cart
	public void removeAllMedication_FromCart(WebDriver driver) throws InterruptedException{
		List<WebElement> allDeleteButton = key.fetch_AllElements(driver, cart_All_MedicationDelete);
		List<WebElement> refreshedDeleteButton;
		//run first loop as per number of delete button
		for(int i =0; i<allDeleteButton.size(); i++){
			
			//Initialize delete button after every click
			refreshedDeleteButton = key.fetch_AllElements(driver, cart_All_MedicationDelete);
			
			// Perform First click and break the loop
			for(int k=0;k<=refreshedDeleteButton.size();){
				refreshedDeleteButton.get(k).click();
				if(removeMedicationPopUpLocated(driver)){
					cart_PopUpConfirm(driver); // click ok
					home.waitForPageLoader(driver); // wait for loader to disappear
					deleteMedicationfromCart_NotificationLocated(driver); // Check Notification message
				}
				break;
			}//end of first Loop
		}//end of 2nd loop
	}

	public boolean deleteMedicationfromCart_NotificationLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", deletedFromCart_Notification)){
			return true;
		}else{
			return false;
		}
	}
	
	
	//This method will verify the presence of POPup when deleting medication from cart
	public boolean removeMedicationPopUpLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", popup_CartCancelConfirm)){
			return true;
		}else {
			return false;
		}
	}

	//This method will click on OK button from the delete popup
	public void cart_PopUpConfirm(WebDriver driver){
		key.click(driver, "xpath", popup_CartOkConfirm);
	}


	//This function will take the Expected count as input and verify from the number written at the top right
	public boolean verifyCartCount(WebDriver driver, String count){
		String num = key.getText(driver, "xpath", cartCount);
		System.out.println("cartcount from webpage --> " + num);
		System.out.println("count from code -->" + count);
		if(num.equals(count)){
			return true;
		}else{
			return false;
		}
	}
	
	// This function will verify the confirmation popup
	public boolean cart_ExistingMedicationPOPupLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", popoup_ConfirmAddMedicationTitle)){
			return true;
		}else{
			return false;
		}
	}
	
	//This function will click on order button on the cart Page
	public void clickOn_Order(WebDriver driver){
		key.click(driver, "xpath", click_Order);
	}
	
	public boolean verify_OrderSubmitNotification(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", orderSubmit_Notification)){
			return true;
		}else{
			return false;
		}
	}
	

	// ------------------------------- PRN Page Functions ---------------------------------------------


	//Click to adminsiter PRN medication in packed section
	public void clickOn_pckdPRN_FirstMedicine(WebDriver driver){
		key.click(driver, "xpath", pkdPRN_clickAdminFirstMedicine);
	}

	// Logic to enter minimum QTY for a medicine.
	public void enterPackedQTY_PRN(WebDriver driver, String qty){
		// -ve case to capture notification
		key.EnterText(driver, "xpath", pkdPRN_QTYof_firstMedication, qty);
		clickOn_pckdPRN_FirstMedicine(driver);

		//fetch String from notification and split on the basis of space, 
		String Text = driver.findElement(By.xpath(notificationMsg)).getText();	
		String splitText[] = Text.split(" ",0);

		//Enter the value at last Index
		key.EnterText(driver, "xpath", pkdPRN_QTYof_firstMedication, splitText[splitText.length-1]);
		//System.out.println("##-->" + splitText[3]); // use this for debug
	}

	// This function will verify presence of PRN Effective yes radio button 
	public boolean presenceofPRN_EffectivnenessLocated(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", prnEffectivness_Y)){
			return true;
		}else{		
			return false;
		}
	}

	// This function will click on PRN effective yes radio button
	public void clickOn_PrnEffectiveness_Yes(WebDriver driver){
		key.click(driver, "xpath", prnEffectivness_Y);
	}

	//Click to administer PRN medication in NonPacked Section
	public void clickOn_nonPckdPRN_FirstMedicine(WebDriver driver){
		key.click(driver, "xpath", nonPkdPRN_clickAdminFirstMedicine);
	}

	// Logic to enter minimum QTY for a medicine.
	public void enterNonPackedQTY_PRN(WebDriver driver, String qty){
		// -ve case to capture notification
		key.EnterText(driver, "xpath", nonPkdPRN_QTYof_firstMedication, qty);
		clickOn_nonPckdPRN_FirstMedicine(driver);

		//fetch String from notification and split on the basis of space, 
		String Text = driver.findElement(By.xpath(notificationMsg)).getText();	
		String splitText[] = Text.split(" ",0);

		//Enter the value at last Index
		key.EnterText(driver, "xpath", nonPkdPRN_QTYof_firstMedication, splitText[splitText.length-1]);
		//System.out.println("##-->" + splitText[3]); // use this for debug
	}


	//Fetch First drugName
	public String getDrugName(WebDriver driver){
		return key.getText(driver, "xpath", drugName);	
	}

	//Fetch First NonPacked drugName
	public String getNonPacked_DrugName(WebDriver driver){
		return key.getText(driver, "xpath", nonPacked_firstDrugName);	
	}

	//verify presence of popup
	public boolean verify_PresenceOfPRN_ConfirmationPopUp(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", popup_Title)
				&& key.checkElementDisplay(driver, "xPath", popupPRN_Confirm)
				&& key.checkElementDisplay(driver, "xPath", popupPRN_Cancel)){
			return true;
		} else{
			return false;
		}
	}

	// Click on Confirm Button
	public void popUp_ConfirmPrn(WebDriver driver){
		key.click(driver, "xpath", popupPRN_Confirm);
	}

	// click on Insulin medicine in PRN
	public void clickOn_PRN_InsulinCheckbox(WebDriver driver){
		key.click(driver, "xpath", checkBoxPRN_Insulin);
	}

	// Logic to enter  QTY for Insulin. 
	public void enterInsulinQTY_PRN(WebDriver driver, String qty){
		// -ve case to capture notification
		key.EnterText(driver, "xpath", prnQty_Insulin, qty);
		clickOn_PRN_InsulinCheckbox(driver);

		//fetch String from notification and split on the basis of space, 
		String Text = driver.findElement(By.xpath(notificationMsg)).getText();	
		String splitText[] = Text.split(" ",0);

		//Enter the value at last Index
		key.EnterText(driver, "xpath", prnQty_Insulin, splitText[splitText.length-1]);
		//System.out.println("##-->" + splitText[3]); // use this for debug
	}

	// Logic to enter  QTY for S8 
	public void enterS8QTY_PRN(WebDriver driver, String qty){
		// -ve case to capture notification
		key.EnterText(driver, "xpath", nonPkdPRN_Qty_S8, qty);
		clickOn_NonPackedAdminS8(driver);

		//fetch String from notification and split on the basis of space, 
		String Text = driver.findElement(By.xpath(notificationMsg)).getText();	
		String splitText[] = Text.split(" ",0);

		//Enter the value at last Index
		key.EnterText(driver, "xpath", nonPkdPRN_Qty_S8, splitText[splitText.length-1]);
		//System.out.println("##-->" + splitText[3]); // use this for debug
	}


	// Logic to enter  QTY for S8 
	public void enterPkdS8QTY_PRN(WebDriver driver, String qty){
		// -ve case to capture notification
		key.EnterText(driver, "xpath", pkdPRN_Qty_S8, qty);
		clickOn_PackedAdminS8(driver);

		//fetch String from notification and split on the basis of space, 
		String Text = driver.findElement(By.xpath(notificationMsg)).getText();	
		String splitText[] = Text.split(" ",0);

		//Enter the value at last Index
		key.EnterText(driver, "xpath", pkdPRN_Qty_S8, splitText[splitText.length-1]);
		//System.out.println("##-->" + splitText[3]); // use this for debug
	}


	// ------------------------------- NIM Page Functions ---------------------------------------------

	//Increase NIM require value
	public void enterNIM_AdminQty(WebDriver driver){
		enter_PulseRequired(driver);
	}


	//verify presence of popup
	public boolean verify_PresenceOfNIM_ConfirmationPopUp(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", popup_Title)
				&& key.checkElementDisplay(driver, "xPath", popupNIM_Confirm)
				&& key.checkElementDisplay(driver, "xPath", popupNIM_Cancel)){
			return true;
		} else{
			return false;
		}
	}

	//Confirm POPup
	public void popUp_confirmNIM(WebDriver driver){
		key.click(driver, "xpath", popupNIM_Confirm);

	}


	//Fetch First drugName in NIM tab
	public String getDrugName_NIM(WebDriver driver){
		return key.getText(driver, "xpath", drugName_NIM);	
	}

	// ------------------------------- Emergency Stock Functions ---------------------------------------------

	//Increase NIM require value
	public void enterES_AdminQty(WebDriver driver){
		enter_PulseRequired(driver);
	}

	//click To check Admin Box 
	public void administer_EmrgncyStck(WebDriver driver){
		key.click(driver, "xpath", emrgncyStk_Admin);	
	}

	//Fetch First drugName in emergency stock tab
	public String getDrugName_EStock(WebDriver driver){
		return key.getText(driver, "xpath", drugName_EStock);	
	}

	//---------------------------- Observations ---------------------

	//This Function will increase Observations Values to 1 
	String obs_Values = "//span[@title='Increase value']";
	public void recordOBS_forResident(WebDriver driver){
		List<WebElement> increments = key.fetch_AllElements(driver, obs_Values);
		for(int i =1; i<increments.size();i++){
			key.click(driver, "xpath", "(//span[@title='Increase value'])["+i+"]");			
		}
	}

	//verify presence of popup
	public boolean verify_PresenceOf_OBSValues(WebDriver driver){
		if(key.checkElementDisplay(driver, "xpath", label_BGL)
				&& key.checkElementDisplay(driver, "xPath", label_Pulse)
				&& key.checkElementDisplay(driver, "xPath", label_BP)
				&& key.checkElementDisplay(driver, "xPath", label_Weight)
				&& key.checkElementDisplay(driver, "xPath", label_Bowel)
				&& key.checkElementDisplay(driver, "xPath", label_Patch)
				&& key.checkElementDisplay(driver, "xPath", label_INR)
				&& key.checkElementDisplay(driver, "xPath", label_Temp)){
			return true;
		} else{
			return false;
		}
	}
	/*
	 * ================================================================================================
	 * ------------------------------- HandOver Functions ---------------------------------------------	
	 */
	// Clicks on Handover button to add a note.
	public void clickOn_HandOver(WebDriver webdriver) {
		key.click(webdriver, "xpath", this.btn_Handover);
	}

	// Adding some text inside textarea, of handover note popup
	public void add_HandOverNote(WebDriver webdriver, String note) {
		key.EnterText(webdriver, "xpath", this.popupHandoverNote_Txtarea, note);
	}

	// Clicks on save button of handover popup
	public void save_HandOverNote(WebDriver webdriver) {
		key.click(webdriver, "xpath", this.popupHandoverNote_Save);
	}

	//click To Save 
	public void clickOn_btnSave(WebDriver driver){
		key.click(driver, "xpath", btn_Save);	
	}

}// end of class
