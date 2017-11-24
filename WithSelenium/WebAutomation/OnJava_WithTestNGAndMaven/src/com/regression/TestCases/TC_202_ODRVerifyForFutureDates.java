package com.regression.TestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.ResidentDetailPage;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_202_ODRVerifyForFutureDates extends GetBrowserInstance
{

	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();
	ResidentDetailPage residentPage = new ResidentDetailPage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "7";
	String vansahTestCaseID = "202";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_202_ODRVerifyForFutureDates";
	String testStep = "";

	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}

	@Test(priority = 1)
	public void verifyODR_ResidentForFutureDate_RN()
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);
		try
		{
			//Login into Application
			testStep = "User Perform Login as Registered Nurse";
			homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Select Section
			String SectionName = Constants.sectionName;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			Thread.sleep(3000);
			//ClickOnMedicationRound
			testStep = "User Clicks on Medication Round";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			testStep = "User Clicks on 'Out of Dose' Round";
			CounterName = "OutOfDoseRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_OutOfDoseRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			String futureDate = homePage.getFutureDate();
			homePage.enterDateAndSearch(driver, futureDate );
			testStep = "Enter following Future date in calender: " + futureDate;
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			Thread.sleep(2000);
			
			//verify if resident list is available in All Tab
			testStep = "Verify presence of residents lists in All Tab";
			if(homePage.verify_PresenceOfResidentList(driver))
			{
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				System.out.println(testStep + "--Passed!!");
				
				
				//---- Click on resident --
				testStep = "User click on resident";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_Resident(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				//--- Verify Dose Time ---
				testStep = "Verify Dose Time availability in Resident detail Page under Out of Dose Round";			
				if(residentPage.verifyResiDoseTime(driver))
				{
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);		
					
					//Open Dose Time
					Thread.sleep(2000);
					testStep = "toggle Dose Time to Expand";	
					residentPage.toggle_DoseTime(driver);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					//Verify Presence of confirm Button
					testStep = "Verify presence of Confirm Button in PRN Page";
					if(residentPage.presence0f_ConfirmButtonLocated(driver)){
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					}else{
						ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
						vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
								bhs_Environment,"fail", "Test Step: " + testStep +" - Failed!", BHSLog_bit);
					}
				
				}//presence of dose time availability 
				else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
					Assert.fail(testStep+ "--Failed!! ");
				}
			
			}// presence of all resident condition
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
			}
			
			testStep = "Logout From the Application";
			homePage.app_Logout(driver);
			System.out.println(testStep);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
		
			
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// end of method
	
	@Test(priority = 2)
	public void verifyODR_ResidentForFuturePastDate_FM()
	{
		try
		{		
			//Login into Application
			testStep = "User Perform Login as Facility Manager";
			homePage.performLogin(driver, Constants.USER_NAME_FM, Constants.PASSWORD_FM);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			//Select Section
			String SectionName = Constants.sectionName;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);

			Thread.sleep(3000);
			//ClickOnMedicationRound
			testStep = "User clicks on Medication Round";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//click on out of dose round
			testStep = "User clicks on 'Out of Dose' Round";
			CounterName = "OutOfDoseRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_OutOfDoseRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			
			//verify if resident list is available in All Tab
			testStep = "Verify presence of residents lists for Current Date";
			if(homePage.verify_PresenceOfResidentList(driver))
			{
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				System.out.println(testStep + "--Passed!!");
				
				
				//---- Click on resident --
				testStep = "User click on resident and verify medication availability";
				CounterName = "ResidentDetail-Page-Load";
				vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
				residentPage.clickOn_Resident(driver);
				residentPage.presence0f_MedicationsLocated(driver);
				vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
				
				
				//Verify if the dose times are available under resident detail
				testStep = "Verify Dose time availability in Resident detail Page under Out of Dose Round";			
				if(residentPage.verifyResiDoseTime(driver))
				{
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
					
					//----- Implement Time and Date logic
					
					/* span[text()='2000']/parent::span/parent::div/parent::h4/parent::div/
					 * following-sibling::div/div/medication-dose-detail/div[2]/button[text()='Confirm']
					*/
					
					//Fetch all the time and save in list
					String appTimeAvailable = "//div[@class='accordion-toggle']/span/span";
					List<WebElement> appTime = key.fetch_AllElements(driver, appTimeAvailable);
					
					String currentSystemTime = homePage.getCurrentTime();
					System.out.println("Current System Time --> "+ currentSystemTime);
					
					//Compare each time in list with current time
					for(int i = 0; i<appTime.size(); i++)
					{	
						
						String paperSigned = "Paper Signed";
						String IncdntRprt = "Incident Report Logged";
						String cnfrm = "Confirm";
						String resTime = appTime.get(i).getText();
						System.out.println("Resident Detail Time --> "+ resTime);
						
						//Calculate the time difference
						int timeDifference = Integer.parseInt(currentSystemTime) - Integer.parseInt(resTime) ;
						System.out.println("Time Difference -->" +timeDifference );
						
						key.click(driver, "xpath", "//span[text()='"+resTime+"']");
						Thread.sleep(1000);
						//Check buttons as per time, -ve value means 'Confirm Button'
						if(timeDifference>0 && timeDifference >120){ //+ve value Logic,difference should be greater than 60 otherwise it will be considered as current time
							System.out.println("greater then 0");
							testStep = "Following dose time: "+ resTime +" have Paper Signed and Incident Report button at execution time: "+ currentSystemTime +" ";
							
							//key.click(driver, "xpath", "//span[text()='"+resTime+"']");
							
							//Check Button in Time
							if(key.checkElementDisplay(driver, "xpath", "//span[text()='"+ resTime 
								+"']/parent::span/parent::div/parent::h4/parent::div/following-sibling::div/div/medication-dose-detail/div/button[text()='"+paperSigned+"']")
									&& key.checkElementDisplay(driver, "xpath", "//span[text()='"+ resTime 
								+"']/parent::span/parent::div/parent::h4/parent::div/following-sibling::div/div/medication-dose-detail/div/button[text()='"+IncdntRprt+"']"))
							{
								System.out.println(testStep + "--> Passed");
								vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
										bhs_Environment,"pass", " " + testStep +" Which is correct - Passed!", BHSLog_bit);
							}else{
								System.out.println(testStep + "--> Failed");
								ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
								vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
										bhs_Environment,"fail", " " + testStep +" Which is incorrect - Failed!", BHSLog_bit);	
							}
						}// end of +ve time logic
						else{// -ve value logic
							System.out.println("less then 0");
							testStep = "Following dose time: "+resTime +" have confirm button at execution time: "+ currentSystemTime +" ";
							
							//key.click(driver, "xpath", "//span[text()='"+resTime+"']");
							if(key.checkElementDisplay(driver, "xpath", "//span[text()='"+ resTime 
								+"']/parent::span/parent::div/parent::h4/parent::div/following-sibling::div/div/medication-dose-detail/div/button[text()='"+cnfrm+"']"))
							{
								System.out.println(testStep + "--> Passed");
								vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
										bhs_Environment,"pass", " " + testStep +" Which is correct - Passed!", BHSLog_bit);			
							}else{
								System.out.println(testStep + "--> Failed");
								ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
								vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
										bhs_Environment,"fail", " " + testStep +" Which is incorrect - Failed!", BHSLog_bit);
							}
							
						}// end of -ve logic
					}// end of for loop
						
					//--------------------------------------------
					
				}// presence of dose time availability
				else{
					ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
							bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
					Assert.fail(testStep+ "--Failed!! ");
				}
			}// presence of all resident condition
			else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"fail", "Test Step: " + testStep +" - Failed! :( Unable to procceed. ", BHSLog_bit);
				Assert.fail(testStep+ "--Failed!! ");
			}
			
		}//end of try
		catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail(testStep + "--Failed!! ", e);
		}
	}// End of method
	
}// end of class
