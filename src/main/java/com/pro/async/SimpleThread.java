package com.pro.async;

public class SimpleThread implements Runnable {

	private int taskId;

	public SimpleThread(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " está processando a tarefa " + taskId);
		try {
			// Simula um trabalho (por exemplo, processando algo por 2 segundos)
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Tarefa " + taskId + " concluída.");
	}
}