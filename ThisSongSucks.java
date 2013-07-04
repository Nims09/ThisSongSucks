import java.lang.reflect.Array;

/**
 * This is the main for ThisSongSucksApp
 * 
 * Call by: java ThisSongSucks.java --<option>
 * 
 * call 'java ThisSongSucks.java --help' for help
 * 
 * @author NMots
 * 
 */


public class ThisSongSucks {
	
	final String ABOUT = "about";
	final String PREFRENCES = "prefrences";
	final String TRACK_ADD = "trackadd";
	final String TRACK_ADD_ABV = "ta";
	final String TRACK_REMOVE = "trackremove";
	final String TRACK_REMOVE_ABV = "tr";
	final String RUN_REVIEW = "runreview";
	final String RUN_REVIEW_ABV = "rr";
	
	final int OPTIONS_SIZE = 6;
	//Best form of a table ?? 
	//final HashMap() PARAM_OPTIONS = new HashMap();
	
	
	
	public static void main (String[] args) {
		// Parse command line 
		for (String a: args) {
      	  System.out.println(a);
		}
	}
}
