package nng.org.qa.reports;

//import nng.org.qa.configurations.BasicConfig;

/**
 * 
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @Description It contains the template body for report which to be produced after all allocated test scenario executed.
 */
public class Template {
	
	private static String stepData;
	/*
	 * ============================================
	 * Variables for Report
	 * ============================================
	 */
	
	public static String innerHTML = "";
	public static int totalscenario = 0;
	public static int totaltestcase = 0;
	public static int totalskippedtestcase = 0;
	public static int passedtestcases = 0;
	public static double totaltimetaken = 0;
	public static int starttime = 0, endtime = 0;
	/*
	 * ==========================================
	 * Change/Edit here if you want.
	 * ==========================================
	 * */
	public static String importHeadLibrary = "<script src='https://code.highcharts.com/highcharts.js'></script>"
											+"<script src='https://code.highcharts.com/modules/exporting.js'></script>";
	
	public static String timeLineChart		= "<div id='timeLine' style='min-width: 310px; height: 400px; margin: 0 auto'></div>";
	public static String failureChart		= "<div id='passfail' style='min-width: 310px; height: 400px; margin: 0 auto'></div>";
	public static String extra	= "";
	
	public static String upper 		= "<html>"
									+ "<head><title> Report </title></head>"
									+ "<body><header><center>"
									+ "<div class=\"card\">"
									+ "<p>Report</p>"
									+ "</div></center></header>"
									+ "<div class=\"blank\"></div>"		/* For adjustment [must be blank]*/
									+ "<div id=\"test-summary\"></div>" /* Basic overview based on data */
									+ "<div id=\"test-graphs\"></div>"  /* Graphs for test based on data*/
									+ "<center>"
									+ "<div class=\"docs\">";			/* Rest of the report history will be here */
	
	public static String lower		= "</div></center></body>"
									+ Style.style
									+ "</html>";
	
	
	/*
	 * ==========================================
	 * Don't Touch this
	 * ==========================================
	 * */
	public static String mainStructure 	= "";
	
	/*
	 * ================================================================================================
	 * Template Simple Functions
	 * ================================================================================================
	 */
	
	/**
	 * @author Ashutosh Mishra
	 * @param scenarioIndex
	 */
	public static void startScenario(String scenarioIndex){
		String data = "";
		data += "<br/><div class=\"scenario\">";
		data += "<div class=\"titletext\">[Executing Scenario: "+ (Integer.parseInt(scenarioIndex)+1) +"]</div>";
		Report.writeToHtmlFile(data);
	}
	/**
	 * @author Ashutosh Mishra
	 * @param data
	 */
	public static void writeSceanrioData(String data){
		Report.writeToHtmlFile(data);
	}
	
	public static void endScenario(){
		Report.writeToHtmlFile("</table></br>");
		Report.writeToHtmlFile("</div><br/>");
	}
	/**
	 * @author Ashutosh Mishra
	 * @param desc
	 * @param timetaken
	 * @param status
	 * @param reason
	 * @description make testcase section in report template for given data.
	 */
	public static void createTCase(int index, String title, String action, long timetaken, boolean status, String reason){
		stepData="<tr>"
				+"<td>[Task:"+(index-1)+"]</td>"
				+"<td>"+title+"</td>"
				+"<td>"+action+"</td>"
				+"<td>"+((status)?"<span style=\"color:green;\">PASS</span>":"<span style=\"color:red;\">FAIL</span>")+"</td>"
				+"<td>"+ (double)((double)timetaken/1000.00) + "</td>" 
				+"<td>"+reason+"</td>"
				+"</tr>";
		
		//Finally writting to output report file....
		Report.writeToHtmlFile(stepData);
	}
	
	/*
	 * =================================================
	 * Functions to write JAVAScript to report file
	 * =================================================
	 */
	public static void createSummary(){
		stepData = "<script>"
				+ "document.getElementById('test-summary').innerHTML = '"
				+ "<div class=\"scenario titletext\"><b> "
				+ "<h6>OVERVIEW</h6><hr>"
				+ "<p>Total Scenario : "+ Template.totalscenario +"</p>"
				+ "<p>Total TestCase : "+ Template.totaltestcase +"</p>" 
				+ "<p>PassedTestCase : "+ Template.passedtestcases +"</p>" 
				+ "<p>FailedTestCase : "+ (Template.totaltestcase - (Template.passedtestcases + Template.totalskippedtestcase)) +"</p>" 
				+ "<p>Skipped TCases : "+ Template.totalskippedtestcase +"</p>"
				+ "<p>TotalTimeTaken : "+ Template.totaltimetaken +"</p>'"
				+ "</script>";
		Template.writeSceanrioData(stepData);
	}
	
	public static void createGraph(){
		
	}
}
