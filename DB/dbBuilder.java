import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbBuilder
{
	// Add finals
	public static final String DB_CONNECTION = "jbdc.sqlite:database.db";
	public static final int CONNECTION_TIMEOUT_VALUE = 30;
	
	/**
	 * Creates the tables in the DB
	 * 
	 * Should only be run if tables 
	 * don't already exist
	 */
	public void createTables() throws ClassNotFoundException
	{
		// Load the sqlite-JDBC driver for the current class loader
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = null;
		try
		{
			// Connect to the db
			connection = DriverManager.getConnection(DB_CONNECTION);
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(CONNECTION_TIMEOUT_VALUE);  // set timeout to 30 sec.
			
		}
		catch(Exception e)
		{
			// Do somthing
		}
	}
}