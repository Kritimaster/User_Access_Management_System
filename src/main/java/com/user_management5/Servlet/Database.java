package com.user_management5.Servlet;

//public class Database {
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	// Database URL, username, and password
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/orcl_service"; // Update with actual DB URL
	private static final String USER = "chavi"; // Replace with your DB username
	private static final String PASS = "katare"; // Replace with your DB password

	// Method to establish a database connection
	public static Connection getConnection() throws SQLException {
		try {
			// Load Oracle JDBC driver (if not already loaded)
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("Oracle JDBC driver not found");
		}

		// Return connection object
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}
