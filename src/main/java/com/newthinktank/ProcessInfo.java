package com.newthinktank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessInfo
 */
@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/DisplayInfo.jsp";
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");

		updateDB(fName, lName, phone);

		Customer cust = new Customer(fName, lName, phone);

		request.setAttribute("cust", cust);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void updateDB(String fName, String lName, String phone) {
		Connection con;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";
			String user = "dbadmin";
			String pw = "turtledove";
			con = DriverManager.getConnection(url, user, pw);

			String query = "INSERT INTO CUSTOMER " + "(first_name, last_name, phone, cust_id) "
					+ "VALUES (?, ?, ?, NULL)";
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1, fName);
			p.setString(2, lName);
			p.setString(3, phone);

			p.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
