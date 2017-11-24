/*This is an example testcase to demonstrate cross browsing scenario (Line 39: using parameter)
 *  or
 * if a test exection is needed using only 1 browser. (Line - 30)
 * 
 * */

package com.Cases.TestCode;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utills.AppListener;
import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ScreenShotCapture;
import com.test.Initialisers.Constants;



//@Listeners(AppListener.class)

public class TestSite1 extends GetBrowserInstance
{
	//This is one way to call driver
	//WebDriver driver = getDriver();
	
	WebDriver driver;
	Keywords act = new Keywords();
	
	//This is another way to call driver for crossbrowser testing 
	//CrossBrowser setup from TestNG.xml
	@BeforeTest
	@Parameters("browser")
	public void browserSetup(String browser){
		if(browser.equalsIgnoreCase("Chrome")){
			driver = initChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			driver = initEdgeDriver();
			
		}
		
	}
	
	
	@Test
	public void testFuntions1(){
		//driver.get("https://testpoint.vansah.net/");
	//	act.gotToUrl(driver, Constants.application_URL1);
		//act.selectFromDropDown(driver, "id", "continents", "text", "Europe");
		//act.selectFromDropDown(driver, "id", "continents", "index", "3");
		
		act.EnterText(driver, "id", "login_email", "ishan.kumar@testpoint.com.au");
		act.EnterText(driver, "id", "login_pass", "testpoint@123");
		
		
		try 
		{
			act.click(driver, "xpath", "//button[@id='login_submit']");
		
			Thread.sleep(5000);
			
			
			act.click(driver, "xpath", "//div[@data-id='customization']/img");
			act.click(driver, "xpath", "//div[@id='proj-changer']/div[2]/input");
			act.click(driver, "xpath", "//li[contains(text(),'Sandbox')]");
			Thread.sleep(3000);
			act.click(driver, "xpath", "//div[@data-asset='req']/a");
			act.click(driver, "xpath", "//a[@data-id='board-create-req']");
			act.click(driver, "xpath", "//a[@data-asset='req']/span[text()='FUNCTIONAL']");
			//#####################

			act.selectFromDropDown(driver, "xpath", "//div/select[@id='req-priority']", "value", "31");
			
			Thread.sleep(5000);
			act.selectFromDropDown(driver, "id", "proj-changer-selector", "index", "2");

			act.selectFromDropDown(driver, "id", "proj-changer-selector", "text", "TestPoint Practice (PRAC)");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ScreenShotCapture.captureScreen(driver, driver.getTitle());
			Assert.fail("here's the stackTace..-->" +" " + e);
		}
		
	}
	
	
}
