import java.lang.reflect.Array;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Stack;
//import ErrorHandlingMain;
/**
 * This is the main for ThisSongSucksApp
 * 
 * Call by: java ThisSongSucks.java --<option>
 * 
 * call 'java ThisSongSucks.java --help' for help
 * 
 * CSV Files are located at Users/<USER>/Music/_Serato_/History Export/
 * 
 * @author NMots
 * 
 */


public class ThisSongSucks {
	
	// Global variables
	final static String HELP = "help";
	final static String ABOUT = "about";
	final static String PREFRENCES = "prefrences";
	final static String TRACK_ADD = "trackadd";
	final static String TRACK_ADD_ABV = "ta";
	final static String TRACK_REMOVE = "trackremove";
	final static String TRACK_REMOVE_ABV = "tr";
	final static String RUN_REVIEW = "runreview";
	final static String RUN_REVIEW_ABV = "rr";
	final static String NL = "\n";

		
	public static void main (String[] args)
	{
		
		try 
		{
			// Check to make sure we have arguments
			if(args.length < 1)
			{
				callHelp();
			}
			
			// Backwards load stack of parameters, then pop the first one
			Stack<String> paramStack = new Stack<String>();
			for(int i = (args.length-1); i >= 0; i--)
			{
				paramStack.push(args[i]);
			}
			String initialParameter = paramStack.pop();
			System.out.println(initialParameter);
			
			// Begin our check for correct parameter 
			if(initialParameter.equals(ABOUT))
			{
				callAbout();
			}
			else if(initialParameter.equals(PREFRENCES))
			{
				callPrefrences();
			}
			else if(initialParameter.equals(TRACK_ADD) || initialParameter.equals(TRACK_ADD_ABV))
			{
				instantiateDatabase();
				callTrackAdd();
			}
			else if(initialParameter.equals(TRACK_REMOVE) || initialParameter.equals(TRACK_REMOVE_ABV))
			{
				instantiateDatabase();
				callTrackRemove();
			}
			else if(initialParameter.equals(RUN_REVIEW) || initialParameter.equals(RUN_REVIEW_ABV))
			{
				instantiateDatabase();
				callRunReview();
			}
			else if(initialParameter.equals(HELP))
			{
				callHelp();
			}
			else
			{
				callHelp();
			}
		
		} catch (Exception e) {
			// For now just print the exception message 
			System.out.println("An exception was caught in the main: " + e.getMessage());
		}
			
	}
	
	/**
	 * instantiateDatabase 
	 * Any method call that will need to access 
	 * the database, we want to make sure a database
	 * exists and that the tables are present
	 * 
	 * @throws an exception if anything goes wrong in DB creation. 
	 */
	static void instantiateDatabase()
	{
		DatabaseBuilder dbBuilder = new DatabaseBuilder();
		
		// Check if our tables exist, throw an exception if we have any issue
		try 
		{
			dbBuilder.createTables();
		}
		catch (Exception e)
		{
			// For now just print out error
			System.out.println("Exception caught trying to instantiate the database: " + e.getMessage());
		}
	}
	
	/**
	 * About
	 * 
	 * Generates a list of commands and how they should be used.
	 */
	static void callAbout()
	{
		String message = 
				"--- This Song Sucks ---" + NL
				+ "Written by Nathaniel Mots & Harriet Willmott" + NL
				+ NL
				+ "Execute the application by running 'java -jar ThisSongSucks.jar <OPTION>'" + NL
				+ NL
				+ "Option		- Action" + NL
				+ "about		- Prints this message" + NL
				+ "prefrences	- Prints prefrences and allows you to change any prefrences you want to alter" + NL
				+ "trackadd ta	- Searches the normal Serato root for new CSV Files (The normal route is " + NL
				+ "				  'Users/<USER>/Music/_Serato_/History Export/' Change this route in prefrences)" + NL
				+ "runreview rr	- Forces user to review all tracks that don't have a user review already" + NL
				+ "help			- Prints help menu" + NL
				;
		//XXX We need options here to actually go and query the results once user have entered data 
		System.out.println(message);
	}
	
	/**
	 * 
	 */
	static void callPrefrences()
	{
		System.out.println(PREFRENCES);
	}
	
	/**
	 * 
	 */
	static void callTrackAdd()
	{
		System.out.println(TRACK_ADD);
	}
	
	/**
	 * 
	 */
	static void callTrackRemove()
	{
		System.out.println(TRACK_REMOVE);
	}
	
	/**
	 * 
	 */
	static void callRunReview()
	{
		System.out.println(RUN_REVIEW);
	}
	
	/**
	 * 
	 */
	static void callHelp()
	{
		System.out.println(HELP);
		System.exit(0);
	}
}
