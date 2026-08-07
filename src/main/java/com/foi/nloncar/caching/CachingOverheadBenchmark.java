package com.foi.nloncar.caching;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(5)
@State(Scope.Thread)
public class CachingOverheadBenchmark {

	private final CalculationService service = new CalculationService();

	@Benchmark
	public int inlineCache() {
		return service.withInlineCache(100);
	}

	@Benchmark
	public int aspectCache() {
		return service.withAspectCache(100);
	}
}
