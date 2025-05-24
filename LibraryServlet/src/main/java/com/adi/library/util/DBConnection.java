package com.adi.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/library_db";
	private static final String USER = "root";
	private static final String PASSWORD = "Aditya@2003";
	
	public static Connection getConnection() throws SQLException {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver explicitly
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        throw new SQLException("MySQL Driver not found!");
	    }
	    return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
