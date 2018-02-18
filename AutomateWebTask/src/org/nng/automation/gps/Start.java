package org.nng.automation.gps;
import java.awt.Choice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class Start {
	
	//Public variable
	//=========================
	public static WebDriver webdriver = null;
	
	public static void main(String[] args) {
		String fileLocation = "";
		try {
			// Find the configuration file.
				if(args.length == 0) {
					//Default location is where this class exist.
					fileLocation = "./AppConfig.nng";
					//fileLocation = "E:\\MY-WORKPLACE\\AutomateThis\\AppConfig.nng";
				}else {
					System.out.println("Using from CLI args...");
					String fileLoc = args[0];
				}
			
			//1>>> Load the Configuration File.
				Config run = new Config(new File(fileLocation));
				
			//2>>> Initiate driver
				webdriver = run.getDriver();
				
			//3>>> Run the steps
				new AutomateGPS(webdriver, run.getConfig(), run.getKeys());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} /* End of Class */
