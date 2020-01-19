package com.harsh.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Users.UserEntity;
import UtilityMethod.Dao;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init() {
		try {
			System.out.println("init()");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("doPost()");
		String email = request.getParameter("email");
	  

		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("delete from user where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				Dao d=new Dao();
				List<UserEntity> ls=d.getData(connection);
				request.setAttribute("message", ls);
				request.setAttribute("data", "delete user");// This will be available as ${message}
		        request.getRequestDispatcher("/showUser.jsp").forward(request, response);
				//out.print("<H1>User Deleted</H1");
			} else {
				request.setAttribute("data", "data not deleted!!");// This will be available as ${message}
			    
				//out.print("<H1>"+email+"User not found in the database.</H1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		try {
			System.out.println("destroy()");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
