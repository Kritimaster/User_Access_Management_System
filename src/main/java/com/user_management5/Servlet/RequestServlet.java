package com.user_management5.Servlet;

//public class RequestServlet {
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String softwareId = request.getParameter("softwareId");
		String accessType = request.getParameter("accessType");
		String reason = request.getParameter("reason");

		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();

		try (Connection conn = Database.getConnection()) {
			String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, userId);
				stmt.setString(2, softwareId);
				stmt.setString(3, accessType);
				stmt.setString(4, reason);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("requestAccess.jsp");
	}
}
