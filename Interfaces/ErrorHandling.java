
public interface ErrorHandling {
	
	/**
	 * Prints a message to the console and exits the system
	 * 
	 * @String msg Message to print out to the user of what went wrong 
	 * @int status Error status to exit on
	 */
	public void error(String msg, int status);

	/**
	 * Prints a warning message to the console 
	 * 
	 * @String msg Warning message for the user
	 */	
	public void warn(String msg);

}
