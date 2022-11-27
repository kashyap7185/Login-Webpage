package com.Login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class LoginDao {
	
	String url = "jdbc:mysql://localhost:3306/shashank";
	String user = "root";
	String pass = "kashyap";
	String query = "select * from login where uname = ? and pass = ?";
	String query1 = "insert into login (uname,pass) values(?,?)";
	
public boolean checkDetails(String username,String password) throws SQLException
{

	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1, username);
		stat.setString(2, password);
		
		ResultSet rs = stat.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	
	return false;
	
}


public void RegisterMember(String username,String password) throws SQLException {

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		PreparedStatement stat = conn.prepareStatement(query);
		stat.setString(1,username);
		stat.setString(2, password);
		
	 stat.executeUpdate();
		
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}

	
	
	
	
	
}
}
