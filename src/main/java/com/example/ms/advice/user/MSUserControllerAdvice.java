package com.example.ms.advice.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ms.advice.MSControllerAdvice;
import com.example.ms.exception.user.SearchUserException;
import com.example.psp.exception.ErrorResponse;

@ControllerAdvice
public class MSUserControllerAdvice extends MSControllerAdvice {

	@ExceptionHandler(SearchUserException.class)
	protected ResponseEntity<ErrorResponse> handleUsersException(SearchUserException ex) {
		ErrorResponse errors = getErrorResponse(ex);

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
}