package com.Cases.TestCode;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.test.Initialisers.Constants;

public class BHS_TestCode extends GetBrowserInstance
{
	WebDriver driver = getDriver();
	Keywords key = new Keywords();
	
	
	@Test
	public void TestBHS_SiteMon(){
		String USER_NAME_RN = "testrn";
		String PASSWORD_RN = "Password#123";
		
		key.gotToUrl(driver, Constants.application_URL);
		key.EnterText(driver, "xpath", "//input[@id='bmUserName']", USER_NAME_RN);
		key.EnterText(driver, "xpath", "//input[@id='bmPassword']", PASSWORD_RN);
		key.click(driver, "xpath", "//button[@class='block btn btn-success full-width m-b']");
		
	}
}
