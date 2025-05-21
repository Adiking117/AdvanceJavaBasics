package com.adi.voting.test;

import static com.adi.voting.utils.DBUtils.*;

import java.sql.*;
import java.util.Scanner;

public class SQLInjectionAttackTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter User id");
			String id = sc.nextLine();
			openConnection();
			Connection cn = getConnection();
			// create JDBC statement from connection
			Statement stmt = cn.createStatement();
			// execute select query to produce a result set
			ResultSet rst = stmt.executeQuery("select * from users where id=" + id);
			// input : 12345 or 1
			
			System.out.println("User Details - ");
			while (rst.next()) {
				System.out.printf("ID %d Name %s %s Email %s" + "Pwd %s Dob %s Status %b Role %s %n", rst.getInt(1),
						rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
			}
			stmt.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("main over...");
	}

}
