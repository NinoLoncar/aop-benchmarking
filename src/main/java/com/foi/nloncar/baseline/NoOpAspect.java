package com.foi.nloncar.baseline;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class NoOpAspect {

	@After("execution(* com.foi.nloncar.baseline.NoOpTarget.advisedNoOp())")
	public void after() {
	}
}
