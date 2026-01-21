package com.pro.async;

import com.pro.util.MethodSharedCounter;

public class MethodSyncThread implements Runnable {

	private MethodSharedCounter counter;

	public MethodSyncThread(MethodSharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// Cada thread tenta incrementar o contador
		counter.increment();
	}
}