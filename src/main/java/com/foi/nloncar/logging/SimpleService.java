package com.foi.nloncar.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleService {

	private static final Logger LOG = Logger.getLogger(SimpleService.class.getName());

	public long withInlineLogging(int n) {
		long start = System.nanoTime();
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("entering withInlineLogging n=" + n);
		}

		long result = doWork(n);
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine("exiting withInlineLogging result=" + result
					+ " durationNs=" + (System.nanoTime() - start));
		}

		return result;
	}

	public long withAspectLogging(int n) {
		return doWork(n);
	}

	private long doWork(int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		return sum;
	}
}
