package com.exam.util;

public class UserFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("Username exists already, try another one!");
	}
	
	public UserFoundException(String message) {
		super(message);
	}

}
