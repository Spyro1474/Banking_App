package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

//this is the class where we are going to create a connection to the database
public class ConnectionManager {
	
	//lowercase connection is the NAME; Connection with capital C is what it is AKA the datatype
	private static Connection connection;
	
	private static String connectionString = "jdbc:postgresql://salt.db.elephantsql.com:5432/hivhwnvw",
			username = "hivhwnvw",
			password = "6QZPu6IuAuPpR7d3kdFUP-jYpiooTePm";
	
	
	public static Connection getConnection() {
		//if we dont use a try catch block it will not compile
		try {
				if(connection == null || connection.isClosed()) {
					//this ensures that the driver class is loaded before we try to use it
					//it will fail without it. it needs the maven dependency added in the pom.xml file
					Class.forName("org.postgresql.Driver");
					
					//this is saying to use the driver manager to make sure there is a suitable 
					//driver to make the connection string work.
					//it will call the postgres driver to set up the output/input io stream to pass
					//data between the application and the database.
					connection = DriverManager.getConnection(connectionString, username, password);
				}
				return connection;
		} catch (Exception e) {
		} return null;
	}

}
