package com.examination.core.exception;

public class GenericResultSetException extends Exception {
	
	private int errorCode;

	public GenericResultSetException(int errorCode,Throwable cause){
		super(cause);
		this.errorCode = errorCode;	
	}

	public GenericResultSetException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GenericResultSetException(int errorCode,String message){
		super(message);
		this.errorCode = errorCode;	
	}
	
	public GenericResultSetException(int errorCode,String message,Throwable cause){
		super(message, cause);
		this.errorCode = errorCode;	
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
