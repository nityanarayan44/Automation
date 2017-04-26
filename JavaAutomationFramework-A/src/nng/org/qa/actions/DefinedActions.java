package nng.org.qa.actions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import nng.org.qa.configurations.BasicConfig;

public class DefinedActions {

	/* All actions */
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return void
	 * @Description function for takingscreenshot, takes 3 parameters: By, Webdriver and outputFileName objects and returns void.
	 * */
	public static void takeScreenShot(By by, WebDriver webdriver, String outputFileName) throws IOException, Exception{
		String output = outputFileName;
		/* Taking screenshot of Web Browser window */
			File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		/* Saving the screenshot. */
			FileUtils.copyFile(scrFile, new File(output));
		return ;
	}


	/* Perform action on a webElement */
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return WebDriver
	 * @Description function for click action after some wait, takes 3 parameters By, Webdriver, and Integer objects and returns webdriver state.
	 * */
	public static WebDriver waitAndClick(By by, WebDriver webdriver, Integer waitInSeconds){
		//Performing some driver wait and then clicking on it.
			WebDriverWait wait = new WebDriverWait(webdriver, waitInSeconds);
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(by));
			try{
				ele.click();
				BasicConfig.currentStepStatus = true;
			}catch(Exception err){
				//err.printStackTrace();
				BasicConfig.currentStepStatus = false;
				BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
			}
		//Returning the driver state.
			return webdriver;	
	}

	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return WebDriver
	 * @Description function for click action, takes 2 parameters By and Webdriver objects and returns webdriver state.
	 * */
	public static WebDriver click(By by, WebDriver webdriver) throws InterruptedException{
		Thread.sleep(1000);
		//Clicking to element via by.
		try{
			webdriver.findElement(by).click();
			BasicConfig.currentStepStatus = true;
		}catch(Exception err){
			//err.printStackTrace();
			BasicConfig.currentStepStatus = false;
			BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
		}
		//Returning the driver state.
			return webdriver;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return WebDriver
	 * @Description function for seting a given value to an web element, takes 3 parameters By, Webdriver, keyValue objects and returns webdriver state.
	 * */
	public static WebDriver setValue(By by, WebDriver webdriver, String keyValue){
		//Setting some value to an WebElement via By.
		try{
			webdriver.findElement(by).sendKeys(keyValue);
			BasicConfig.currentStepStatus = true;
		}catch(Exception err){
			//err.printStackTrace();
			BasicConfig.currentStepStatus = false;
			BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
		}
		//Returning the driver state.
		return webdriver;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return WebDriver
	 * @Description function for getting value of an web element, takes 2 parameters By and Webdriver objects and returns a string obtained from given web element locator.
	 * */
	public static String getValue(By by, WebDriver webdriver){
		//Returning Value;
		String value = "";
		try{
			value = webdriver.findElement(by).getText().toString();
			BasicConfig.currentStepStatus = true;
		}catch(Exception err){
			BasicConfig.currentStepStatus = false;
			BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
		}
		return value;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return boolean
	 * @value true/false
	 * @Description function for asserting a window title text, takes 2 parameters By and String objects and returns assert result.
	 * */
	public static boolean assertTitle(WebDriver webdriver, String expectedValue){
		boolean testCaseStatus = false;
		try{
			//Asserting with a string Value
				Thread.sleep(1000);
				Assert.assertEquals(webdriver.getTitle().toString(), expectedValue);
			//Setting the status :: assertion is true.
				testCaseStatus = true;
		}
		catch(InterruptedException err){
			//Assert is not possible right now.
			//err.printStackTrace();
			testCaseStatus = false;
			BasicConfig.currentStepStatus = false;
			BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
			return false;
		}
		catch(AssertionError err){
			//Setting the status :: assertion is false
			//err.printStackTrace();
			testCaseStatus = false;
			BasicConfig.currentStepStatus = false;
			BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
			return false;
		}
		//Returning the assertion status
		return testCaseStatus;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param
	 * @return boolean
	 * @value true/false
	 * @Description function for asserting a value with an web-element value, takes 3 parameters By, WebDriver and String objects and returns assert result.
	 * */
	public static boolean assertValueOfAnElement(By by, WebDriver webdriver, String expectedValue){
		boolean testCaseStatus = false;
		try{
			//Asserting with a string Value
				Assert.assertEquals(webdriver.findElement(by).getText(), expectedValue);
			//Setting the status :: assertion is true.
				testCaseStatus = true;
		}catch(AssertionError err){
			//Setting the status :: assertion is false
				testCaseStatus = false;
				BasicConfig.currentStepStatus = false;
				BasicConfig.currentStepComment = (err.getMessage().toString()).substring(0, 30);
		}
		//Returning the assertion status
		return testCaseStatus;
	}
	
}/*End of class.*/
