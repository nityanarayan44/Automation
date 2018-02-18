package org.nng.automation.gps;
import java.awt.Choice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.nng.automation.utils.*;
import org.nng.automation.utils.Driver;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
class Config {
	
	/*
	 * ================================================================================
	 * --- [Global vars] ------------
	 * ================================================================================
	 */
		private HashMap<String, String> config = null;
		private String[] keys = {
							"BROWSER_TYPE", 
							"DRIVER_PATH",
							"GPS_URL",
							"GPS_USER_ID",
							"GPS_USER_PWD",
							"GPS_GOALS",
							"JENKINS_SERVER_PATH", 
							"JENKINS_SERVER_USER", 
							"JENKINS_SERVER_PASS", 
							"JOB_NAME"
							};
	
	/*
	 * ================================================================================
	 * --- [ Constructor ] ------------
	 * ================================================================================
	 */
		public Config(File configFile) throws Exception {
			// Intialize the config
				this.config 	= new HashMap<String, String>();
			// check the config file
				if (configFile.exists()) {
					if(this.validateFileExtension(configFile))
						this.readConfigFile(configFile);
					else
						throw throwException("Problem with file. Either it is currupt or extension is not '.nng'");
				}else {
					javax.swing.JOptionPane.showMessageDialog(null, "Oopse, File does not Exist", "Error", JOptionPane.ERROR_MESSAGE);
					throw throwException("File does not Exist");
				}
				
		}
	/*
	 * ================================================================================
	 * --- [ Functions ] ------------
	 * ================================================================================
	 */
		public void readConfigFile(File fileObj) throws Exception {
			System.out.println("Reading ....");
			// Vars
				BufferedReader br = null;
				FileReader fr = null;
				String sCurrentLine = "";
				
			//Initiating file reader and buffer reader.
				fr = new FileReader(fileObj);
				br = new BufferedReader(fr);
				
			//Reading file now, line by line.
				while ((sCurrentLine = br.readLine()) != null) {
					//trim all the gaps and tabs
						String line = sCurrentLine.replaceAll("[\t]+", "");
					//split the line, if it contains '='
						if( line.contains("=")) {
							System.out.println(line);
							String setting[] = line.split("=");
							if ( this.isExistInOption(setting[0]) ) {
								this.config.put(setting[0], setting[1]);
							}
						}else {
							// Do not process this line
						}
				}
			
			//Close the stream now.
				if (br != null) br.close();
				if (fr != null) fr.close();
				
			// Print the configuration
				this.printSettings();
		}
	
		private boolean isFileNull(File file) {
			return (file.equals(null)) ? true : false ;
		}
		private boolean validateFileExtension(File file) {
			return (file.getName().endsWith("nng")) ? true : false ;
		}
		private Exception throwException (String exceptionMsg) {
			return new IllegalArgumentException(exceptionMsg);
		}
		
		
		private boolean isExistInOption (String keyStr) {
			for (String option : this.keys) {
				if ((option.toUpperCase()).contains(keyStr.toUpperCase()) ) { return true; }
		    }
			return false;
		}
	//------------------------
	// Initiate driver
	
	public WebDriver getDriver() throws Exception {
		return (new Driver()).getWebDriver(this.config.get(keys[0]), this.config.get(keys[1]), (new Driver()).getdefaultChromeOptionWithIncognito());
	}
	public HashMap<String, String> getConfig(){
		return this.config;
	}
	public String[] getKeys(){
		return this.keys;
	}
	public void printSettings() {
		System.out.println("Printing Configs >>> ");
		for(String s : this.config.keySet()) {
			System.out.printf("%25s \t %s\n", s, this.config.get(s));
		}
	}
} /* End of Class */
