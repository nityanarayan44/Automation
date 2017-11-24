/**
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @date 18 Nov 2016
 * 
 */
import java.io.File;
import javax.swing.JOptionPane;
import nng.org.qa.actions.*;
import nng.org.qa.reports.Report;

public class Initializer {

	/**
	 * @author Ashutosh Mishra
	 * @version 1.0.0.1
	 * @param args
	 * @throws InterruptedException 
	 */
	//@SuppressWarnings("restriction")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		File file = new File("e:\\DUMP\\Test3.xls");
		
		//Sending Test Script file
		Handler.handleFile(file);
		
		//Ends.
		System.out.println("\n\nExecution Ends");
		
		JOptionPane.showMessageDialog(null, "Test Script Executed.\n\n Report Generated as '"+Report.fileName+"'", "Execution Finished", JOptionPane.INFORMATION_MESSAGE);
		
		//System.out.println("Test Log Report Generated,\nNamed: " + Report.fileName);		
		
	}

}
