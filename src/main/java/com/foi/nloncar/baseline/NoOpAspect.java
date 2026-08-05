package com.foi.nloncar.baseline;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class NoOpAspect {

	@Around("execution(* com.foi.nloncar.baseline.NoOpTarget.advisedNoOp())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		return pjp.proceed();
	}
}
