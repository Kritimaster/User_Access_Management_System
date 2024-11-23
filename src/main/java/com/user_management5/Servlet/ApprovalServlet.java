package com.user_management5.Servlet;

//@WebServlet("/ApprovalServlet")
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovalServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestId = request.getParameter("requestId");
		String action = request.getParameter("action");

		String status = action.equals("Approve") ? "Approved" : "Rejected";

		try (Connection conn = Database.getConnection()) {
			String sql = "UPDATE requests SET status = ? WHERE id = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, status);
				stmt.setString(2, requestId);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("pendingRequests.jsp");
	}
}

//public class ApprovalServlet {
//
//}
