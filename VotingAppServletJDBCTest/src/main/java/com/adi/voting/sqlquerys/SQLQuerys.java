package com.adi.voting.sqlquerys;

public class SQLQuerys {
	private static String loginSqlQuery = "select * from users where email = ? and password = ?";
	
	private static String registerSqlQuery = "insert into users (first_name, last_name, email, password, dob, status, role) values (?, ?, ?, ?, ?, ?, ?)";

	private static String userAlreadyExist = "select 1 from users where email = ?";
	
	private static String getAllCandidatesQuery = "select * from candidates";
	
	private static String getCandidatesByIdQuery = "select * from candidates where candidateid = ?";
	
	private static String incrementCandidateVotes = "update candidates set votes = votes+1 where candidateid = ?";

	private static String updateVotingStatus = "update users set status = 1 where id = ?";
	
	public static String getUpdateVotingStatus() {
		return updateVotingStatus;
	}

	public static void setUpdateVotingStatus(String updateVotingStatus) {
		SQLQuerys.updateVotingStatus = updateVotingStatus;
	}

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

	public static String getGetAllCandidatesQuery() {
		return getAllCandidatesQuery;
	}

	public static void setGetAllCandidatesQuery(String getAllCandidatesQuery) {
		SQLQuerys.getAllCandidatesQuery = getAllCandidatesQuery;
	}

	public static String getGetCandidatesByIdQuery() {
		return getCandidatesByIdQuery;
	}

	public static void setGetCandidatesByIdQuery(String getCandidatesByIdQuery) {
		SQLQuerys.getCandidatesByIdQuery = getCandidatesByIdQuery;
	}

	public static String getIncrementCandidateVotes() {
		return incrementCandidateVotes;
	}

	public static void setIncrementCandidateVotes(String incrementCandidateVotes) {
		SQLQuerys.incrementCandidateVotes = incrementCandidateVotes;
	}

}
