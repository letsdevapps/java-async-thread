package com.pro.util;

public class MethodSharedCounter {
	private int count = 0;

	// Método sincronizado - só uma thread pode acessar ao mesmo tempo
	public synchronized void increment() {
		count++;
		System.out.println(Thread.currentThread().getName() + " - Incrementou o contador: " + count);
	}

	// Método para obter o valor atual do contador
	public int getCount() {
		return count;
	}
}