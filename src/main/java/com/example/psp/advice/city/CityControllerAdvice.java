package com.example.psp.advice.city;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.psp.constants.Constants;
import com.example.psp.constants.PropertyValues;
import com.example.psp.exception.DevErrorResponse;
import com.example.psp.exception.ErrorResponse;
import com.example.psp.exception.city.CityNotFoundException;

@ControllerAdvice
public class CityControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CityNotFoundException.class)
	protected ResponseEntity<ErrorResponse> handleCityNotFoundException(CityNotFoundException ex) {
		ErrorResponse errors = getErrorResponse(ex);

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	private ErrorResponse getErrorResponse(Exception ex) {
		ErrorResponse errors = null;

		if (PropertyValues.ACTIVE_PROFILE.equals(Constants.PROFILE_DEV)) {
			errors = new DevErrorResponse();
			((DevErrorResponse) errors).setException(ex);

		} else {
			errors = new ErrorResponse();
		}

		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());

		return errors;
	}

}