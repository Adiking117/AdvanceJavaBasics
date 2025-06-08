package com.adi.jdbctest.test;

import static com.adi.jdbctest.utils.DBUtils.closeConnection;
import static com.adi.jdbctest.utils.DBUtils.getConnection;
import static com.adi.jdbctest.utils.DBUtils.openConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TestStatement {

	public static void main(String[] args) {
		try {
			openConnection();
			Connection connection = getConnection();
			
			Statement statement = connection.createStatement();
			
			String sqlString = "select * from users";
			
			try(ResultSet resultSet = statement.executeQuery(sqlString)){ // Autoclosable
				while(resultSet.next()) {
					System.out.printf(
				            "User ID: %d | Name: %s %s | Email: %s | Role: %s | Status: %s%n",
				            resultSet.getInt("id"),
				            resultSet.getString("first_name"),
				            resultSet.getString("last_name"),
				            resultSet.getString("email"),
				            resultSet.getString("role"),
				            resultSet.getBoolean("status") ? "Active" : "Inactive"
				        );
				}
			}
			
			
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
