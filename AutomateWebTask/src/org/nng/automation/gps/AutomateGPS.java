package org.nng.automation.gps;

import java.util.HashMap;
import java.util.List;

import org.nng.automation.utils.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//@SuppressWarnings("unused")
class AutomateGPS {

	
	/*
	 * ================================================================================
	 * --- [Global Vars] ------------
	 * ================================================================================
	 */
		private WebDriver webdriver = null;
		private Action act = new Action();
		private HashMap<String, String> configuration = null;
		private String[] keys = null;
		
		private String btn_login		= ".//*[@id='btnLogin']";
		private String btn_updateStatus = ".//*[@id='btnUpdate']";
		private String btn_addGoals 	= ".//input[@value='Add Goal']";
		
		private String field_GoalTextBox= ".//*[@id='ucAddGoal_txtAddGoal']";
		private String field_userID 	= ".//*[@id='txtName']";
		private String field_userPWD	= ".//*[@id='txtPassword']";
		
		private String all_GoalsList 	= ".//*[@id='dgGoals']/tbody/tr";
		private String all_GoalsChkBox 	= ".//td[@class='dgRowStyle'][1]//input[@type='checkbox']";
	/*
	 * ================================================================================
	 * --- [Constructor] ------------
	 * ================================================================================
	 */
		public AutomateGPS(WebDriver wdriver, HashMap<String, String> config, String[] k) throws Exception {
			//__Initialize the vars.
				this.webdriver 		= wdriver;
				this.configuration 	= config;
				this.keys 			= k;
			
			//__Start the step execution
				this.steps();
		}
	
	/*
	 * ================================================================================
	 * --- [Step: Function] ------------
	 * ================================================================================
	 */
	
		private void steps() throws Exception {
			try {
				// Open Jenkins
					System.out.println("Opening..." + configuration.get("GPS_URL") );
					webdriver.get( configuration.get("GPS_URL") );
					
				// Wait for few minutes
					System.out.println("Goals: " + configuration.get("GPS_GOALS"));
					System.out.println("Waiting for 5 sec...");
					Thread.sleep(5000);
					
				//Login
					act.setElementValue(webdriver, "xpath", this.field_userID, configuration.get("GPS_USER_ID"));
					act.setElementValue(webdriver, "xpath", this.field_userPWD, configuration.get("GPS_USER_PWD"));
					act.doClick(webdriver, "xpath", this.btn_login);
				
				//Check the goal,and fill the goal accordingly
					int countOfGoals=(webdriver.findElements(By.xpath(this.all_GoalsList)).size()-1);
					// set goals accordingly
					if( countOfGoals == 0){
						// If, there is no goal,
						// or less than 5 goals 
						// this day will be marked as Not-Working,
						// so keep adding the goals.
						System.out.println("Adding goals..." + configuration.get("GPS_GOALS").toString());
						act.setElementValue(webdriver, "xpath", this.field_GoalTextBox, this.addGoals(configuration.get("GPS_GOALS")));
						act.doClick(webdriver, "xpath", this.btn_addGoals);
					}
					else if( countOfGoals > 0 &&  countOfGoals < 5) {
						System.out.println("Adding goals..." + this.addGoals(configuration.get("GPS_GOALS").toString()));
						act.setElementValue(webdriver, "xpath", this.field_GoalTextBox, this.addGoals(configuration.get("GPS_GOALS").toString()));
						act.doClick(webdriver, "xpath", this.btn_addGoals);	
					}
					else {
						// If there are already five goals avaialbe at this moment,
						// then update one of them.
						List<WebElement> goalChecks = webdriver.findElements(By.xpath(this.all_GoalsChkBox));
						for(WebElement ele : goalChecks) {
							if(!ele.isSelected()) ele.click();
							break;
						}
						
						//Update the status
						act.doClick(webdriver, "xpath", this.btn_updateStatus);
					}
			}catch(Exception e) {
				//error
				System.out.println("There was an Error. Closing the automation now.");
				e.printStackTrace();
				//Close and quit.
					webdriver.quit();
			}		
			
			//Close and quit.
				if(webdriver != null) {
					webdriver.quit();
				}
		}
		
		// Add the goal lines
			public String addGoals(String goals) {
				String aGoals = "";
				return goals.replace(",",  Keys.chord(Keys.SHIFT, Keys.ENTER));
			}
	
}
