package com.foi.nloncar.validation;

public class CalculationService {

	public int withInlineValidation(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			throw new IllegalArgumentException("arguments must be non-negative");
		}
		return sum(a, b, c);
	}

	public int withAspectValidation(int a, int b, int c) {
		return sum(a, b, c);
	}

	private int sum(int a, int b, int c) {
		return a + b + c;
	}
}
