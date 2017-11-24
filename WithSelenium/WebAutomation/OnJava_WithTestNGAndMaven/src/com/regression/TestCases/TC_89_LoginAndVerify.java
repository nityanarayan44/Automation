package com.regression.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;

import testpoint.StreamTest;

public class TC_89_LoginAndVerify  extends GetBrowserInstance
{
	//WebDriver driver = getDriver();
	WebDriver driver ;
	Keywords key = new Keywords();
	StreamTest vansah = new StreamTest();

	String CounterName;
	String monitorCode = Constants.sitemon_Monitor;;

	String vansahPackage = Constants.vansahPackage;
	String vansahRequirement = "14";
	String vansahTestCaseID = "89";
	String vansahBuild = Constants.build;
	String vansahRelease = Constants.release;
	String bhs_Environment = Constants.environment;
	String BHSLog_bit = Constants.log_Bit;
	String vansahTestcaseName = "TC_89_LoginAndVerify";
	String testStep = "";
	
	@BeforeTest
	public void getBrowserInstance(){
		driver = getDriver();
	}
	
	@Test
	public void verifyLogin(){
		vansah.setProperty("sAgentName", Constants.vansahAgentName);

		try
		{	
			//Navigate to URL
			CounterName = "Login-Page-Load";
			testStep = "Navigate to URL";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			key.gotToUrl(driver, Constants.application_URL);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			

			//homePage.performLogin(driver, Constants.USER_NAME_RN, Constants.PASSWORD_RN);
			String userLocator = "//input[@id='bmUserName']";
			String passLocator = "//input[@id='bmPassword']";
			String submitBtnLocator = "//button[@class='block btn btn-success full-width m-b']";
			
			//Enter Username & Password
			testStep = "Enter user Name/Password Values";
			key.EnterText(driver, "xpath", userLocator, Constants.USER_NAME_RN);
			key.EnterText(driver, "xpath", passLocator, Constants.PASSWORD_RN);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			//Click on Submit button
			CounterName = "Home-Page-Load";
			testStep = "click on Submit Button";
			vansah.Start_SiteMon_Synthetic(CounterName, monitorCode);
			key.click(driver, "xpath", submitBtnLocator);
			vansah.Stop_SiteMon_Synthetic(CounterName, monitorCode);
			vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
					"pass", "Test Step: " + testStep +" - Passed!", BHSLog_bit);
			
			Thread.sleep(2000);
			
			//Verify Availability of Menu Items
			testStep = "Find Menu Items";
			String menuItems = "//div[contains(@class, 'row')]/div/a/img";
			List<WebElement> elementList=new ArrayList<WebElement>();
			elementList = driver.findElements(By.xpath(menuItems));
			System.out.println("###"+ elementList.size());
			for(WebElement ele : elementList){
				System.out.println("###"+ ele.getAttribute("alt"));	
				if(ele.getAttribute("alt") != null){
					vansah.sendUpdateLog(vansahPackage, vansahRequirement, vansahTestCaseID, vansahRelease, vansahBuild, bhs_Environment,
							"pass", "Item Presence Verified: " + ele.getAttribute("alt") +" - Passed!", BHSLog_bit);		
				}
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
