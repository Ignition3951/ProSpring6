package com.utk.exception;

public class TitleTooLongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TitleTooLongException(String message) {
		super(message);
	}

	public TitleTooLongException(String message, Throwable cause) {
		super(message, cause);
	}

}
