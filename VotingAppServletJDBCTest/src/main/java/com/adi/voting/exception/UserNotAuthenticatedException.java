package com.adi.voting.exception;

public class UserNotAuthenticatedException extends Exception{
	public UserNotAuthenticatedException(String message) {
		super(message);
	}
}
