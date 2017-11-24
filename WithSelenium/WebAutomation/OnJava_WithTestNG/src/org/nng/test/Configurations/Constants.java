/**
 * @author Ashutosh Mishra [@github: nityanarayan44]
 * @Created March 2017
 * @LastModified 24 Nov 2017
 * @project Sample Web Automation Framework
 * @desc this class holds all the application constants
 */

package org.nng.test.Configurations;

import org.nng.utils.DateAndTime;

public class Constants {

	//----------- ScreenShot ---------
		public static final String screenShotPath	= "screenshots\\" + ((new DateAndTime()).getCurrentDateAsD_M_Y()) + "\\";

	//----------- Browser ------------
		public static final String browserName	= "CHROME"; // CHROME / FIREFOX / EDGE / IE 

	//----------- WebDriver ----------
		public static final String driverPath		= "C:\\DRIVERS\\chromedriver_win32_new\\chromedriver.exe";
		
	//----------- DataFiles ----------
		public static final String dataFile = "src\\org\\nng\\test\\dataFiles\\TestData.xlsx";
		
	//----------- TestOutput ---------
		public static final String testOutput = "test-output\\";
		

}
