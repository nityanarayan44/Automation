package nng.org.qa.reports;
import org.json.*;
/**
 * @version 1.0.0.1
 * @author Ashutosh Mishra
 * @category JSON Report Builder
 * @description It build json file as raw report which may be further used by another framwork to produce final testing report.
 */
public class JSONBuilder {

	public static JSONObject scenario 		= new JSONObject();
	public static JSONArray  scenarioSteps 	= new JSONArray();
	public static JSONObject data 			= new JSONObject();
	/**
	 * @author Ashutosh Mishra
	 * @param field
	 * @return
	 */
	public static boolean addJsonArray(JSONArray field){
		//TODO:
		return true;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param field
	 * @return
	 */
	public static boolean addJsonObject(JSONObject field){
		//TODO:
		return true;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * 
	 * @param key
	 * @param value
	 */
	public static void addJsonData(String key, String value){
		try{
			JSONBuilder.data.append(key, value);
		}catch(JSONException err){
			
		}
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @category Raw Reporting
	 * 
	 * @param stepTitle
	 * @param stepAction
	 * @param stepTime
	 * @param stepStatus
	 * 
	 * @description it is used to write a raw json file for further reporting framework use.
	 */
	public static void writeTestStep(String stepTitle, String stepAction, String stepTime, boolean stepStatus){
		
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @category Raw Reporting
	 * 
	 * @param scenarioTitle
	 * @param sceanrioSkipStatus
	 * @param scenarioTime
	 * @param sceanrioUrl
	 */
	public static void writeTestScenario(String scenarioTitle, String sceanrioSkipStatus, String scenarioTime, String sceanrioUrl){
		
	}
}
