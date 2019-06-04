package com.example.ms.advice.asset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ms.advice.MSControllerAdvice;
import com.example.ms.exception.asset.SearchAssetExceptionException;
import com.example.psp.exception.ErrorResponse;

@ControllerAdvice
public class MSAssetControllerAdvice extends MSControllerAdvice {

	@ExceptionHandler(SearchAssetExceptionException.class)
	protected ResponseEntity<ErrorResponse> handleAssetException(SearchAssetExceptionException ex) {
		ErrorResponse errors = getErrorResponse(ex);

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
}