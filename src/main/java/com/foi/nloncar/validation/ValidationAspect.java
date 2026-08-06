package com.foi.nloncar.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ValidationAspect {

	@Before("execution(* com.foi.nloncar.validation.CalculationService.withAspectValidation(..))")
	public void validateArgs(JoinPoint jp) {
		Object[] args = jp.getArgs();
		int a = (Integer) args[0];
		int b = (Integer) args[1];
		int c = (Integer) args[2];
		if (a < 0 || b < 0 || c < 0) {
			throw new IllegalArgumentException("arguments must be non-negative");
		}
	}
}
