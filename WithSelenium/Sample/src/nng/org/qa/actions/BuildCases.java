package nng.org.qa.actions;

import nng.org.qa.configurations.BasicConfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * 
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @category trying to build multiple scenario based testing [One scenario may have multiple testcases.]
 */
public class BuildCases {

	//Static objects.
	/*
	 * =========================================
	 * Static Object used for File.
	 * =========================================
	 */
	public static boolean isTasksFound = false;
	public static FileInputStream filein = null;
	public static HSSFWorkbook workbook = null;
	public static HSSFSheet spreadsheet = null;
	public static HSSFRow row;
    public static boolean nextStatus = true;
    public static Object actionObject = null;
    
    //Tasks Variables.
    public static ArrayList <String> tasks = new ArrayList<String>();
   
    /*
     *=================================================================== 
     */
	public static void readScenario(){
		
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param list
	 * @return void
	 * @doc Build Scenario-wise TestCases in HashMap <Integer, ArrayList<String>>.
	 */
	public static boolean buildScenariowiseTestCases( ArrayList<String> list){
			try{	
				//System.out.println("Now building the scenariowise tasks...");
				int index = 0;
				ArrayList<String> steps = new ArrayList<String>();
				for(int i =0; i< list.size(); i++){
					//For Step collection.
					if( ((list.get(i).toString().toLowerCase()).contains(BasicConfig.KEY_SCENARIO)) && i !=0 && steps.isEmpty() == false ){
						//System.out.println(">>> Inserting Steps for Scenario: "+ (index+1) );
						BasicConfig.taskMap.put(index, steps);
						index++;	/* Increase the Scenario */
						steps = new ArrayList<String>(); /* Creating new Object for fresh steps*/
						steps.add(list.get(i).toString()); /* Adding Scenario Description [Only from first cell.]*/
						continue;
					}
					//Adding Steps
					if( !(list.get(i).toString().isEmpty()) ){
						steps.add(list.get(i).toString());
					}
					//System.out.println(">>>\tNext Task ...");
				}
				BasicConfig.taskMap.put(index, steps); /*adding last scenario steps*/
			
			}catch(Exception err){
				err.printStackTrace();
				return false;
			}
		
//			System.out.println("=[OUTPUT TEST-SCRIPT]===============================");
//			//All Scenario accessed and built successfully.
//			for(int i=0; i<BasicConfig.taskMap.size(); i++){
//				System.out.println(BasicConfig.taskMap.get(i).toString());
//			}
		
		//Returing all okey[Task build status].
		return true;
		
	}
	
	@SuppressWarnings("deprecation")
	public static boolean readFileTasks(File file){
		boolean isSuccess = false;
		System.out.println("Executing now.............");
		//Starting
		try{
			
			filein = new FileInputStream(file);
			workbook = new HSSFWorkbook(filein);
			spreadsheet = workbook.getSheetAt(0);
			Iterator < Row > rowIterator = spreadsheet.iterator();
			String value = "";
			
			//System.out.println("Starting row for iteration..");
			while (rowIterator.hasNext()) {
				row = (HSSFRow) rowIterator.next();
				Iterator < Cell > cellIterator = row.cellIterator();
				value = "";
				//System.out.println("Starting cell for iteration in a row");
				while ( cellIterator.hasNext() && ExcelParser.nextStatus) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:value += String.valueOf(cell.getNumericCellValue()) + ", ";break;
						case Cell.CELL_TYPE_STRING:	value += cell.getStringCellValue() + ", ";break;
					}/*End of Switch*/
					
					//Finnding Keyword for basic Properties.
						if(value.contains("URL") && isTasksFound == false){
							//do nothing.
						}else if(value.contains("TESTNAME") && isTasksFound == false){
							//do nothing.
						}else if(value.toLowerCase().contains(BasicConfig.KEY_TASKS) && isTasksFound == false){
							isTasksFound = true;
							value="";
							continue;
						}
					
				}//End of while.{row iteration ends.}
				//Inserting all row into taskset[tasks].
				if(isTasksFound){
					//System.out.println(">>> " + value);
					tasks.add(value);
					value = "";
				}
			}//End of While.{Sheet complete.}
			
			/*
			 * ======================================
			 * TASKs READING FROM SHEET IS DONE NOW
			 * ======================================
			 */
			isSuccess = buildScenariowiseTestCases(tasks);
		}catch(Exception err){
			//TODO:
			System.out.println("Error.");
			err.printStackTrace();
			isSuccess = false;
		}
		
		return isSuccess;
	}
	
	
	
	//
}/*End of Class*/
