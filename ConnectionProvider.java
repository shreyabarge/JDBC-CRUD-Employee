package com.crud.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
   static Connection con;
   public static Connection getConnection() {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PracticeDemo","root","root");
		
	} catch (SQLException | ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	return con;
	   
   }
}
