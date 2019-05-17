package com.Spring.Service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class MyConnection {

	
	public Statement myCon()  {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/airlinelogin","root", "root");
			stmt = conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
		
	}
}
