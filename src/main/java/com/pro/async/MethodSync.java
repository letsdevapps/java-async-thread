package com.pro.async;

import com.pro.util.MethodSharedCounter;

public class MethodSync implements Runnable {

	private MethodSharedCounter counter;

	public MethodSync(MethodSharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// Cada thread tenta incrementar o contador
		counter.increment();
	}
}