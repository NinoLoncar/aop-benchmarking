package com.foi.nloncar.caching;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CalculationService {

	private final Map<Integer, Integer> cache = new ConcurrentHashMap<>();

	public Integer withInlineCache(Integer n) {
		Integer cached = cache.get(n);
		if (cached != null) {
			return cached;
		}
		Integer result = compute(n);
		cache.put(n, result);
		return result;
	}

	public Integer withAspectCache(Integer n) {
		return compute(n);
	}

	private Integer compute(Integer n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += i * i;
		}
		return result;
	}
}
