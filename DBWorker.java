import java.sql.*;

public class DBWorker 
{
	// Add finals
	protected static final String NL = "\n";
	protected static final int CONNECTION_TIMEOUT_VALUE = 30;
	protected static final String SPECIFIC_TRACK_INSTANCE_TABLE_NAME = "specifictrackinstance";
	protected static final String GROUPED_TRACK_INSTANCE_TABLE_NAME = "groupedtrackinstance";	

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
	 */
	public void instiateDatabaseTables() throws Exception
	{
		String query = "";
		
		// Check and create specific instance table
		query = 
					"CREATE TABLE IF NOT EXISTS "
					+ SPECIFIC_TRACK_INSTANCE_TABLE_NAME
					+ " (name TEXT)";
		runUpdate(query);
		
		// Check and create grouped instance table
		query = 
				"CREATE TABLE IF NOT EXISTS "
				+ GROUPED_TRACK_INSTANCE_TABLE_NAME
				+ " (name TEXT)";
		runUpdate(query);
	}
	
	/**
	 * Executes a sql update 
	 * 
	 * @param query the SQL query we want to run on the database
	 */
	private void runUpdate(String query) throws Exception 
	{
		try 
		{
			Statement statement = this.connection.createStatement();
			statement.setQueryTimeout(CONNECTION_TIMEOUT_VALUE);
			statement.executeUpdate(query);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//XXX make sure to add batch statments to avoid having to loop
}
