package com.user_management5.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	// public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try (Connection conn = Database.getConnection()) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, username);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					String role = rs.getString("role");
					HttpSession session = request.getSession();
					session.setAttribute("role", role);
					if (role.equals("Employee")) {
						response.sendRedirect("requestAccess.jsp");
					} else if (role.equals("Manager")) {
						response.sendRedirect("pendingRequests.jsp");
					} else if (role.equals("Admin")) {
						response.sendRedirect("createSoftware.jsp");
					}
				} else {
					response.sendRedirect("login.jsp?error=Invalid credentials");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
