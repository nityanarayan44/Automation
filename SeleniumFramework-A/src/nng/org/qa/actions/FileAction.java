package nng.org.qa.actions;

import java.io.File;
import javax.swing.JOptionPane;

public class FileAction {

				/**
				 * @author Ashutosh Mishra
				 * @version 1.0.0.1
				 * @param file
				 * @return boolean (true/false)
				 * @description Verify the file [path existance and for is a file...]
				 */
				public static boolean checkFileStatus(File file){
					boolean isValid = false;
					if(file.exists() && file.isFile()){
						isValid = true;
					}else{
						isValid = false;
						JOptionPane.showMessageDialog(null, "Problem in this file. \n[Either does not exist or not a file].", "Error In File[nng.org.qa.action Package alert]", JOptionPane.ERROR_MESSAGE);
					}
					return isValid;
				}
}
