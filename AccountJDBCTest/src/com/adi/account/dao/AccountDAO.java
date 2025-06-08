package com.adi.account.dao;

import java.sql.SQLException;

public interface AccountDAO {
	String transferFunds(int fromAccId,int toAccId,double money) throws SQLException;
}
