package com.adi.voting.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static Connection connection;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Aditya@2003";
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(connection == null)
			connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			System.out.println("db connection opened....");
	}
	
	
	public static Connection getConnection() {
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if(connection!= null)
			connection.close();
			connection = null;
			System.out.println("db connection closed....");
	}
}
