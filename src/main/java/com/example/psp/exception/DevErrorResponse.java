package com.example.psp.exception;

import io.swagger.annotations.ApiModelProperty;

public class DevErrorResponse extends ErrorResponse {

	@ApiModelProperty(example = "Complete Exception for Developers")
	private Exception exception;

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
