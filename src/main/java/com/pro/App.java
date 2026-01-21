package com.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.pro.async.BlockSyncThread;
import com.pro.async.MethodSyncThread;
import com.pro.async.SimpleThread;
import com.pro.util.BlockSharedCounter;
import com.pro.util.MethodSharedCounter;

public class App {
	public static void main(String[] args) {
		System.out.println("----- Java Async Thread | Main -----");

		System.out.println("----- Java Async Thread | Simple Thread -----");
		// Cria um pool de 3 threads
		ExecutorService executorSimple = Executors.newFixedThreadPool(3);

		// Cria um pool de threads com quantidade dinâmico
//        ExecutorService executorSimple = Executors.newCachedThreadPool();

		// Envia 5 tarefas para execução
		for (int i = 1; i <= 5; i++) {
			executorSimple.submit(new SimpleThread(i));
		}

		// Fecha o ExecutorService após todas as tarefas serem executadas
		executorSimple.shutdown();

		System.out.println("----- Java Async Thread | Method Syncronization Thread -----");

		// Cria um pool de 3 threads
		ExecutorService executorSync = Executors.newFixedThreadPool(3);

		// Cria um contador compartilhado entre as threads
		MethodSharedCounter counter = new MethodSharedCounter();

		// Envia 5 tarefas para o executor
		for (int i = 1; i <= 5; i++) {
			executorSync.submit(new MethodSyncThread(counter));
		}

		// Fecha o ExecutorService após todas as tarefas serem executadas
		executorSync.shutdown();

		System.out.println("----- Java Async Thread | Block Syncronization Thread -----");

		// Cria um pool de 3 threads
		ExecutorService executorBlock = Executors.newFixedThreadPool(3);

		// Cria um contador compartilhado entre as threads
		BlockSharedCounter counterBlock = new BlockSharedCounter();

		// Envia 5 tarefas para o executor
		for (int i = 1; i <= 5; i++) {
			executorBlock.submit(new BlockSyncThread(counterBlock));
		}

		// Fecha o ExecutorService após todas as tarefas serem executadas
		executorBlock.shutdown();
	}
}