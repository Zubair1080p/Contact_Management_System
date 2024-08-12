package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delete")
public class Remove_Servlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String URL = "jdbc:mysql://localhost:3306/Contact_List";
		String User = "root";
		String Pass = "root";
		String query = "delete from contacts where phone = ? ";
		
		String phone = request.getParameter("phone");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,User,Pass);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, phone);
			pst.executeUpdate();
			
			HttpSession session = request.getSession();
			session.setAttribute("message", "Contact deleted successfully!!!");
			response.sendRedirect("Remove.jsp");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
