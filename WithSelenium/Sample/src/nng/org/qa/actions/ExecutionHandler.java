package nng.org.qa.actions;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import nng.org.qa.configurations.BasicConfig;
import nng.org.qa.reports.Template;

public class ExecutionHandler {
	
	/**
	 * @author Ashutosh Mishra
	 * @param task
	 * @return
	 * @throws InterruptedException 
	 * @description executing a task.
	 */
	public static boolean executeTask(int taskIndex, String singleTask) throws InterruptedException{
		boolean taskStatus = false;
		long tStart = 0, totalTime = 0;
		String taskReason = " ";
		//String stepData = "";
		String title = "", locatorName = "", locatorValue = "", action = "", value = "", wait = "";
    	String[] taskProperties = singleTask.split(",");
    	
				    	/*
				    	 * Setting all properties of a task.
				    	 * and executing task.
				    	 * */
    					if(taskProperties.length >= 6){
				    		title 			= (taskProperties[0]).toString().toUpperCase();
				    		locatorName 	= ((taskProperties[1]).toString().toUpperCase()).trim();
				    		locatorValue 	= (taskProperties[2]).toString().trim();
				    		action 			= (taskProperties[3]).toString().toUpperCase();
				    		value 			= (taskProperties[4]).toString().trim();
				    		wait 			= (taskProperties[5]).toString().trim();
				    		
				    		//Performing this given task..
				    		/*Logging Report of Task Status*/
				    		//System.out.println("\n\t[Performing Task...]\n\t-----------------------------");
				    		//System.out.printf("\t\tTitle: %-50s \n\t\tAction: %-20s", title, action);
				    		
					    		if(action.contains("CLICK")){
					    									tStart = System.currentTimeMillis();
											    			BasicConfig.actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (BasicConfig.webdriver = DefinedActions.click(By.id(locatorValue), BasicConfig.webdriver)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (BasicConfig.webdriver = DefinedActions.click(By.name(locatorValue), BasicConfig.webdriver)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (BasicConfig.webdriver = DefinedActions.click(By.cssSelector(locatorValue), BasicConfig.webdriver)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (BasicConfig.webdriver = DefinedActions.click(By.xpath(locatorValue), BasicConfig.webdriver)) : "0") ) ) ;
											    			totalTime = System.currentTimeMillis() - tStart;
											    			if(BasicConfig.currentStepStatus == false){taskStatus = false; taskReason="Unable to click to an element without wait.";}else{taskStatus = true;}
											    			//System.out.println("Click: " + BasicConfig.actionObject);
											    			
					    		}			    			
					    		else if(action.contains("WAITANDCLICK")){ 
					    									tStart = System.currentTimeMillis();
					    									BasicConfig.actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (BasicConfig.webdriver = DefinedActions.waitAndClick(By.id(locatorValue), BasicConfig.webdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (BasicConfig.webdriver = DefinedActions.waitAndClick(By.name(locatorValue), BasicConfig.webdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (BasicConfig.webdriver = DefinedActions.waitAndClick(By.cssSelector(locatorValue), BasicConfig.webdriver, Integer.parseInt(wait))) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (BasicConfig.webdriver = DefinedActions.waitAndClick(By.xpath(locatorValue), BasicConfig.webdriver, Integer.parseInt(wait))) : "0") ) ) ;
					    									totalTime = System.currentTimeMillis() - tStart;
					    									if(BasicConfig.currentStepStatus == false){taskStatus = false; taskReason="Unable to click to an element even after given wait.";}else{taskStatus = true;}
											    			//System.out.println("WaitnClick: " + BasicConfig.actionObject);
											    			
					    		}			    			
							    else if(action.contains("SETVALUE")){
							    							tStart = System.currentTimeMillis();
											    			BasicConfig.actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (BasicConfig.webdriver = DefinedActions.setValue(By.id(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (BasicConfig.webdriver = DefinedActions.setValue(By.name(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (BasicConfig.webdriver = DefinedActions.setValue(By.cssSelector(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (BasicConfig.webdriver = DefinedActions.setValue(By.xpath(locatorValue), BasicConfig.webdriver, value)) : "0") ) ) ;
											    			totalTime = System.currentTimeMillis() - tStart;
											    			if(BasicConfig.currentStepStatus == false){taskStatus = false; taskReason="Unable to set the value to given element";}else{taskStatus = true;}
											    			//System.out.println("SetValue: " + BasicConfig.actionObject);
											    			
							    }			    			
							    else if(action.contains("ASSERT")){ 
							    							tStart = System.currentTimeMillis();
											    			BasicConfig.actionObject = (locatorName.contains(Structures.LocatorType.ID.toString()))?  (taskStatus = DefinedActions.assertValueOfAnElement(By.id(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.NAME.toString()))?  (taskStatus = DefinedActions.assertValueOfAnElement(By.name(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.CSSSELECTOR.toString()))?  (taskStatus = DefinedActions.assertValueOfAnElement(By.cssSelector(locatorValue), BasicConfig.webdriver, value)) : ((locatorName.contains(Structures.LocatorType.XPATH.toString()))?  (taskStatus = DefinedActions.assertValueOfAnElement(By.xpath(locatorValue), BasicConfig.webdriver, value)) :  ( (locatorName.contains(Structures.LocatorType.WINDOW.toString())) ? ( taskStatus = DefinedActions.assertTitle(BasicConfig.webdriver, value)) : "0" ) ) ) ) ;
											    			totalTime = System.currentTimeMillis() - tStart;
											    			//System.out.println("Assertion: " + BasicConfig.actionObject.toString());
											    			//if(BasicConfig.actionObject.toString().contains("false") || BasicConfig.actionObject.toString().contains("0")){taskStatus = true; taskReason="Assertion passed";}else{taskStatus = false; taskReason="Assertion failure"; System.out.println("Assertion failed.");}
											    			if(taskStatus){taskStatus = true; taskReason="Assertion passed";}else{taskStatus = false; taskReason="Assertion failure"; }
											    			
							    }			    			
							    else if(action.contains("COUNT")){ 
							    							tStart = System.currentTimeMillis();
							    							taskStatus = false;
							    							taskReason = "Not avalable yet.";
							    							totalTime = System.currentTimeMillis() - tStart;
							    }		
							    /* If action is not matched, then not performed[Skipped]*/
							    else{
							    			taskStatus = false;
							    			taskReason = "given '"+action+"' action is not defined yet.";
					    		}	
				    	}else{
				    		//ExcelParser.alert("Missing: Task structure is missing in Excel Table.", "Task Structure Error", JOptionPane.ERROR_MESSAGE);
				    		taskStatus = false;
				    		taskReason = "Skipping this step ... task Structure mismatched.";
				    	}
				    	
			    		if(taskStatus){
			    			Template.passedtestcases++;
			    			//stepData += "<br/>\t\t Failure Reason: "+ BasicConfig.currentStepComment+"<br/>";
			    		}
			    		
			    		//Using Template.
			    		//Creating and feeding a testcase data in report.
			    		Template.createTCase(taskIndex, title, action, totalTime, taskStatus, taskReason);
			    		
		//Function Returns.
    	return taskStatus;
	}
	
	
	/**
	 * @author Ashutosh Mishra
	 * @param url
	 * @return void
	 */
	public static void invokeWebDriverWithAddress(String url){
		//System Property Setting.
		System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		BasicConfig.webdriver = new ChromeDriver();
		BasicConfig.webdriver.get(url);
		return;
	}
	
	/**
	 * @param scenario
	 * @return
	 * @throws InterruptedException 
	 * @description Executes each steps of  given scenario and return if that given scenario is fails or pass.
	 */
	public static boolean executeScenario(ArrayList<String> scenario) throws InterruptedException{
		//int stepFailed = 0, stepPassed = 0;
		boolean skip = false;
		boolean status = false;
		String[] stepFields; String step = "";
		//String url = "";
		
		 //Each Step in a scenario
		 for(int index =0; index<scenario.size(); index++){
			 step = scenario.get(index);
			 
			 if(index == 0){
			 	//title for New scenario.
			 	//Skipping info for new scenario.
				 stepFields = step.split(", ");
				 BasicConfig.currentScenario = stepFields[0].toString();
				 
				 status = skip = (stepFields[1].toString().toLowerCase().contains("y"))? true : false; 
				 Template.writeSceanrioData("<div class=\"titletext\">Skiping : " + ((skip)?"Yes</div>":"No</div>"));
				 
				 if(skip){ 
					 Template.totalskippedtestcase += (scenario.size() - 2);
					 Template.writeSceanrioData("<div class=\"titletext\">Skipping this scenario...</div>");
					 return status;
				 }
				 
			 }
			 else if(index == 1){
			 	//Url Info for this scenario.
				 stepFields = step.split(", ");
				 //Logging
				 Template.writeSceanrioData("<div class=\"titletext\">Description: "+BasicConfig.currentScenario+"</div>");
				 Template.writeSceanrioData("<div class=\"titletext\">"+stepFields[0] + ", " + stepFields[1] + "</div><hr/>");
				 Template.writeSceanrioData("<table class=\"taskResult\">");
				 Template.writeSceanrioData("<tr class=\"tableHead\"> <th>TASK</th><th>TITLE</th><th>ACTION</th><th>STATUS</th><th>TIME(sec.)</th><th>COMMENT</th> </tr>");
				 /*Innvoking URL Address to universal web-driver.*/
				 if(skip == false)ExecutionHandler.invokeWebDriverWithAddress(stepFields[1]);
			 }
			 else{
			 	//Perform further steps execution on the given data above.
				 	 status = ExecutionHandler.executeTask(index, step);
			 }
		 }
		 return status;
	}/*End of function*/
}/*End of class*/
