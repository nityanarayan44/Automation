package org.nng.test.Sample.TestCases;

import java.util.HashMap;
import java.util.Map;

import org.nng.automation.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class MobileWebAppium_GoogleSearch {


	/* 
	 * +====================================+
	 * | Global Instance					|
	 * +====================================+
	 */
		public Driver driver;
	
	/* 
	 * +====================================+
	 * | Test [Test with MobileWebBrowser]	|
	 * | Your Test Goes here....			|			
	 * +====================================+
	 */
	  @Test (priority = 1, enabled = true)
	  public void f() throws Exception {
		// Open an address
			this.driver.appiumDriver.get("https://www.google.co.in");
		
		// Wait for few seconds.
			Thread.sleep(3000);
			
		// Search Something
			this.driver.appiumDriver.findElement(By.name("q")).sendKeys("This is a Search String" + Keys.ENTER);
			
		// Printout the page source:
			System.out.println( "\n\n\n SRC >> \n\n" + this.driver.appiumDriver.getPageSource()) ;
			
		// Last
			return;
	  }
 
	/* 
	 * +============================================+
	 * | TestNG Configuration Settings				|
	 * | Just for Initialization and finalization 	|
	 * +============================================+
	 */
	  
	  @BeforeClass
	  public void beforeClass() throws Exception {
		  /*
		   * Mandatory capability for android
		   * 1- DeviceName
		   * 2- PlatformName
		   * 3- udid
		   * */
		  	driver = new Driver();
			Map<String, String> opt = new HashMap<String, String>();
			opt.put("url", 	"http://127.0.0.1:4723/wd/hub/");
			opt.put(MobileCapabilityType.PLATFORM_NAME, 	"Android");
			opt.put(MobileCapabilityType.PLATFORM_VERSION, 	"7.0");
			opt.put(MobileCapabilityType.DEVICE_NAME, 		"ZY2242RDQX");
			opt.put(MobileCapabilityType.BROWSER_NAME,		"Chrome");
			// Getting MobileWeb Appium Driver
			this.driver.getAppiumDriver(opt);
			return;
	  }
	
	  @AfterClass
	  public void afterClass() throws Exception {
		  System.out.println("Test Executed.");
		  //this.driver.androidDriver.quit();
		  //this.driver.appiumDriver.quit();
	  }

	
} /*E-O-Class*/
