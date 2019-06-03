package com.example.ms.exception.asset;

public class SearchAssetExceptionException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "Error in Searching Asset";

	public SearchAssetExceptionException() {
		super(message);
	}

	public SearchAssetExceptionException(String assetName) {
		super(message + " with Name ' " + assetName + "'");
	}

	public SearchAssetExceptionException(Integer assetId) {
		super(message + " with ID ' " + assetId + "'");
	}

	public SearchAssetExceptionException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}