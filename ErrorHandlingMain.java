public class ErrorHandlingMain implements ErrorHandling {
	
	/**
	 * Referrs the user to the help menu and exits
	 */
	public void error(String msg, int status) 
	{
		System.out.println(msg);
		System.exit(status);
	}
	
	/**
	 * Prints a warning message to the console
	 */	
	public void warn(String msg) 
	{
		System.out.println(msg);
	}
}