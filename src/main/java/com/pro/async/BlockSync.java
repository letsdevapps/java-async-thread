package com.pro.async;

import com.pro.util.BlockSharedCounter;

public class BlockSync implements Runnable {

	private BlockSharedCounter counter;

	public BlockSync(BlockSharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// Cada thread tenta incrementar o contador
		counter.increment();
	}
}