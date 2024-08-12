package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/create")
public class Add_Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
        String URL = "jdbc:mysql://localhost:3306/Contact_List";
        String User = "root";
        String Pass = "root";
        String query = "insert into contacts (name,phone,email) values(?,?,?)";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); 

            // Establish connection
            Connection connection = DriverManager.getConnection(URL, User, Pass);
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, email);
            
            pst.executeUpdate();
            
            HttpSession session = request.getSession();
            session.setAttribute("message", "Contact created successfully!!!");
            response.sendRedirect("index.jsp");
            
        	}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        }

}
