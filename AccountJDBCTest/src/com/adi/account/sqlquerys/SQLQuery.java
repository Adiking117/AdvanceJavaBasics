package com.adi.account.sqlquerys;

public class SQLQuery {
	private static String storeProcTransferFundsQuery = 
			"{call transfer_funds_proc(?,?,?,?,?)}";

	public static String getStoreProcTransferFundsQuery() {
		return storeProcTransferFundsQuery;
	}

	
	
}
