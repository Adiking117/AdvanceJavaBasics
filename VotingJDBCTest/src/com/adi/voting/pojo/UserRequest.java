package com.adi.voting.pojo;

import java.sql.Date;

public class UserRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private java.util.Date dob;
	private boolean status;
	private String userRole;
	
	public UserRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserRequest(String firstName, String lastName, String email, String password, java.util.Date dob, boolean status,
			String userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.userRole = userRole;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User " + "firstName = " + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", status=" + status + ", userRole=" + userRole + "]";
	}
}
