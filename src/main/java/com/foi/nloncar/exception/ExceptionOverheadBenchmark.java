package com.foi.nloncar.exception;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(5)
@State(Scope.Thread)
public class ExceptionOverheadBenchmark {

	private final RiskyService service = new RiskyService();

	@Benchmark
	public int inlineExceptionHandling() {
		return service.withInlineHandling(0);
	}

	@Benchmark
	public int aspectExceptionHandling() {
		return service.withAspectHandling(0);
	}
}
