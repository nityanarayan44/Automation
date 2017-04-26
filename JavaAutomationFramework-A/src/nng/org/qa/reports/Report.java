package nng.org.qa.reports;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @description It produces reports for your executed testcases.
 * 				normally contains the description of testcase and screenshot if that testcase failes.
 * 				you can also modify the body template by overriding the nng.org.qa.reports.Body.java
 * 				and nng.org.qa.reports.Style.java
 *
 */
public class Report {
	
	public static String fileName = "";
	public static PrintWriter logwriter, htmlwriter;
	
	
	/**
	 * @author Ashutosh Mishra
	 * @deprecated
	 * @description instead of this method use initiateLogWriter() method.
	 */
	public static void initiateWriter(){
		
		Report.fileName = "TestReportLog-" + System.currentTimeMillis() + ".txt";
		try {
			logwriter = new PrintWriter(fileName, "utf-8");
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to start print writer. [Report: 30]");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unable to start print writer Encode Error. [Report: 33]");
			e.printStackTrace();
		}
	}
	/**
	 * @author Ashutosh Mishra
	 * @deprecated intead of this, use writeToLogFile.
	 * @param str
	 * @see writeToLogFile(String)
	 */
	public static void writeToFile(String str){
		logwriter.write(str);
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @deprecated
	 * @Description Closing the writer.
	 * @see closeLogWriter()
	 */
	public static void closeWriter(){
		logwriter.close();
	}
	/**
	 * ==================================================================================
	 * NEW Code
	 * ==================================================================================
	 */
	/**
	 * @author Ashutosh Mishra
	 * @description initiate the log writer report.
	 * 
	 */
	public static void initiateLogWriter(){
		
		Report.fileName = "TestReportLog-" + System.currentTimeMillis() + ".txt";
		try {
			logwriter = new PrintWriter(fileName, "utf-8");
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to start print writer. [Report: 30]");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unable to start print writer Encode Error. [Report: 33]");
			e.printStackTrace();
		}
	}
	/**
	 * @param str
	 */
	public static void writeToLogFile(String str){
		logwriter.write(str);
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @Description Closing the writer.
	 * @see closeLogWriter()
	 */
	public static void closeLogWriter(){
		logwriter.close();
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @description initiate the log writer report.
	 * 
	 */
	public static void initiateHtmlWriter(){
		
		Report.fileName = "TestReportLog-" + System.currentTimeMillis() + ".html";
		try {
			htmlwriter = new PrintWriter(fileName, "utf-8");
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to start print writer. [Report: 30]");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unable to start print writer Encode Error. [Report: 33]");
			e.printStackTrace();
		}
	}
	/**
	 * @param str
	 */
	public static void writeToHtmlFile(String str){
		htmlwriter.write(str);
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @Description Closing the writer.
	 * @see closeLogWriter()
	 */
	public static void closeHtmlWriter(){
		htmlwriter.close();
	}
	
	
	/**
	 * @author Ashutosh Mishra
	 * @param stepTitle
	 * @param stepAction
	 * @param stepTime
	 * @param stepStatus
	 * 
	 * @category reporting
	 * @exception
	 * @description This function is used to generate HTML Report based on test.
	 */
	
	public static void writeHtmlFile(String stepTitle, String stepAction, String stepTime, boolean stepStatus){
		
	}
}
