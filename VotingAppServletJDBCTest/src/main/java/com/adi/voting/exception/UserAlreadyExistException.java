package com.adi.voting.exception;

public class UserAlreadyExistException extends Exception{
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
