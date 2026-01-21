package com.pro.async;

import com.pro.util.RCPSharedCounter;

public class RaceConditionProblem implements Runnable {
	private RCPSharedCounter counter;

	public RaceConditionProblem(RCPSharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// Cada thread tenta incrementar o contador
		counter.increment();
	}
}