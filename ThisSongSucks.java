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
		
	public static void main (String[] args)
	{
		
		try {
			// Backwards load stack of parameters, then pop the first one
			Stack<String> paramStack = new Stack<String>();
			for(int i = (args.length-1); i >= 0; i--)
			{
				paramStack.push(args[i]);
			}
			String initialParameter = paramStack.pop();
			

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
				callTrackAdd();
			}
			else if(initialParameter.equals(TRACK_REMOVE) || initialParameter.equals(TRACK_REMOVE_ABV))
			{
				callTrackRemove();
			}
			else if(initialParameter.equals(RUN_REVIEW) || initialParameter.equals(RUN_REVIEW_ABV))
			{
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

		}
			
	}
	
	/**
	 * 
	 */
	static void callAbout()
	{
		System.out.println(ABOUT);
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
	}
}
