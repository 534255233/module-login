package com.zlp.exception;

public class PasswdErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PasswdErrorException(String msg) {
		super(msg);
	}
	
	public PasswdErrorException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
