import java.sql.Connection;

public class DBWorker 
{
	// Add globals
	protected Connection connection;
	
	/**
	 * Constructor
	 */
	public DBWorker (Connection connection)
	{
		this.connection = connection; 
	}
	
	/**
	 * Checks to see if a table exists in the database
	 * 
	 * @param tableName the name of the table we're checking for
	 * @return true to the table exists, false otherwise
	 */
	public boolean checkTableExists(String tableName)
	{
		
		return false;
	}
}
