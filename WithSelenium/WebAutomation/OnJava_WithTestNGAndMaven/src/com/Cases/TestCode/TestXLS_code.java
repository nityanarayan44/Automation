/*This is to test and use read and write fundtion from XLS.
 *  this code is designed to use XLS file kept under TestDataXLS package
 * 
 * */

package com.Cases.TestCode;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Utills.GetBrowserInstance;
import com.Utills.Keywords;
import com.Utills.ReadWrite_Xls;
import com.test.Initialisers.Constants;

public class TestXLS_code {
	

	String ExcelFilePath = System.getProperty("user.dir") + "\\src\\com\\test\\xlsSheets\\PearReview.xls"; 
	//String ExcelFilePath = "C:\\Users\\Ishan Kumar\\Desktop\\PearReview2.xlsx";
	
	ReadWrite_Xls rw = new ReadWrite_Xls(ExcelFilePath);
	@Test
	public void test1(){
		
		System.out.println(rw.isSheetExist("PeerReview"));
		System.out.println(rw.getRowCount("PeerReview"));
		//System.out.println(rw.getCellData("PeerReview", rowNum, colNum);
		
		//to Test get a data from specific cell and print in another sheet
		int rowNum = rw.getRowCount("PeerReview");
		for(int i=0;i<rowNum;i++){
			//print column value in console
			System.out.println(rw.getCellData("PeerReview", i, 0));

			//Copy all the values in another sheet:
			rw.setCellData("Sheet3", "Project Name:", i, rw.getCellData("PeerReview", i, 0));
		}
		
		//get a list of data from particular column
		System.out.println("/n ---->");
		System.out.println(rw.getColumnData("PeerReview", "Name of the project"));
		
		
		System.out.println("/n ##########");
		
		//print sheet in console
		rw.printSheet("PeerReview");
		
		//print all the values in another sheet:
		//rw.setCellData("Sheet3", "Project Name:", 1, status);
		
		
	}
	
	
	
	
	

}
