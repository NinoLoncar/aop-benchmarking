package com.foi.nloncar.exception;

public class RiskyException extends RuntimeException {

	public RiskyException(String message) {
		super(message);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
