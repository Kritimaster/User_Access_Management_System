package com.user_management5.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Validate the input and save the user to the database
		try (Connection conn = Database.getConnection()) {
			String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, 'Employee')";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("login.jsp");
	}
}
