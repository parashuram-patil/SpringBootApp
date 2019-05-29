package com.psp.exception.city;

public abstract class AbstractException extends Exception {

	private static final long serialVersionUID = 1L;

	public AbstractException(String msg) {
		super(msg);
	}
	
	public AbstractException(Throwable throwable) {
		super(throwable);
	}
	
	public AbstractException(String msg, Throwable throwable) {
		super(msg,throwable);
	}

}
