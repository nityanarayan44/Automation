package org.nng.test.regression.TestCases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.nng.test.Configurations.Constants;
import org.nng.test.pageObjects.HomePage;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.nng.test.utills.ScreenShotCapture;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testpoint.StreamTest;

public class TC_05_VerifyColorCode extends GetBrowserInstance
{
	//WebDriver driver = getDriver();
	WebDriver driver;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();
	HomePage homePage = new HomePage();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "7";
	String vansahTestCaseID = "5";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_05_VerifyColorCode";
	String testStep = "";
	
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}
	
	@Test
	public void verifyColorCode()
	{
		vansah.setProperty("sAgentName", Constants.vansahAgentName);
	
		try
		{
		
			//Login into Application
			testStep = "User Perform Login";
			homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//Select Section
			String SectionName = Constants.sectionName;
			testStep = "User Select Section: "+SectionName+" ";
			homePage.selectSection(driver, SectionName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(2000);
			//ClickOnMedicationRound
			testStep = "User Clicks on MedicationRound";
			CounterName = "MedicationRound-Page-Load";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			homePage.clickOn_MedicationRound(driver);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
					bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//------- Verify if Today is selected as default -------
			testStep = "Verify if today is selected as system default";
			//String todaySelection = "//div[contains(@class,'btn-group')]/a[contains(@class,'btn-primary')]";
			//String selectedButton = key.getText(driver, "xpath", todaySelection);	
			if(homePage.verify_IfTodayIsSelected(driver)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);	
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
				Assert.fail("Today is not selected as Default");
			}
			
			//------------- Verify Color Code ----------
			//Get the system time
		      Calendar cal = Calendar.getInstance();
		      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		      String systemTime = sdf.format(cal.getTime());
		      System.out.println( sdf.format(cal.getTime()) );
			
			
			
			
			String medicationRoundInRed= "(//a[contains(@class,'btn-danger') and contains(@ng-click,'doseRound')])[1]";
			String medicationRoundInBlue= "(//a[contains(@class,'btn-primary') and contains(@ng-click,'doseRound')])[1]";
			String medicationRoundInWhite = "(//a[contains(@class,'future-round') and contains(@ng-click,'doseRound')])[1]";
			

			//String medicationRoundInGrey = "(//a[contains(@class,'round-completed') and contains(@ng-click,'doseRound')])[1]";
			
			// Verify red color
			testStep = "Verify the presence of red Colour for missed medication";
			if(key.checkElementDisplay(driver, "xpath", medicationRoundInRed)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "We don't have any medication round in red color and following was the system time when execution happened:"+systemTime+" ", BHSLog_bit);
				
			}
			
			// Verify Blue color
			testStep = "Verify the presence of blue Colour for open dose round";
			if(key.checkElementDisplay(driver, "xpath", medicationRoundInBlue)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "We don't have any medication round in blue color and following was the system time when execution happened:"+systemTime+" ", BHSLog_bit);
				}
			
			// Verify White color
			testStep = "Verify the presence of White Colour for future dose close round";
			if(key.checkElementDisplay(driver, "xpath", medicationRoundInWhite)){
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild,
						bhs_Environment,"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			}else{
				ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
				vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
						"fail", "We don't have any medication round in White color and following was the system time when execution happened:"+systemTime+" ", BHSLog_bit);
			}
			
		}catch(Exception e){
			ScreenShotCapture.captureScreen(driver, vansahTestcaseName);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"fail", "Execution on the following Step: " + testStep +" -is Failed!", BHSLog_bit);
			vansah.hostAlert("During Test Case " + vansahTestcaseName + " Failed! Following is the stack trace: "+e, 2);
			Assert.fail("There is an Error with test execution", e);

		}
		
		
	}
	

}
