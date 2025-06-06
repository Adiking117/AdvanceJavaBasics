package com.adi.voting.dao;

import java.sql.*;

import com.adi.voting.entity.User;
import com.adi.voting.exception.UserAlreadyExistException;
import com.adi.voting.pojo.UserRequest;
import com.adi.voting.sqlquerys.SQLQuerys;

import static com.adi.voting.utils.DBUtils.*;


public class UserDAOImpl implements UserDAO {

	private PreparedStatement preparedStatementLogin,
	preparedStatementRegister,
	preparedStatementUserAlreadyExist,
	preparedStatementUpdateVotingStatus;
	private Connection connection;
	
	public UserDAOImpl() throws ClassNotFoundException, SQLException {
		// openConnection();
		connection = getConnection();
		
		preparedStatementLogin = connection.prepareStatement(SQLQuerys.getLoginSqlQuery());
		preparedStatementRegister = connection.prepareStatement(SQLQuerys.getRegisterSqlQuery());
		preparedStatementUserAlreadyExist = connection.prepareStatement(SQLQuerys.getUserAlreadyExist());
		preparedStatementUpdateVotingStatus = connection.prepareStatement(SQLQuerys.getUpdateVotingStatus());
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
		preparedStatementUserAlreadyExist.setString(1,user.getEmail());
		try (ResultSet rs = preparedStatementUserAlreadyExist.executeQuery()) {
		    if (rs.next()) {
		    	
		        throw new UserAlreadyExistException("User Already Exist. Kindly Login.");
		    }
		} catch (UserAlreadyExistException e) {
			e.printStackTrace();
		}
		preparedStatementRegister.setString(1, user.getFirstName());
		preparedStatementRegister.setString(2, user.getLastName());
		preparedStatementRegister.setString(3, user.getEmail());
		preparedStatementRegister.setString(4, user.getPassword());
		preparedStatementRegister.setDate(5, new java.sql.Date(user.getDob().getTime()));
		preparedStatementRegister.setBoolean(6, false);
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
		// closeConnection();
	}

	@Override
	public boolean updateVotingStatus(int userId) throws SQLException {
		preparedStatementUpdateVotingStatus.setInt(1, userId);
		int votingStatusUpdated = preparedStatementUpdateVotingStatus.executeUpdate();
		return votingStatusUpdated == 1;
	}
	

}
