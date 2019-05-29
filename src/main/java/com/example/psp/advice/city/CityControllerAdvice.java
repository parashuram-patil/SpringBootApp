package com.example.psp.advice.city;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.psp.exception.CustomErrorResponse;
import com.psp.exception.city.CityNotFoundException;

@ControllerAdvice
public class CityControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CityNotFoundException.class)
	protected ResponseEntity<CustomErrorResponse> handleCityNotFoundException(CityNotFoundException ex) {
		CustomErrorResponse errors = getErrorResponse(ex);

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	private CustomErrorResponse getErrorResponse(Exception ex) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());

		return errors;
	}

}
