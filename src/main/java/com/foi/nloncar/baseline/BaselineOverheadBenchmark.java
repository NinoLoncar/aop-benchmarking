package com.foi.nloncar.baseline;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(3)
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
