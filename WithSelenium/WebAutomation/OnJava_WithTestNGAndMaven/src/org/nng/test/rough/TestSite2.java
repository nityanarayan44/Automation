/*This is to test and generate new functions
 * for the framework. Use the URL on constants file to generate new functions
 * */
package org.nng.test.rough;

import org.nng.test.Configurations.Constants;
import org.nng.test.utills.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class TestSite2 extends GetBrowserInstance 
{
	WebDriver driver = getDriver();
	Keywords act = new Keywords();
	
	@Test
	public void testfunctions2(){
		
			try {	
				//act.gotToUrl(driver, Constants.application_URL2);
				//act.click(driver, "xpath", "//button[@id='alert']");
				
				//Thread.sleep(2000);
				//act.clickAlertOK(driver);
				//Thread.sleep(3000);
				
				//For Date and Time
					//System.out.println("C Date: " + (new DateAndTime()).getCurrentDateAsD_M_Y());
					//System.out.println("F Date: " + (new DateAndTime()).getFutureDateByDays(2));
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	
}
