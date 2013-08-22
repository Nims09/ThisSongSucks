import java.sql.*;

public class DBWorker 
{
	// Add finals
	protected static final String NL = "\n";
	protected static final int CONNECTION_TIMEOUT_VALUE = 30;


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
		// XXX Needs to throw excpetions so they can get caught higher up
		String query = "SELECT name" + NL
						 + "FROM " + tableName + NL
						 + "LIMIT 1";
		System.out.println(query);
		
		ResultSet results = runQuery(query);
		
		System.out.println(results);
		
		return false;
	}
	
	/**
	 * Executes a sql query 
	 * 
	 * @param query the SQL query we want to run on the database
	 * @return any results we get
	 */
	private ResultSet runQuery(String query) throws Exception 
	{
		try 
		{
			Statement statement = this.connection.createStatement();
			statement.setQueryTimeout(CONNECTION_TIMEOUT_VALUE);
					
			return statement.executeQuery(query);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			ResultSet failure = null;
			return failure;
		}
	}
}
