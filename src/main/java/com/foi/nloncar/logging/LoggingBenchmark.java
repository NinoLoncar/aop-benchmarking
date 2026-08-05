package com.foi.nloncar.logging;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(3)
@State(Scope.Thread)
public class LoggingBenchmark {

	private final SimpleService simpleService = new SimpleService();

	@Param({"10", "1000"})
	private int n;

	@Benchmark
	public long inlineLogging() {
		return simpleService.withInlineLogging(n);
	}

	@Benchmark
	public long aspectLogging() {
		return simpleService.withAspectLogging(n);
	}
}
