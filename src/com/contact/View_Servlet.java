package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewcontacts")
public class View_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        
        // Set content type
        response.setContentType("text/plain"); // Output as plain text
        PrintWriter out = response.getWriter();

        String URL = "jdbc:mysql://localhost:3306/Contact_List";
        String User = "root";
        String Pass = "root";
        String query = "SELECT * FROM contacts";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); // Update driver class if using MySQL Connector/J 8.x

            // Establish connection
            Connection connection = DriverManager.getConnection(URL, User, Pass);
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                // Print the data
                out.println("Name: " + name);
                out.println("Phone: " + phone);
                out.println("Email: " + email);
                out.println("----------------------");
            }

            // Close resources
            rs.close();
            pst.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            out.close();
        }
    }
}
