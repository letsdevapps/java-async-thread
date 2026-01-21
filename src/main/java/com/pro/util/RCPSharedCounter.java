package com.pro.util;

public class RCPSharedCounter {
	private int count = 0;

	// Método sem sincronização - condição de corrida
	public void increment() {
		count++; // Operação não atômica
		System.out.println(Thread.currentThread().getName() + " - Incrementou o contador: " + count);
	}

	// Método para obter o valor atual do contador
	public int getCount() {
		return count;
	}
}