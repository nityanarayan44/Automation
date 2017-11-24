package nng.org.qa.actions;

public class Structures {

	public static enum LocatorType{
		XPATH,
		ID,
		NAME,
		CLASS,
		CSSSELECTOR,
		
		/*In special Case, when we need to access the windows property like: title.*/
		WINDOW
	}
}
