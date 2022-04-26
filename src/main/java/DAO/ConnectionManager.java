package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static String connectionURL = "jdbc:postgresql://salt.db.elephantsql.com:5432/hivhwnvw";
	private static String username = "hivhwnvw";
	private static String password = "orhUkys_ounYNmZJo1o_LLSshzWQ6MLw";
	
	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(connectionURL, username, password);
			}
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} return null;
	}
	
}