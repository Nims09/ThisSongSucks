import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder
{
	// Add finals
	protected static final String DB_CONNECTION = "jdbc:sqlite:database.db";
	protected static final int CONNECTION_TIMEOUT_VALUE = 30;
	
	// Add globals
	protected Connection connection;
	
	/**
	 * Constructor 
	 */
	public DatabaseBuilder()
	{

	}
	
	/**
	 * Creates the tables in the DB
	 * 
	 * Should only be run if tables 
	 * don't already exist
	 */
	public static void createTables() throws ClassNotFoundException
	{	
		// Load the sqlite-JDBC driver for the current class loader
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = null;
		try
		{
			// Connect to the db
			connection = DriverManager.getConnection(DB_CONNECTION);
	   	System.out.println("trace1");

	      Statement statement = connection.createStatement();
	   	 System.out.println("trace2");
	      statement.setQueryTimeout(CONNECTION_TIMEOUT_VALUE);  // set timeout to 30 sec.
			
	      statement.executeUpdate("drop table if exists person");
	      statement.executeUpdate("create table person (id integer, name string)");
	      statement.executeUpdate("insert into person values(1, 'leo')");
	      statement.executeUpdate("insert into person values(2, 'yui')");

	      ResultSet rs = statement.executeQuery("select * from person");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("name"));
	        System.out.println("id = " + rs.getInt("id"));
	      }
		}
		catch(Exception e)
		{
			// Do somthing
			System.out.println(e.getMessage());
		}
		  finally
		    {
		      try
		      {
		        if(connection != null)
		          connection.close();
		      }
		      catch(SQLException e)
		      {
		        // connection close failed.
		        System.err.println(e);
		      }
		    }
	}
	
	public static void main(String[] args) throws ClassNotFoundException
	{
		createTables();
	}
}