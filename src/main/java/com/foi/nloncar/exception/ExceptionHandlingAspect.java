package com.foi.nloncar.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionHandlingAspect {
	@Around("execution(* com.foi.nloncar.exception.RiskyService.withAspectHandling(..))")
	public Object handleFailure(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (RiskyException e) {
			return -1;
		}
	}
}
