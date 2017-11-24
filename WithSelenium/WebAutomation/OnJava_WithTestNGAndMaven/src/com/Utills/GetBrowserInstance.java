/*  
 * @Author: Ishan
 * This is a superclass which will use to initialize
 *  the WebDriver and Vansah objects. This class will also initiate the
 *  browser instance based on what is mentioned in the constants file.
 *  All the test cases should extend this class for driver and Vansah API usage.
 *  
 * */

package com.Utills;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.test.Initialisers.Constants;


public class GetBrowserInstance 
{
	
	public WebDriver driver;
	public String browserName = Constants.browser;
	
	//Calculate Time
	long startTime;
	long endTime;
	long totalExecutionTime;

		
	/*This function will Initiate the type of browser defined in constants file
	 * and will create the browser instance accordingly
	 * */
	public  WebDriver getDriver()
	{
		if(browserName.equalsIgnoreCase("chrome")){
			driver = initChromeDriver();
			//driver = initChromeDriverIncognito();
		}else if(browserName.equalsIgnoreCase("Edge")){
			driver = initEdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = initFirefoxDriver();
		}
		
		return driver;
	}
	
	
	/*
	 * This function will create the Chrome browser instance 
	 * In Incognito mode  and return the driver
	 * */
	public WebDriver initChromeDriverIncognito()
	{	
		System.setProperty("webdriver.chrome.driver", "Lib\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		// Issue in using this with incognito window  
		//driver.manage().window().maximize();  	
		return driver;
		
	}
	
	/*
	 * This function will create the Chrome browser instance 
	 * and return the driver
	 * */
	public WebDriver initChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "Lib\\chromedriver.exe");
		//System.load("Lib\\sigar-amd64-winnt.dll");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		return driver;
	}
	
	/*
	 * This function will create the Edge browser instance 
	 * and return the driver.
	 * Please Note: This will oncly work with windows10 Environment.
	 * */
	public WebDriver initEdgeDriver(){
		System.setProperty("webdriver.edge.driver", "Lib\\MicrosoftWebDriver.exe");
	    DesiredCapabilities capabilities = DesiredCapabilities.edge();
	    driver = new EdgeDriver(capabilities);
		//driver = new EdgeDriver();
		return driver;
	}
	
	/*
	 * This function will create the firefox browser instance 
	 * and return the driver.
	 * */
	
	public WebDriver initFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", "Lib\\geckodriver.exe");
	    driver = new FirefoxDriver();
		return driver;
	}
	
	/*To save Suite Start time*/
	@BeforeSuite
	public void starttime()
	{
		startTime = System.currentTimeMillis();	
	}
	
	/*To save Suite End Time and Print it*/
	@AfterSuite
	public void aftertime()
	{
		endTime = System.currentTimeMillis();
		totalExecutionTime = endTime - startTime;
		System.out.println("Test Start Time --> " + startTime);
		System.out.println("Test End Time --> " + endTime);
		
		NumberFormat formatter = new DecimalFormat("#0.00000");
		formatter.format(totalExecutionTime/1000d);
		System.out.println("Total Execution Time--> "+ formatter.format(totalExecutionTime/1000d) + " Seconds");	
		//System.out.println(("Total Execution Time 2--> "+ totalExecutionTime/3600) + " hours " + ((totalExecutionTime/60)%60) + " minutes " + (totalExecutionTime%60) + " seconds");
	}
	
	
	/*
	 * Quite the browser instance once everything is done
	 * */
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		{	
			/*
			 * Since we are finally closing the web driver, thats why calling the quit method.
			 * driver.quit() method will call driver.dispose() method which will dispose the current driver reference.
			 */
			driver.quit();
			driver = null;
		}
	}
}
