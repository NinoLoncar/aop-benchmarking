package com.foi.nloncar.exception;

public class RiskyService {

	public int withInlineHandling(int n) {
		try {
			return riskyCompute(n);
		} catch (RiskyException e) {
			return -1;
		}
	}

	public int withAspectHandling(int n) {
		return riskyCompute(n);
	}

	private int riskyCompute(int n) {
		throw new RiskyException("Exception");
	}
}
