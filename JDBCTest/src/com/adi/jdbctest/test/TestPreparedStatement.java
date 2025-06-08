package com.adi.jdbctest.test;
import static com.adi.jdbctest.utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			openConnection();
			Connection connection = getConnection();
			
			String sqlString = "select * from users where email = ? and password = ?";
			
			System.out.print("Enter email : ");
			String userEmail = scanner.next();
			System.out.println("Enter Password : ");
			String userPassword = scanner.next();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1,userEmail);
			preparedStatement.setString(2, userPassword);
			
			
			try (ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					System.out.printf(
				            "User ID: %d | Name: %s %s | Email: %s | Role: %s | Status: %s%n",
				            resultSet.getInt("id"),
				            resultSet.getString("first_name"),
				            resultSet.getString("last_name"),
				            resultSet.getString("email"),
				            resultSet.getString("role"),
				            resultSet.getBoolean("status") ? "Active" : "Inactive"
				        );
				}else {
					System.out.println("No User Found");
				}
			}
	
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
