package com.adi.account.entity;

public class Account {
	private int accId;
	private String accCustName;
	private String accType;
	private double accBalance;
	public Account(int accId, String accCustName, String accType, double accBalance) {
		super();
		this.accId = accId;
		this.accCustName = accCustName;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccCustName() {
		return accCustName;
	}
	public void setAccCustName(String accCustName) {
		this.accCustName = accCustName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accCustName=" + accCustName + ", accType=" + accType + ", accBalance="
				+ accBalance + "]";
	}
	
	
}
