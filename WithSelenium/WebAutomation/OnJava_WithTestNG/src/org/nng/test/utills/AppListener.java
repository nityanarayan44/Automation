/*Source: 
 * http://www.guru99.com/listeners-selenium-webdriver.html
 * http://www.seleniumeasy.com/testng-tutorials/logging-with-testng-using-listeners
 * 
 * Either extend 'TestListenerAdapter' or implement  Interface 'ITestListener' 
 * which is a listener for test running.
 * 
 * With the help of listeners we modify the behavior of TestNG. Can Create logs with 
 * the help of listners. Examples, use "onTestFailure" to takescreenshot when test failes.
 * 
 * This class will listen the execution and will contain code while framework execution. 
 * There are 2 ways to imeplement listener. 
 * 1st is: use "@Listeners(<TestcaseName>.<ListenerClassName>.class)" in Testcases file. like in this case check below syntax
 * @Listeners(ListenerTestDemo.class) or if there are number of classes as tag to testNG.class
 * */

package org.nng.test.utills;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.nng.test.utills.GetBrowserInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

// Implementing ItestListener and its unimplemented methods
public class AppListener implements ITestListener

{

	//Driver instance
	WebDriver driver;

	//When Testcase gets failed this method is called
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is: " + result.getName());
		//this.driver = ((GetBrowserInstance)result.getInstance()).getDriver();
		captureScreen(driver, result.getName(), result.getTestName());
		
		
	}
	
	public String captureScreen(WebDriver driver, String folder, String result ) {
		String path;
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			path = "./screenshots/" + folder + "/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return path;
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
