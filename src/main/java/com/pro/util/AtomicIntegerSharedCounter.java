package com.pro.util;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSharedCounter {
	private AtomicInteger count = new AtomicInteger(0);

	public void increment() {
		int newValue = count.incrementAndGet();
		System.out.println(Thread.currentThread().getName() + " - Incrementou o contador: " + newValue);
	}

	public int getCount() {
		return count.get();
	}
}