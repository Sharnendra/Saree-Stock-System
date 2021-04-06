package com.shopsaree.stock.exception;

public abstract class HrAppException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	private boolean isWarning;
	private boolean isFatalError;
	
	public HrAppException(String code,String message,boolean isWarning,boolean isFatalError) {
		super(message);
		this.errorCode = code;
		this.errorMessage = message;
		this.isWarning = isWarning;
		this.isFatalError = isFatalError;
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isWarning() {
		return isWarning;
	}

	public void setWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}

	public boolean isFatalError() {
		return isFatalError;
	}

	public void setFatalError(boolean isFatalError) {
		this.isFatalError = isFatalError;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
