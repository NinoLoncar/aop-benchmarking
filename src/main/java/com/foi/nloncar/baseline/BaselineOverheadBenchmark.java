package com.foi.nloncar.baseline;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(5)
@State(Scope.Thread)
public class BaselineOverheadBenchmark {

	private final NoOpTarget target = new NoOpTarget();

	@Benchmark
	public int plain() {
		return target.plainNoOp();
	}

	@Benchmark
	public int advised() {
		return target.advisedNoOp();
	}
}
