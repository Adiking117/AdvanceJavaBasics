package com.adi.jdbctest.test;
import static com.adi.jdbctest.utils.DBUtils.*;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		try {
			openConnection();
			Connection connection = getConnection();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
