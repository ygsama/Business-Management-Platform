package com.xxx.sys.exception;

public class SysException extends Exception {

	private String message;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public SysException(String message) {
		this.message = message;
	}
	
}
