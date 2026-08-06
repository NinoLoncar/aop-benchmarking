package com.foi.nloncar.caching;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
public class CachingAspect {

	private final Map<Object, Object> cache = new ConcurrentHashMap<>();

	@Around("execution(* com.foi.nloncar.caching.CalculationService.withAspectCache(..))")
	public Object cacheAround(ProceedingJoinPoint pjp) throws Throwable {
		Object key = pjp.getArgs()[0];
		Object cached = cache.get(key);
		if (cached != null) {
			return cached;
		}
		Object result = pjp.proceed();
		cache.put(key, result);
		return result;
	}
}
