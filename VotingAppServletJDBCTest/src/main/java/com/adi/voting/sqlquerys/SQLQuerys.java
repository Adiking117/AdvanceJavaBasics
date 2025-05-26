package com.adi.voting.sqlquerys;

public class SQLQuerys {
	private static String loginSqlQuery = "select * from users where email = ? and password = ?";
	
	private static String registerSqlQuery = "insert into users (first_name, last_name, email, password, dob, status, role) values (?, ?, ?, ?, ?, ?, ?)";

	private static String userAlreadyExist = "select 1 from users where email = ?";
	
	public static String getLoginSqlQuery() {
		return loginSqlQuery;
	}

	public static void setLoginSqlQuery(String loginSqlQuery) {
		SQLQuerys.loginSqlQuery = loginSqlQuery;
	}

	public static String getRegisterSqlQuery() {
		return registerSqlQuery;
	}

	public static void setRegisterSqlQuery(String registerSqlQuery) {
		SQLQuerys.registerSqlQuery = registerSqlQuery;
	}

	public static String getUserAlreadyExist() {
		return userAlreadyExist;
	}

	public static void setUserAlreadyExist(String userAlreadyExist) {
		SQLQuerys.userAlreadyExist = userAlreadyExist;
	}

}
