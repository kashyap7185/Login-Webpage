package com.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.Login.dao.LoginDao;


@WebServlet("/Register")
public class Register extends HttpServlet {

	
	String url = "jdbc:mysql://localhost:3306/shashank";
	String user = "root";
	String pass = "kashyap";
	String query = "select * from login where uname = ? and pass = ?";
	
	LoginDao login = new LoginDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		
		
	
		try {
			if(uname.isBlank() || password.isBlank()) {
				response.sendRedirect("Reg.jsp");
			}
			else if(login.checkDetails(uname,password)) {
				
				response.sendRedirect("Reg.jsp");
				
				
			}
			else {
				login.RegisterMember(uname, password);

					
					response.sendRedirect("login.jsp");
				
				
				
			
			}
		}
	
	
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
