//this class holds all the application constants
package com.test.Initialisers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constants {

	//-----------BUILD GENERATOR---------
	static Calendar c = Calendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy.HHmmss");
	static String buildNum = sdf.format(c.getTime());


	//-----------Browser------------
	public static final String browser = "Chrome"; // Chrome / Firefox / Edge 

	//-------IntegrationConstants---------
	
	public static final String sitemon_Monitor = "WNKLIUMULSER";  //Prod Sup
	//public static final String sitemon_Monitor = "QIKBTKQXEWMU";	// BAT
	
	public static final String build = buildNum;
	public static String release = "verification-3.7";
	//public static String release = "verification-1.4";
	
	public static final String vansahAgentName = "VMH17741";
	public static String environment = "PROD-SUP";
	public static String vansahPackage = "9";
	public static String log_Bit = "1";

	
	//------------ Application - Defaults ----------
	//bat URL = https://bestmedbat.azurewebsites.net/Account/Login
	//Prod Sup = https://bestmedprodsup.azurewebsites.net
	
	
	/*
	 * Remember to change the monitor code and environment
	 * above whenever you change the URL
	 */
	public static String application_URL = "https://bestmedprodsup.azurewebsites.net";
	
	// Registered Nurse Login
	public static String USER_NAME_RN = "testpointFRN";
	public static String PASSWORD_RN = "Password#123";
	
	// Facility Manager Login
	public static String USER_NAME_FM = "testpointFM";
	public static String PASSWORD_FM = "Password#123";
	
	//PharmacyManager
	public static String USER_NAME_PHM = "TestpointPHM";
	public static String PASSWORD_PHM = "Password#123";
	
	// Assistance in Nursing AIN
	public static String USER_NAME_AIN = "testpointFAIN";
	public static String PASSWORD_AIN = "Password#123";
	
	/*
	 * =============================================================
	 * These users are used to manipulate the data within it.
	 * Like: Status, Password, PIN, etc.
	 * =============================================================
	 */
	public static String USER_NAME_RND_1 	= "testpointfrn3";
	public static String PASSWORD_RND_1 	= "Password#123";
	public static String USER_NAME_RND_2 	= "testpointFRN4";
	public static String PASSWORD_RND_2 	= "Password#123";
	
	// Pin for the Test cases 
	public static String RN_PIN = "452769";
	public static String AIN_PIN = "689107";
	
	public static String RN_PIN2_FromSameFacility = "351515";
	public static String AIN_PIN2_FromSameFacility = "206744";
	
	public static String RN_PIN_FromDifferentFacility = "637440";
	public static String AIN_PIN_FromDifferentFacility = "000748";
	
	//if agency deleted this pin have to be recreated
	//public static String Agency_RNPin = "555235";
	//public static String Agency_AINPin = "555235";
	public static String Agency_RNPin = "526217";
	public static String Agency_AINPin = "526217";
	
	
	//--------- Section ---------
	//Use this section to perform system verification
	public static String sectionName = "EAST - EAST";
	
	//Use this section to perform administration
	public static String sectionName2 = "WEST - WEST";
	
	
	// Excel file for Test data
	public static String excelFileForNewUserData = "src\\com\\test\\TestDataXLS\\BHS_testData.xlsx";
	





}
