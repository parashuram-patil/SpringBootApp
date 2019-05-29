package com.psp.exception.city;

public class CityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "City with :msg not found";

	public CityNotFoundException() {
		super(message);
	}

	public CityNotFoundException(String cityName) {
		super(message.replace(":msg", ("name " + cityName)));
	}

	public CityNotFoundException(Integer cityId) {
		super(message.replace(":msg", ("id " + cityId)));
	}

	public CityNotFoundException(Throwable throwable) {
		super(message, throwable);
	}
}