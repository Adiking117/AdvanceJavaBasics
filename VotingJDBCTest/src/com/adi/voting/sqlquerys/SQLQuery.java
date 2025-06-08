package com.adi.voting.sqlquerys;

public class SQLQuery {

	private static String loginSqlQuery = "select * from users where email = ? and password = ?";
	
	private static String registerSqlQuery = "insert into users (first_name, last_name, email, password, dob, status, role) values (?, ?, ?, ?, ?, ?, ?)";

	public static String getLoginSqlQuery() {
		return loginSqlQuery;
	}

	public static void setLoginSqlQuery(String loginSqlQuery) {
		SQLQuery.loginSqlQuery = loginSqlQuery;
	}

	public static String getRegisterSqlQuery() {
		return registerSqlQuery;
	}

	public static void setRegisterSqlQuery(String registerSqlQuery) {
		SQLQuery.registerSqlQuery = registerSqlQuery;
	}

}

