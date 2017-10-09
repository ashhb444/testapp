package com.examination.core.exception;

public class FileAccessException extends Exception {
	
	private int errorCode;

	public FileAccessException(int errorCode,Throwable cause){
		super(cause);
		this.errorCode = errorCode;	
	}

	public FileAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FileAccessException(int errorCode,String message){
		super(message);
		this.errorCode = errorCode;	
	}
	
	public FileAccessException(int errorCode,String message,Throwable cause){
		super(message, cause);
		this.errorCode = errorCode;	
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
