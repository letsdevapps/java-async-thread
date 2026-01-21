package com.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.pro.async.BlockSync;
import com.pro.async.MethodSync;
import com.pro.async.RaceConditionProblem;
import com.pro.async.SimpleThread;
import com.pro.util.BlockSharedCounter;
import com.pro.util.MethodSharedCounter;
import com.pro.util.RCPSharedCounter;

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

		System.out.println("----- Java Async Thread | Method Syncronization -----");

		// Cria um pool de 3 threads
		ExecutorService executorSync = Executors.newFixedThreadPool(3);

		// Cria um contador compartilhado entre as threads
		MethodSharedCounter counter = new MethodSharedCounter();

		// Envia 5 tarefas para o executor
		for (int i = 1; i <= 5; i++) {
			executorSync.submit(new MethodSync(counter));
		}

		// Fecha o ExecutorService após todas as tarefas serem executadas
		executorSync.shutdown();

		System.out.println("----- Java Async Thread | Block Syncronization -----");

		// Cria um pool de 3 threads
		ExecutorService executorBlock = Executors.newFixedThreadPool(3);

		// Cria um contador compartilhado entre as threads
		BlockSharedCounter counterBlock = new BlockSharedCounter();

		// Envia 5 tarefas para o executor
		for (int i = 1; i <= 5; i++) {
			executorBlock.submit(new BlockSync(counterBlock));
		}

		// Fecha o ExecutorService após todas as tarefas serem executadas
		executorBlock.shutdown();

		System.out.println("----- Java Async Thread | Race Condition Problem -----");
		// Note que o valor não chega a 5, porque as threads estão interferindo uma na outra.
		
		// Cria um pool de 3 threads
        ExecutorService executorRCP = Executors.newFixedThreadPool(3);

        // Cria um contador compartilhado entre as threads
        RCPSharedCounter counterRCP = new RCPSharedCounter();

        // Envia 5 tarefas para o executor
        for (int i = 1; i <= 5; i++) {
            executorRCP.submit(new RaceConditionProblem(counterRCP));
        }

        // Fecha o ExecutorService após todas as tarefas serem executadas
        executorRCP.shutdown();
	}
}