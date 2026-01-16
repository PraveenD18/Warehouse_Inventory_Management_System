package com.wims.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse {

	private LocalDateTime timestamp;
	private int status;
	private Map<String, String> errors;

	public ValidationErrorResponse(int status, Map<String, String> errors) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.errors = errors;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
