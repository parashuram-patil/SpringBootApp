package com.psp.exception.city;

public class CityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException() {
		super();
	}

	public CityNotFoundException(String msg) {
		super(msg);
	}

	public CityNotFoundException(Throwable throwable) {
		super(throwable);
	}

	public CityNotFoundException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}