package com.example.psp.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(example = "9999-12-31 00:00:00")
	private LocalDateTime timestamp;

	@ApiModelProperty(example = "404")
	private int status;

	@ApiModelProperty(example = "Some meaningful error message")
	private String errorMessage;

	@ApiModelProperty(example = "<XXX>Exception", notes = "Exction cause")
	private String cause;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String error) {
		this.errorMessage = error;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
