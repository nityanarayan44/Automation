package nng.org.qa.actions;

import java.io.File;
import nng.org.qa.configurations.BasicConfig;
import nng.org.qa.reports.Report;
import nng.org.qa.reports.Template;

/**
 * 
 * @author Ashutosh Mishra
 * @Description File execution starts from here.
 * 				all the flow of the execution can be controlled from here.
 * 
 */
public class Handler {
	
	//Getting scenario.
	public static boolean executeTest() throws InterruptedException{
		boolean next = false;
		
		//Going through all scenario.
		for(int i=0; i<BasicConfig.taskMap.size(); i++){
			//Getting all testcases inside of a scenario.
			Template.totaltestcase += (BasicConfig.taskMap.get(i).size() - 2);
			System.out.println("[Scenario: "+i+"] Total TestCases:" + BasicConfig.taskMap.get(i).size());

			Template.startScenario(i+"");
			next = ExecutionHandler.executeScenario(BasicConfig.taskMap.get(i));
			Template.endScenario();
		}
		return next;
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws InterruptedException 
	 * @Description perform file check then forword this file to process further.
	 */
	public static boolean handleFile(File file) throws InterruptedException{
			boolean next = false;
			
			//0: Recording start time.
				long t = System.currentTimeMillis();
			
			//1: File Validation.
				next = (FileAction.checkFileStatus(file)) ? true : false;
				
			//2: Parse the file and Build Cases/Tasks
				if(next){ next = BuildCases.readFileTasks(file); }else{ next = false; /*Some Mesage if needed.*/}
				
			//3: Initiating writer object to write to a html file.
				Report.initiateHtmlWriter();
				Report.writeToHtmlFile(Template.upper);
				
			//4: Applying Actions Over the Tasks/Scenario.
				next = Handler.executeTest();
			
			//5: Counting [Total scenario, Time]
				Template.totalscenario  = BasicConfig.taskMap.size();
				Template.totaltimetaken = ((double)System.currentTimeMillis() - t)/(double)1000;
				
			//6: writting overview data for the test.
				Template.createSummary();
				
			//6: writting another bottom html5 code from template.
				Report.writeToHtmlFile(Template.lower);
				
			//7: Closing print writer
				Report.closeHtmlWriter();
				
			//@Last: Return the overall status
				return next;
	}
}
