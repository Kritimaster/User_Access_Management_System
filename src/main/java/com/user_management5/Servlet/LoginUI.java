//package com.tinkus.cafe.Servlet;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class LoginUI
// */
//@WebServlet("/LoginUI")
//public class LoginUI extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public LoginUI() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
package com.user_management5.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUI
 */
@WebServlet("/loginUI")
public class LoginUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUI() {
		super();
		System.out.println("LoginUIServlet: Creating Object.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginUIServlet: Get Method.");

		PrintWriter printWriter = response.getWriter();

//		printWriter.append(0)
		printWriter.append("<html>");
		printWriter.append("<head>");
		printWriter.append("<meta charset='ISO-8859-1'>");
		printWriter.append("<title>Login</title>");
		printWriter.append("</head>");
		printWriter.append("<body>");
		printWriter.append("<h1>Login</h1>");
		printWriter.append("<table>");
		printWriter.append("<tr>");
		printWriter.append("<td>Username: </td>");
		printWriter.append("<td><input type='text' name='username'></td>");
		printWriter.append("</tr>");
		printWriter.append("<tr>");
		printWriter.append("<td>Password: </td>");
		printWriter.append("<td><input type='password' name='username'></td>");
		printWriter.append("</tr>");
		printWriter.append("<tr>");
		printWriter.append("<td><input type='submit' name='Submit'></td>");
		printWriter.append("<td><input type='reset' name='Reset'></td>");
		printWriter.append("</tr");
		printWriter.append("</table");
		printWriter.append("</body");
		printWriter.append("</html");

	}

}
