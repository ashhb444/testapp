package com.examination.dataaccess.exception;

public class DataAccessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public DataAccessException(int errorCode,Throwable cause){
		super(cause);
		this.errorCode = errorCode;	
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DataAccessException(int errorCode,String message){
		super(message);
		this.errorCode = errorCode;	
	}
	
	public DataAccessException(int errorCode,String message,Throwable cause){
		super(message, cause);
		this.errorCode = errorCode;	
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
