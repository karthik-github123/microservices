package com.loyalty.exception;

public class ServiceException extends Exception {
	private int errorCode = 2001;
	private int statusCode = 500;

	public ServiceException(int code, int httpStatusCode, String message, Throwable throwable) {
		super(message, throwable);
		errorCode = code;
		statusCode = httpStatusCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
	
}