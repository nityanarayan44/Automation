package nng.org.qa.reports;

/**
 * @author Ashutosh Mishra
 * @version 1.0.0.1
 * @Description It contains the style script for the report template.
 * 				you can also override this style as you want, or simply use this
 * 				style which is already writen.
 */ 

public class Style {

	public static String style 	= "<style>"
								+ "		body{ background-color: none; color: black; font-family: calibri, roboto, consolas;}"
								+ "	    .card{margin-bottom:50px; position:fixed; width:100%; margin-top:-30px;margin-left:-8px;margin-right:-8px;font-size:2em; color:darkred; background-color:darkcyan; font-weight:bold; border-style:none; box-shadow: 0 0 3px 1px gray;}"
								+ "		input[type=\"text\"]{} "
								+ "		.docs{ position: inherit;}"
								+ "		.scenario{ margin-top:10px; padding:5px; width:90%; border-radius:3px; border-width:1px; border-style:solid; box-shadow:0 0 3px 2px gray;}"
								+ "		.blank{height:50px; padding: 10px;}"
								+ "		.taskResult{border-style:solid; border-width:1px; width:80%; border:0; cellpadding: 10px; cellspacing:0px;}"
								+ "		.tableHead{background-color: lightgray;}"
								+ "		.titletext{text-align: initial;}"
								+ "</style>";
}
