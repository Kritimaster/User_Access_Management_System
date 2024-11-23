package com.user_management5.Servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//public class DatabaseSetup {
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

	// Method to read SQL from file and execute it
	public static void executeSQLFromFile(String filePath) {
		StringBuilder sqlBuilder = new StringBuilder();

		try {
			// Read SQL file
			Files.lines(Paths.get(filePath)).forEach(line -> sqlBuilder.append(line).append("\n"));

			// Get the SQL commands as a single string
			String sqlScript = sqlBuilder.toString();

			// Split the script into individual commands (assuming each command ends with a
			// semicolon)
			String[] commands = sqlScript.split(";");

			// Connect to database and execute each command
			try (Connection conn = Database.getConnection()) { // Using Database.getConnection() to get the connection
				// Disable auto-commit for batch processing
				conn.setAutoCommit(false);

				// Iterate over each SQL command and execute it
				for (String command : commands) {
					if (!command.trim().isEmpty()) {
						try (Statement stmt = conn.createStatement()) {
							stmt.executeUpdate(command.trim()); // Execute the SQL command
						}
					}
				}

				// Commit the transaction after executing all commands
				conn.commit();
				System.out.println("SQL commands executed successfully.");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Provide the path to your SQL file
		String filePath = "\"C:\\Users\\kriti katare\\Downloads\\Database.sql\""; // Update with the correct path
		executeSQLFromFile(filePath);
	}
}
