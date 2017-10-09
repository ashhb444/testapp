package com.examination.core.exception;

public class UserAuthenticationException extends Exception {

	private int errorCode;
	
	public UserAuthenticationException(int errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public UserAuthenticationException(String message) {
		super(message);
	}
	public int getErrorCode() {
		return errorCode;
	}
}
