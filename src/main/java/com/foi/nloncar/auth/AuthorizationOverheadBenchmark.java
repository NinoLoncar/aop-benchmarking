package com.foi.nloncar.auth;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(5)
@State(Scope.Thread)
public class AuthorizationOverheadBenchmark {

	private final AccountService service = new AccountService();

	@Benchmark
	public long inlineCheck() {
		return service.withInlineCheck(1000);
	}

	@Benchmark
	public long aspectCheck() {
		return service.withAspectCheck(1000);
	}
}
