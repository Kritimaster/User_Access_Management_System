package com.user_management5.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class SoftwareServlet {
//	@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String accessLevels = request.getParameter("accessLevels");

		try (Connection conn = Database.getConnection()) {
			String sql = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setString(3, accessLevels);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("createSoftware.jsp");
	}
}
