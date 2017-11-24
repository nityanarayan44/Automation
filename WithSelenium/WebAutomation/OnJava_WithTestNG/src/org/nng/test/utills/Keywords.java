/*
 * This class will contains one function per keyword. Every function should 
 * have proper comments explaining what that function do.
 */
package org.nng.test.utills;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Keywords
{
	WebElement element = null;

	/* 
	 * findElementWait method specification :-
	 * This method will wait for an element to be visible, it requires following parameters
	 * @elementIdentifier: Type of element require to wait
	 * @elementValue: Value of that element
	 */

	public WebElement findElementWait(WebDriver driver, String elementIdentifier, String elementValue)
	{

		int timer = 15;
		WebDriverWait wait = new WebDriverWait(driver, timer);	
		if(elementIdentifier.equalsIgnoreCase("xpath"))
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementValue)));
		else if(elementIdentifier.equalsIgnoreCase("id"))
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementValue)));
		else if(elementIdentifier.equalsIgnoreCase("className"))
			element = wait.until(ExpectedConditions.elementToBeClickable(By.className(elementValue)));
		else if(elementIdentifier.equalsIgnoreCase("linkText"))
			element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(elementValue)));

		return element;
	}

	public WebElement waitTillElementIsPresent(WebDriver driver, String elementIdentifier, String elementValue, int waitTime) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		// Identify accordingly
		switch(elementIdentifier.toUpperCase()) {
			case "XPATH"		: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementValue))); 		break;
			case "LINKTEXT"		: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementValue))); 	break;
			case "CLASSNAME"	: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementValue))); 	break;
			case "NAME"			: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementValue))); 		break;
			case "TAGNAME"		: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(elementValue))); 		break;
			case "ID"			: element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementValue))); 			break;
		}
		//Return
		return element;
	}
	/* 
	 * gotToUrl method specification :-
	 * This method will navigate to the given URL, it requires following parameter
	 * @url--> requires SiteURL as an input 
	 */	
	public void gotToUrl(WebDriver driver, String url)
	{
		driver.get(url);
		//driver.manage().window().maximize();
	}

	/* 
	 * EnterText method specification :-
	 * This method will Enter textvalue in to a given input boxe element, it requires
	 * @elementIdentifier: Type of element require to wait
	 * @elementValue: Value of that element
	 * @text: Text to be entered
	 */	
	public void EnterText(WebDriver driver, String elementIdentifier,String elementValue,String text){
		WebElement element=findElementWait(driver, elementIdentifier, elementValue);
		element.sendKeys(text);
	}
	
	
	/* 
	 * click method specification :-
	 * This method should be used to click on element, it requires
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 */	
	public void click(WebDriver driver, String elementIdentifier,String elementValue){
		WebElement element=findElementWait(driver, elementIdentifier, elementValue);
		element.click();
	}


	/*This function should be used to select dropdown
	 * following arguments are required.
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 * @dropdownType: Dropdown argument
	 * @dropDownValue: value to select
	 */	
	public void selectFromDropDown(WebDriver driver, String elementIdentifier, String elementValue, 
			String dropdownType, String dropDownValue)
	{	
		WebElement element = findElementWait(driver, elementIdentifier, elementValue);
		Select dropdown = new Select(element);

		//select based on the type
		if(dropdownType.equalsIgnoreCase("Text"))
			dropdown.selectByVisibleText(dropDownValue);
		else if(dropdownType.equalsIgnoreCase("Value"))
			dropdown.selectByValue(dropDownValue);
		else if(dropdownType.equalsIgnoreCase("Index"))			
			dropdown.selectByIndex(Integer.parseInt(dropDownValue));
	}



	/*This function should be used to clear text 
	 * following arguments are required.
	 * @driver = driver object to perform selenium operations
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 */	
	public void clearText(WebDriver driver,String elementIdentifier,String elementValue){
		WebElement element = findElementWait(driver, elementIdentifier, elementValue);
		element.clear();
	}


	/* This function should be used to click OK
	 * on alert
	 */	
	public void clickAlertOK(WebDriver driver){
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	
	
	public String getElementAttrib(WebDriver driver, String elementIdentifier, String elementValue, String attrib) {
		WebElement element = findElementWait(driver, elementIdentifier, elementValue);
		return element.getAttribute(attrib).toString();
	}
	/* This function should be used to check if the element 
	 * is displayed on the Page
	 * @driver = driver object to perform selenium operations
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 */	
	public boolean checkElementDisplay(WebDriver driver,String elementIdentifier,String elementValue){
		try // try is added to check if it reurns false when the element is not present
		{
			WebElement element = findElementWait(driver, elementIdentifier, elementValue);
			if (element.isDisplayed()) {
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
			
	}
	
	/* This function should be used to retrieve text from element
	 * @driver = driver object to perform selenium operations
	 * @elementIdentifier: Type of element we require to wait
	 * @elementValue: Value of that element
	 */	
	public String getText(WebDriver driver,String elementIdentifier,String elementValue){
		WebElement element = findElementWait(driver, elementIdentifier, elementValue);
		String text = element.getText();
		return text;
	}

	
	/* This function should be used to retrieve all the elements
	 * @driver = driver object to perform selenium operations
	 * @elementValue: Value of that element
	 */	
	public List<WebElement> fetch_AllElements(WebDriver driver, String elementValue){
		List<WebElement> elementList=new ArrayList<WebElement>();
		elementList = driver.findElements(By.xpath(elementValue));
		return elementList;
	}
	
}// end of class
