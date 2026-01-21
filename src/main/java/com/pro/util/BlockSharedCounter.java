package com.pro.util;

public class BlockSharedCounter {
	private int count = 0;

	// Método com sincronização em bloco de código
	public void increment() {
		synchronized (this) { // Sincronizando apenas a parte crítica
			count++;
			System.out.println(Thread.currentThread().getName() + " - Incrementou o contador: " + count);
		}
	}

	// Método para obter o valor atual do contador
	public int getCount() {
		return count;
	}
}