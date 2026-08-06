package com.foi.nloncar.validation;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(3)
@State(Scope.Thread)
public class ValidationBenchmark {

	private final CalculationService target = new CalculationService();

	@Benchmark
	public int plain() {
		return target.withInlineValidation(1000, 2000, 3000);
	}

	@Benchmark
	public int advised() {
		return target.withAspectValidation(1000, 2000, 3000);
	}
}
