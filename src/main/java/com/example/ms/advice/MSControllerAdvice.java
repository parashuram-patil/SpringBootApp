package com.example.ms.advice;

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

@ControllerAdvice
public class MSControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
		ErrorResponse errors = getErrorResponse(ex);
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
		ErrorResponse errors = getErrorResponse(ex);

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	protected ErrorResponse getErrorResponse(Exception ex) {

		ErrorResponse errors = null;

		if (PropertyValues.ACTIVE_PROFILE.equals(Constants.PROFILE_DEV)) {
			errors = new DevErrorResponse();
			((DevErrorResponse) errors).setException(ex);

		} else {
			errors = new ErrorResponse();
		}

		errors.setTimestamp(LocalDateTime.now());
		errors.setErrorMessage(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		errors.setCause(ex.getClass().getSimpleName());

		return errors;
	}
}