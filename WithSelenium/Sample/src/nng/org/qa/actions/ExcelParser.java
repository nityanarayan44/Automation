package nng.org.qa.actions;

import nng.org.qa.configurations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*
 * 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
public class ExcelParser {
	
    static HSSFRow row;
    protected static boolean nextStatus = true;
    protected static ArrayList <String> tasks = new ArrayList<String>();
    
    public static WebDriver wdriver;
    public static Object actionObject = null;
    
    /*
     * -------------------------------------------------
     * FUNCTIONs: Processing Data of Excel File.
     * =================================================
     * */
    public static boolean canProceedToNext(){
    	//TODO: set status next True/False.
    	return ExcelParser.nextStatus;
    }
    
    public static void alert(String msg, String title, int msgType){
    	JOptionPane.showMessageDialog(null, msg, title, msgType);
    }
    
    public static void setTestUrl(String url){
    	System.out.println(">>>>>>>>>>> " + url );
    	url = url.substring(url.indexOf(',')+1, url.length()-2);
    	try {
			@SuppressWarnings("unused")
			URL link = new URL(url);
			BasicConfig.URL = url;
			/*if(link.openStream() != null){
				NNGSuite.url = url;
			}*/
			
		} catch (MalformedURLException err) {
			err.printStackTrace();
			BasicConfig.URL = null;
			ExcelParser.nextStatus = false;
		}
    	
    }
    
    /* -----------------------------------
     * Function Related web drivers 
     * -----------------------------------
     * */
    public static void initiateWebDriver(){
    	//TODO:
    	System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		ExcelParser.wdriver = new ChromeDriver();
    }
    public static void openAddress(String address){
    	ExcelParser.wdriver.get(address.toString());
    	///XLSParser.wdriver.get("http://www.google.com");
    }
    
