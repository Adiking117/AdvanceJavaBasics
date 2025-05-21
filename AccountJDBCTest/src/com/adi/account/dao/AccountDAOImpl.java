package com.adi.account.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.adi.account.sqlquerys.SQLQuery;

import static com.adi.account.utils.DBUtils.*;

public class AccountDAOImpl implements AccountDAO {

	private Connection connection;
	private CallableStatement callableStatement;
	
	public AccountDAOImpl() throws ClassNotFoundException, SQLException {
		openConnection();
		connection = getConnection();
		
		callableStatement = connection.prepareCall(SQLQuery.getStoreProcTransferFundsQuery());
		
		callableStatement.registerOutParameter(4,Types.DOUBLE);
		callableStatement.registerOutParameter(5, Types.DOUBLE);
		
	}
	@Override
	public String transferFunds(int fromAccId, int toAccId, double money) throws SQLException {
		callableStatement.setInt(1, fromAccId);
		callableStatement.setInt(2, toAccId);
		callableStatement.setDouble(3, money);
		
		boolean res = callableStatement.execute();
		
		return "Updated src balance "
			+callableStatement.getDouble(4)+" dest balance "
			+callableStatement.getDouble(5);
		
//		return "Transfer failed";
			
	}
	
	public void cleanUp() throws SQLException
	{
		if(callableStatement != null)
		{
			callableStatement.close();
			callableStatement=null;
		}
		closeConnection();
	}

}
