package org.nng.test.Sample.pageObjects;
import org.nng.automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Google {
	
	/*
	 * ==========================================================
	 * Global Objects/Vars
	 * ==========================================================
	 * 
	 */
		Action action = new Action();
	/*
	 * ==========================================================
	 * Locators [Specific for google page]
	 * ==========================================================
	 */
		String googleUrl = "https://www.google.co.in/";
		String googleSearchBox = "q";
		
		//--- Search Categories [Image | Video | News | Maps ]
			String searchcategoryImage 	= "//a[contains(text(), 'Images') and contains(@href, '/search?')]";
			String searchcategoryVideo 	= "//a[contains(text(), 'Videos') and contains(@href, '/search?')]";
			String searchcategoryNews 	= "//a[contains(text(), 'News') and contains(@href, '/search?')]";
			String searchcategoryMaps	= "//a[contains(text(), 'Maps') and contains(@href, '/maps?')]";
		
		//--- Search Result
			String searchResultForImage = "//*[@id='ires']//a/img";
			String searchResultForVideo = "";
			String SearchResultForNews  = "";
	/*
	 * ==========================================================
	 * Functions
	 * ==========================================================
	 */
		//--- Search Category
		//-------------------
				// OPen Google
				public WebDriver openGoogleSearch(WebDriver webDriver) throws Exception {
					webDriver.get(this.googleUrl);
					return webDriver;
				}
				// Default search
				public WebDriver search(WebDriver webDriver, String keyword) throws Exception {
					webDriver.findElement(By.name(this.googleSearchBox)).sendKeys(keyword+Keys.ENTER);
					return webDriver;
				}
				
				// Google Search for Image
				public WebDriver searchImage(WebDriver webDriver, String keyword) throws Exception {
					webDriver.findElement(By.name(this.googleSearchBox)).sendKeys(keyword+Keys.ENTER);
					this.action.doClick(webDriver, "xpath", this.searchcategoryImage);
					return webDriver;
				}
				
				// Google Search for Video
				public WebDriver searchVideo(WebDriver webDriver, String keyword) throws Exception {
					webDriver.findElement(By.name(this.googleSearchBox)).sendKeys(keyword+Keys.ENTER);
					this.action.doClick(webDriver, "xpath", this.searchcategoryVideo);
					return webDriver;
				}
			
				// Google Search for News
				public WebDriver searchNews(WebDriver webDriver, String keyword) throws Exception {
					webDriver.findElement(By.name(this.googleSearchBox)).sendKeys(keyword+Keys.ENTER);
					this.action.doClick(webDriver, "xpath", this.searchcategoryNews);
					return webDriver;
				}
				
				// Google Search On Map
				public WebDriver searchMaps(WebDriver webDriver, String keyword) throws Exception {
					webDriver.findElement(By.name(this.googleSearchBox)).sendKeys(keyword+Keys.ENTER);
					this.action.doClick(webDriver, "xpath", this.searchcategoryMaps);
					return webDriver;
				}
				
		//--- Data Retrieval
		//------------------
				public int getTotalImageCount(WebDriver webDriver) throws Exception {
					return webDriver.findElements(By.xpath(this.searchResultForImage)).size();
				}
}