    public static void performTask(String singleTask) throws InterruptedException{
    	//TODO:
    	String taskStatus = "";
    	boolean assertStatus = false;
    	String title = "", locatorName = "", locatorValue = "", action = "", value = "", wait = "";
    	String[] taskProperties = singleTask.split(",");
    	
				    	/*
				    	 * Setting all properties of a task.
				    	 * and executing task.
				    	 * */
    					//System.out.println("Task: "+ singleTask );
    					System.out.println("Performing Task...");
				    	if(taskProperties.length >= 6){
				    		title 			= (taskProperties[0]).toString().toUpperCase();
				    		locatorName 	= ((taskProperties[1]).toString().toUpperCase()).trim();
				    		locatorValue 	= (taskProperties[2]).toString().trim();
				    		action 			= (taskProperties[3]).toString().toUpperCase();
				    		value 			= taskProperties[4].toString().trim();
				    		wait 			= taskProperties[5].toString().trim();
				    		
				    		//Performing this given task..
					    		if(action.contains("CLICK")){
											    			actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (wdriver = DefinedActions.click(By.id(locatorValue), wdriver)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (wdriver = DefinedActions.click(By.name(locatorValue), wdriver)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (wdriver = DefinedActions.click(By.cssSelector(locatorValue), wdriver)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (wdriver = DefinedActions.click(By.xpath(locatorValue), wdriver)) : "0") ) ) ;
															if(actionObject.equals("0")){taskStatus = "Locator '"+locatorName+"' not defined.[Skipped]";}else{taskStatus = " [Done]";}
											    			
					    		}			    			
					    		else if(action.contains("WAITANDCLICK")){ 
											    			actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (wdriver = DefinedActions.waitAndClick(By.id(locatorValue), wdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (wdriver = DefinedActions.waitAndClick(By.name(locatorValue), wdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (wdriver = DefinedActions.waitAndClick(By.cssSelector(locatorValue), wdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (wdriver = DefinedActions.waitAndClick(By.xpath(locatorValue), wdriver, Integer.parseInt(wait))) : "0") ) ) ;
											    			if(actionObject.equals("0")){taskStatus = "Locator '"+locatorName+"' not defined.[Skipped]";}else{taskStatus = " [Done]";}
											    			
					    		}			    			
							    else if(action.contains("SETVALUE")){
											    			actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (wdriver = DefinedActions.setValue(By.id(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (wdriver = DefinedActions.setValue(By.name(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (wdriver = DefinedActions.setValue(By.cssSelector(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (wdriver = DefinedActions.setValue(By.xpath(locatorValue), wdriver, value)) : "0") ) ) ;
											    			if(actionObject.equals("0")){taskStatus = "Locator '"+locatorName+"' not defined.[Skipped]";}else{taskStatus = " [Done]";}
											    			
							    }			    			
							    else if(action.contains("ASSERT")){ 
											    			actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (assertStatus = DefinedActions.assertValueOfAnElement(By.id(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (assertStatus = DefinedActions.assertValueOfAnElement(By.name(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (assertStatus = DefinedActions.assertValueOfAnElement(By.cssSelector(locatorValue), wdriver, value)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (assertStatus = DefinedActions.assertValueOfAnElement(By.xpath(locatorValue), wdriver, value)) :  ( (locatorName.contains(Structures.LocatorType.WINDOW.toString())) ? ( assertStatus = DefinedActions.assertTitle(wdriver, value)) : "0" ) ) ) ) ;
											    			if(actionObject.equals("0")){taskStatus = "Locator '"+locatorName+"' not defined.[Skipped]";}else{taskStatus = " [Assertion: "+assertStatus+"]";}
											    			
							    }			    			
							    else if(action.contains("COUNT")){ 
							    							
							    }		
							    /* If action is not matched, then not performed[Skipped]*/
							    else{
							    			taskStatus = "Action not performed";
					    		}	
				    	}else{
				    		ExcelParser.alert("Missing: Task structure is missing in Excel Table.", "Task Structure Error", JOptionPane.ERROR_MESSAGE);
				    		taskStatus = "Skipping this step ...";
				    	}
				    	/*Logging Report of Task Status*/
			    		System.out.printf("\tTitle: %-50s \n\tAction: %-20s \n\tTask Status: %-20s \n\n", title, action, taskStatus);
    	//Function Ends.
    	return;
    }
    
    /**
     * ------------------------------------------------
     * 
     * Collect all data from Excel File 
     * and sets the related property.
     * ------------------------------------------------
     * */
    @SuppressWarnings("deprecation")
	public static void readAndBuildTaskFromFile(File file){
    	//TODO:
    	boolean isTasksFound = false;
    	FileInputStream filein = null;
    	HSSFWorkbook workbook = null;
    	HSSFSheet spreadsheet = null;
    	
    	try{
    				filein = new FileInputStream(file);
    				workbook = new HSSFWorkbook(filein);
    				spreadsheet = workbook.getSheetAt(0);
    				Iterator < Row > rowIterator = spreadsheet.iterator();
    				
    				String value = "", task = "";
    				while (rowIterator.hasNext()) {
    					row = (HSSFRow) rowIterator.next();
    					
    					Iterator < Cell > cellIterator = row.cellIterator();
    					
    					//Going through a row for each column if there is no issue.
		    					while ( cellIterator.hasNext() && ExcelParser.nextStatus) {
		    						Cell cell = cellIterator.next();
		    						
		    						switch (cell.getCellType()) 
		    						{
		    							case Cell.CELL_TYPE_NUMERIC: 	value += String.valueOf(cell.getNumericCellValue()) + ", ";
		    															break;
		    							case Cell.CELL_TYPE_STRING:		
		    															value += cell.getStringCellValue() + ", ";
		    															break;
		    						}/*End of Switch*/
		    								
		    						/* Searching for Task Keyword from where all task will be listed.*/
		    						if( ((value.toUpperCase())).contains("TASKS")){
		    							isTasksFound = true;
		    							System.out.println("We found the Task..... building task now..");
		    							continue;
		    						}
	    						
		    						/*Setting value and making a set for task */
		    						if(isTasksFound){
		    							task = value + "";
		    						}
		    						
		    					}/*End of inner while*/
		    					
		    					//Setting Property by Keyword.
		    					if( ((value.toUpperCase())).contains("URL")){
	    							ExcelParser.setTestUrl(value);
	    							System.out.println(value);
	    						}
	    						if( ((value.toUpperCase())).contains("TESTNAME")){
	    							BasicConfig.testTitle = value;
	    							System.out.println("We found the TestName......Setting Title for this test.");
	    						}
	    						
		    					//Setting a task into task set.
				    			if(isTasksFound){
				    				System.out.println("Adding a task to taskset...");
				    				ExcelParser.tasks.add(task);
				    			}
				    			
					    		//Reset the variables
				    			System.out.println("\n");
				    			task = value = "";
				    			
    				}/*[All Excel File has been read]*/
    				
    				
    				/**
    				 * All Task Added till now.
    				 * Final Task Set is ready, which is to be processed.
    				 * and if URL is specified then only
    				 * send one task at a time.
    				 **/
    					if(BasicConfig.URL != null){
    						ExcelParser.alert("URL: "+BasicConfig.URL, "Property Set", JOptionPane.INFORMATION_MESSAGE);
    						System.out.println("Initializing....\n\n");
		    				System.out.println("Sending Task [One task at time]>>>>>  ");
		    				ExcelParser.initiateWebDriver();
		    				ExcelParser.openAddress(BasicConfig.URL);
		    				
		    				//Start execution of testcases.
		    				for(int i = 1; i<tasks.size(); i++){
		    					ExcelParser.performTask(tasks.get(i));
		    				}
		    				//All Test performed.
		    				System.out.println("\n================================================ \n Test Completed...");
		    				System.out.println("Test: " + BasicConfig.testTitle);
		    				
    					}else{
    						ExcelParser.alert("Test URL is not set.\n\n\nReasons:\n\t1-Its Not specified in Excel File.\n\t2-Specified URL is invalid url.\n\n\t3- Check your internet Connection.", "URL Property Missing", JOptionPane.ERROR_MESSAGE);
    					}
    					
    				//Closing the Excel File Input Stream.
    					filein.close();
    				
    	}catch(IOException err){
    		ExcelParser.nextStatus = false;
    		System.out.println(err.getMessage());
    		ExcelParser.alert(err.getMessage(), "IO Exception Occured", JOptionPane.ERROR_MESSAGE);
    	}catch(Exception err){
    		ExcelParser.nextStatus = false;
    		err.printStackTrace();
    		ExcelParser.alert(err.getMessage() + "\n\n" + err.getLocalizedMessage(), "Exception Occured", JOptionPane.ERROR_MESSAGE);
    	}
    	//Function Ends.
    	return;
    }
    
    /*
     * ------------------------------------------------
     * Initiator Function: Gets file to process
     * ------------------------------------------------
     * */
    
    public static void fileParser(File file){
    	//TODO:
    	System.out.println("Trying to read given file... ");
    	
    	//Reading and extracting this File.
    		readAndBuildTaskFromFile(file);
    	
    	//Closing web driver.
    		//XLSParser.wdriver.quit();
    		
    	//Last... will going to exit from this class.
    		//Check the over all status of process [Success/Failure].
    		if(ExcelParser.nextStatus){
    			//Process successful.
    		}else{
    			//Process Failure.
    		}
    		return;
    }
    
}
