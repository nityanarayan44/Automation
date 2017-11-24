package nng.org.qa.configurations;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
/**
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @Basic Flag/Plug Varables
 * @Description All the variables which is related/importent for the whole automation process. 
*/
public class BasicConfig {
	
	/**
	 * To be Depricate:
	 * Vars: URL
	 * Class: ExcelParser, Structure, BuildCases[BuildHandler]
	 */
	public static String URL = "";
	
	
	/*
	 * ============================================================
	 * KeyTerm for the scenario and TASKs defined in Excel sheet.
	 * From where it start making tasksets. 
	 * ============================================================
	 * */
	
	public static final String KEY_SCENARIO = "@scenario";
	public static final String KEY_TASKS 	= "tasks";
	
	/* 
	 * =========================================
	 * DO NOT TOUCH THESE Settings
	 * =========================================
	 * */
	
	public static String testTitle 			= "Automation Test 1";
	public static String currentScenario 	= "";
	public static boolean currentStepStatus = false;
	public static String currentStepComment = "";
	public static Object actionObject 		= null;
	public static WebDriver webdriver;
	public static HashMap <Integer, ArrayList<String>> taskMap = new HashMap<Integer, ArrayList<String>>();
	//FOR Reporting
	public static JSONObject rawJson 		= null;
	public static JSONArray jsonData		= null;
	public static String logString			= "";
	
}
