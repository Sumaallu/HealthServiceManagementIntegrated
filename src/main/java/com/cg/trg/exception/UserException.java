package com.cg.trg.exception;

public class UserException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public UserException() {
		
	}

	public UserException(String message) {
		super(message);
		this.message=message;
	}
	
	public UserException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
	
}