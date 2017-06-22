package com.loyalty.exception;

public class ServiceErrorResponse
{
  private int errorCode = 2001;
  private String message = "Something gone wrong. We're embarrassed. Take a break and try again.";
  
  public ServiceErrorResponse(int errorCode, String errorMessage)
  {
    this.errorCode = errorCode;
    this.message = errorMessage;
  }

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
}