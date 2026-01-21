package com.pro.async;

import com.pro.util.AtomicIntegerSharedCounter;

public class AtomicIntegerSync implements Runnable {
	private AtomicIntegerSharedCounter counter;

	public AtomicIntegerSync(AtomicIntegerSharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// Cada thread tenta incrementar o contador
		counter.increment();
	}
}