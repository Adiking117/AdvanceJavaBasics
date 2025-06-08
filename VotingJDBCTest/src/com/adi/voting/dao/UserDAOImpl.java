package com.adi.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.adi.voting.entity.User;
import com.adi.voting.pojo.UserRequest;
import com.adi.voting.sqlquerys.SQLQuery;

import static com.adi.voting.utils.DBUtils.*;


public class UserDAOImpl implements UserDAO{

	private PreparedStatement preparedStatementLogin,preparedStatementRegister;
	private Connection connection;
	
	public UserDAOImpl() throws ClassNotFoundException, SQLException {
		openConnection();
		connection = getConnection();
		
		preparedStatementLogin = connection.prepareStatement(SQLQuery.getLoginSqlQuery());
		preparedStatementRegister = connection.prepareStatement(SQLQuery.getRegisterSqlQuery());
		
	}
	
	@Override
	public User loginUser(String userEmail, String userPassword) throws SQLException {
		preparedStatementLogin.setString(1,userEmail);
		preparedStatementLogin.setString(2,userPassword);
		try(ResultSet userFetchedResultSet = preparedStatementLogin.executeQuery()){
			if(userFetchedResultSet.next()) {
				return new User(
						userFetchedResultSet.getInt(1),
						userFetchedResultSet.getString(2),
						userFetchedResultSet.getString(3),
						userFetchedResultSet.getString(4),
						userFetchedResultSet.getString(5),
						userFetchedResultSet.getDate(6),
						userFetchedResultSet.getBoolean(7),
						userFetchedResultSet.getString(8)
					);
			}
		}
		return null;
	}
	

	@Override
	public boolean registerUser(UserRequest user) throws SQLException {
		preparedStatementRegister.setString(1, user.getFirstName());
		preparedStatementRegister.setString(2, user.getLastName());
		preparedStatementRegister.setString(3, user.getEmail());
		preparedStatementRegister.setString(4, user.getPassword());
		preparedStatementRegister.setDate(5, new java.sql.Date(user.getDob().getTime()));
		preparedStatementRegister.setBoolean(6, user.isStatus());
		preparedStatementRegister.setString(7, user.getUserRole());
		
		int userRegister = preparedStatementRegister.executeUpdate();
		
		return userRegister == 1;
		
		
	}
	
	public void cleanUp() throws SQLException {
		if (preparedStatementLogin != null) {
			preparedStatementLogin.close();
			preparedStatementLogin = null;
		}
		if (preparedStatementRegister != null) {
			preparedStatementRegister.close();
			preparedStatementRegister = null;
		}
		closeConnection();
	}
	

}
