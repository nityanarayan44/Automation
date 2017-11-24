package org.nng.test.rough;

import org.nng.test.Configurations.Constants;
import org.nng.test.utills.GetBrowserInstance;
import org.nng.test.utills.Keywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCode3 extends GetBrowserInstance
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
