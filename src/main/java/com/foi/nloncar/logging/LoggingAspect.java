package com.foi.nloncar.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

	private static final Logger LOG = Logger.getLogger(LoggingAspect.class.getName());

	@Around("execution(* com.foi.nloncar.logging.SimpleService.withAspectLogging(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();

		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("entering " + pjp.getSignature().toShortString()
					+ " args=" + Arrays.toString(pjp.getArgs()));
		}

		Object result = pjp.proceed();

		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("exiting " + pjp.getSignature().toShortString()
					+ " result=" + result + " durationNs=" + (System.nanoTime() - start));
		}

		return result;
	}
}
