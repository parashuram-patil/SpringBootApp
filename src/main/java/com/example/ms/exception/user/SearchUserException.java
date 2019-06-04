package com.example.ms.exception.user;

public class SearchUserException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "Error in Searching User";

	public SearchUserException() {
		super(message);
	}

	public SearchUserException(String userName) {
		super(message + " with Name '" + userName + "'");
	}

	public SearchUserException(Integer userId) {
		super(message + " with ID '" + userId + "'");
	}

	public SearchUserException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}